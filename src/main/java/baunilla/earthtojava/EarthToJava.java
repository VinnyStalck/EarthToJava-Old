package baunilla.earthtojava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("earthtojava")
/**
 * EarthToJava
 */
public class EarthToJava {
    private static final Logger LOGGER = LogManager.getLogger();

    public EarthToJava() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setup Method Registred");
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Client Setup Method Registred");
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
}