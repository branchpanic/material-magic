package me.branchpanic.mods.materialmagic.capability;

import me.branchpanic.mods.materialmagic.MaterialMagicMod;
import me.branchpanic.mods.materialmagic.api.magic.affinity.Affinity;
import me.branchpanic.mods.materialmagic.api.magic.affinity.AffinityBinding;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ResourceLocationException;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import javax.annotation.Nullable;
import java.util.Objects;

public class MutableAffinityBindingStorage implements Capability.IStorage<AffinityBinding> {
    private static final Logger LOGGER = LogManager.getLogger(MaterialMagicMod.ID);
    private static final Marker MARKER = MarkerManager.getMarker("Capability");

    private final IForgeRegistry<Affinity> affinityRegistry;

    public MutableAffinityBindingStorage(IForgeRegistry<Affinity> affinityRegistry) {
        this.affinityRegistry = affinityRegistry;
    }

    @Nullable
    @Override
    public INBT writeNBT(Capability<AffinityBinding> capability, AffinityBinding instance, Direction
            side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("AffinityName", instance.getAffinity()
                .map(a -> Objects.requireNonNull(a.getRegistryName()).toString())
                .orElse(""));
        return tag;
    }

    @Override
    public void readNBT(Capability<AffinityBinding> capability, AffinityBinding instance, Direction side, INBT nbt) {
        if (!(nbt instanceof CompoundNBT)) {
            LOGGER.error(MARKER, "Attempted to load an AffinityBinding from the wrong type of NBT tag. " +
                    "Ignoring it -- the game may be in an unstable state from this point on!");
            return;
        }

        if (!(instance instanceof MutableAffinityBinding)) {
            LOGGER.error(MARKER, "Attempted to load a custom AffinityBinding with the default storage implementation. " +
                    "Ignoring it -- the game may be in an unstable state from this point on!");
            return;
        }

        MutableAffinityBinding affinityBinding = (MutableAffinityBinding) instance;
        CompoundNBT compoundNBT = (CompoundNBT) nbt;
        String storedAffinityName = compoundNBT.getString("AffinityName");

        if (storedAffinityName.equals("")) {
            affinityBinding.setAffinity(null);
            return;
        }

        ResourceLocation affinityName;

        try {
            affinityName = new ResourceLocation(storedAffinityName);
        } catch (ResourceLocationException e) {
            throw new ResourceLocationException("Encountered an illegal resource name when trying to load an AffinityBinding", e);
        }

        if (!affinityRegistry.containsKey(affinityName)) {
            LOGGER.warn(MARKER, "Clearing missing affinity {}", affinityName);
            affinityBinding.setAffinity(null);
        }

        affinityBinding.setAffinity(affinityRegistry.getValue(affinityName));
    }
}
