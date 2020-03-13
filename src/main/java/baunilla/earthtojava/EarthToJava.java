package baunilla.earthtojava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baunilla.earthtojava.init.BlockInit;
import baunilla.earthtojava.init.ItemInit;
import baunilla.earthtojava.world.OreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("earthtojava")
@Mod.EventBusSubscriber(modid = EarthToJava.MOD_ID, bus = Bus.MOD)
public class EarthToJava {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "earthtojava";
    public static EarthToJava instance;

    public EarthToJava() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        // TileEnityType here

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ItemGroup.MATERIALS);
            final BlockItem blockItem = new BlockItem(block, properties);

            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);

            LOGGER.debug("Registered " + blockItem.getRegistryName() + "BlockItem");
        });

        LOGGER.debug("Registerd all BlockItems");
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