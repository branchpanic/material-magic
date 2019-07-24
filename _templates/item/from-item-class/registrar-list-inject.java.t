---
inject: true
to: src/main/java/me/branchpanic/mods/materialmagic/MaterialMagicRegistrar.java
after: "private static final ImmutableList<Item> ITEMS = ImmutableList.<Item>builder()"
---
            .add(new Item(new Item.Properties())
                    .setRegistryName(MaterialMagic.ID, "<%=h.inflection.underscore(name)%>"))