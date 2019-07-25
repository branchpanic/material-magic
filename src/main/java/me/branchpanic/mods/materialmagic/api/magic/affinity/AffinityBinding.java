package me.branchpanic.mods.materialmagic.api.magic.affinity;

import java.util.Optional;

/**
 * An AffinityBinding associates an object with an Affinity.
 */
public interface AffinityBinding {

    /**
     * Gets the affinity instance this object is bound to or an empty Optional if it is currently unbound.
     */
    Optional<Affinity> getAffinity();
}
