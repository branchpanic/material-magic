# material-magic

A magic mod based on the wonders of your world.

## Setup

### Hygen

#### Overview

In addition to the standard Forge workspace, [Hygen](http://www.hygen.io/) is strongly recommended to greatly reduce
the time needed to add simple Blocks and Items that still require custom implementations. For example, running the
command:

```
hygen block with-class something
```

will do all of the following for you:

- Create a functional `SomethingBlock` class in `me.branchpanic.mods.materialmagic.block`
- Import and add it to the master list in `MaterialMagicRegistrar`
- Add a default en_US localization "Something"
- Create a blockstate with a texture `materialmagic:block/something`

Remember that the generated code isn't perfect, but saves a lot of copy-pasting.

Hygen is available on NPM (and also as a [binary](https://github.com/jondot/hygen/releases) if you don't have/want a
Node environment):

```
npm install -g hygen
```

#### Generators

- block
  - with-class (CamelCase name with no "Block" suffix)
    - Creates a Block class
    - Registers an instance of the new class
    - Creates a stub blockstate
    - Creates a lang file entry