---
to: src/main/resources/assets/materialmagic/blockstates/<%=h.inflection.underscore(name)%>.json
---
{
    "forge_marker": 1,
    "defaults": {
        "textures": {
            "all": "materialmagic:blocks/<%=h.inflection.underscore(name)%>"
        },
        "model": "cube_all",
        "uvlock": true
    },
    "variants": {
    }
}
