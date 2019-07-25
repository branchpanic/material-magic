package me.branchpanic.mods.materialmagic.capability;

import me.branchpanic.mods.materialmagic.api.magic.affinity.Affinity;
import me.branchpanic.mods.materialmagic.api.magic.affinity.AffinityBinding;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.registries.IForgeRegistry;

public class MaterialMagicCapabilities {
    @CapabilityInject(AffinityBinding.class)
    public static Capability<AffinityBinding> AFFINITY_BINDING_CAPABILITY = null;

    private static boolean initialized = false;

    private MaterialMagicCapabilities() {
        // NO-OP
    }

    public static void registerAll(IForgeRegistry<Affinity> affinityRegistry) {
        if (initialized) {
            throw new IllegalStateException("Attempted to register Material Magic capabilities more than once!");
        }

        CapabilityManager.INSTANCE.register(
                AffinityBinding.class,
                new MutableAffinityBindingStorage(affinityRegistry),
                () -> new MutableAffinityBinding(null)
        );

        initialized = true;
    }
}
