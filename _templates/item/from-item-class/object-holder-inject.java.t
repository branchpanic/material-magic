---
inject: true
to: src/main/java/me/branchpanic/mods/materialmagic/item/MaterialMagicItems.java
after: "public class MaterialMagicItems {"
---
    public static final Item <%=h.inflection.underscore(name).toUpperCase()%> = null;