package me.branchpanic.mods.materialmagic;

import net.minecraftforge.common.MinecraftForge;
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
@Mod("materialmagic")
public class MaterialMagicMod {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Marker MARKER = MarkerManager.getMarker("LOADING");

    private static boolean initialized = false;
    private static MaterialMagicMod instance = null;

    /**
     * Constructs and assigns the running instance of Material Magic. This is only for use by Forge, but you probably
     * knew that already!
     *
     * @throws IllegalStateException if called more than once.
     */
    public MaterialMagicMod() {
        if (initialized) {
            throw new IllegalStateException("Attempted to construct a new mod instance!");
        }

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

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

    /**
     * Performs initial setup on both sides.
     */
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info(MARKER, "hello!");
    }
}
