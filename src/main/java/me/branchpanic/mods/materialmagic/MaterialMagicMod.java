package me.branchpanic.mods.materialmagic;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * MaterialMagicMod is the running, game-bound instance of Material Magic.
 * <p>
 * Only hard-reference this class in Forge events! Consider delegating all functionality to an interface to improve
 * what little testability is possible.
 */
@Mod(MaterialMagicMod.ID)
public class MaterialMagicMod {
    public static final String ID = "materialmagic";

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Marker MARKER = MarkerManager.getMarker("LOADING");

    private static boolean initialized = false;
    private static MaterialMagicMod instance = null;

    private final MaterialMagicRegistrar registrar;

    /**
     * Constructs and assigns the running instance of Material Magic. This is only for use by Forge, but you probably
     * knew that already!
     *
     * @throws IllegalStateException if called more than once.
     */
    public MaterialMagicMod() {
        if (initialized) {
            throw new IllegalStateException("Attempted to construct multiple running mod instances!");
        }

        IEventBus modEvents = FMLJavaModLoadingContext.get().getModEventBus();
        modEvents.addListener(this::setup);

        MaterialMagicRegistrar registrar = new MaterialMagicRegistrar();
        modEvents.register(registrar);
        this.registrar = registrar;

        initialized = true;
        instance = this;
    }

    /**
     * Gets the game-bound instance of Material Magic.
     *
     * @throws IllegalStateException if called before Forge has loaded Material Magic.
     */
    public static MaterialMagicMod getInstance() {
        if (!initialized) {
            throw new IllegalStateException();
        }

        return instance;
    }

    public MaterialMagicRegistrar getRegistrar() {
        return registrar;
    }

    /**
     * Performs initial setup on both sides.
     */
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info(MARKER, "hello!");
    }
}
