---
inject: true
to: src/main/java/me/branchpanic/mods/materialmagic/MaterialMagicRegistrar.java
skip_if: <%= name %>
after: "package me.branchpanic.mods.materialmagic;"
message: Remember to reformat so imports stay organized.
---
import me.branchpanic.mods.materialmagic.block.<%=Name%>Block;