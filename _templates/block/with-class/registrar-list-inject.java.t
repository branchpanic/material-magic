---
inject: true
to: src/main/java/me/branchpanic/mods/materialmagic/MaterialMagicRegistrar.java
skip_if: <%= name %>
after: "private static final ImmutableList<Block> BLOCKS = ImmutableList.<Block>builder()"
---
            .add(new <%= Name %>Block())