package baunilla.earthtojava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baunilla.earthtojava.world.OreGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("earthtojava")
@Mod.EventBusSubscriber(modid = EarthToJava.MOD_ID, bus = Bus.MOD)
public class EarthToJava {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "earthtojava";
    public static EarthToJava instance;

    public EarthToJava() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setup Method Registred");
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        OreGen.generateOre();

        LOGGER.info("Load Complete Event");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Client Setup Method Registred");
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

}