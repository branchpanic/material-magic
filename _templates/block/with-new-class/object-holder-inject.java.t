---
inject: true
to: src/main/java/me/branchpanic/mods/materialmagic/block/MaterialMagicBlocks.java
after: "public class MaterialMagicBlocks {"
---
    public static final Block <%=h.inflection.underscore(name).toUpperCase()%> = null;