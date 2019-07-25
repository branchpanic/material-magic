package me.branchpanic.mods.materialmagic.capability;

import me.branchpanic.mods.materialmagic.api.magic.affinity.Affinity;
import me.branchpanic.mods.materialmagic.api.magic.affinity.AffinityBinding;

import java.util.Optional;

/**
 * A MutableAffinityBinding is a mutable implementation of AffinityBinding.
 */
public class MutableAffinityBinding implements AffinityBinding {
    private Affinity affinity;

    public MutableAffinityBinding(Affinity affinity) {
        this.affinity = affinity;
    }

    @Override
    public Optional<Affinity> getAffinity() {
        return Optional.ofNullable(affinity);
    }

    /**
     * Sets the bound affinity. Setting this to null will clear the binding.
     */
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }
}
