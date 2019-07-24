---
inject: true
to: src/main/java/me/branchpanic/mods/materialmagic/MaterialMagicRegistrar.java
after: "private static final ImmutableList<Block> BLOCKS = ImmutableList.<Block>builder()"
---
            .add(new Block(Block.Properties.create(Material.ROCK))
                    .setRegistryName(MaterialMagic.ID, "<%=h.inflection.underscore(name)%>"))