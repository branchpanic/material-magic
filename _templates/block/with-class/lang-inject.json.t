---
inject: true
to: src/main/resources/assets/materialmagic/lang/en_us.json
skip_if: <%= name %>
after: '"//": "blocks",'
---
  "block.materialmagic.<%=h.inflection.underscore(name)%>": "<%=Name%>",