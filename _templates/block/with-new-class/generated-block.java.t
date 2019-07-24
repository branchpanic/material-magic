---
to: src/main/java/me/branchpanic/mods/materialmagic/block/<%=Name%>Block.java
---
package me.branchpanic.mods.materialmagic.block;

import me.branchpanic.mods.materialmagic.MaterialMagicMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class <%=Name%>Block extends Block {

    public <%=Name%>Block() {
        this(Block.Properties.create(Material.ROCK));
    }

    public <%=Name%>Block(Properties properties) {
        super(properties);
        setRegistryName(MaterialMagicMod.ID, "<%=h.inflection.underscore(name)%>");
    }
}
