package baunilla.earthtojava.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import baunilla.earthtojava.EarthToJava;

@Mod.EventBusSubscriber(modid = EarthToJava.MOD_ID, bus = Bus.MOD)
@ObjectHolder(EarthToJava.MOD_ID)
public class ItemInit {
    public static final Item ruby = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS).rarity(Rarity.UNCOMMON)).setRegistryName("ruby"));
    }
}