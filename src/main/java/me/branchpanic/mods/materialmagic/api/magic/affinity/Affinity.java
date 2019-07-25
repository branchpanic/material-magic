package me.branchpanic.mods.materialmagic.api.magic.affinity;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * An Affinity is a distinct element of magic.
 */
public interface Affinity extends IForgeRegistryEntry<Affinity> {

    /**
     * Gets affinities that complement or otherwise align with this affinity in some way. Players who bind to this
     * affinity will receive partial benefits of the affinities included in this list.
     */
    default List<Affinity> getFavoredAffinities() {
        return Collections.emptyList();
    }

    /**
     * Gets affinities that oppose or otherwise conflict with this affinity. Players who bind to this affinity will
     * not be able to take advantage of any affinities included in this list.
     */
    default List<Affinity> getOpposingAffinities() {
        return Collections.emptyList();
    }

    /**
     * Gets the translation key used to determine the name of this affinity.
     */
    default String getNameTranslationKey() {
        ResourceLocation registryName = Objects.requireNonNull(getRegistryName());
        return String.format("affinity.%s.%s.name", registryName.getNamespace(), registryName.getPath());
    }

    /**
     * Gets a ResourceLocation pointing to a square icon to use for this affinity.
     */
    default ResourceLocation getIconLocation() {
        ResourceLocation registryName = Objects.requireNonNull(getRegistryName());
        return new ResourceLocation(
                registryName.getNamespace(),
                String.format("textures/affinity/%s.png", registryName.getPath())
        );
    }
}
