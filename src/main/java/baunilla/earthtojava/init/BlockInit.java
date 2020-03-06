package baunilla.earthtojava.init;

import baunilla.earthtojava.EarthToJava;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(EarthToJava.MOD_ID)
@Mod.EventBusSubscriber(modid = EarthToJava.MOD_ID, bus = Bus.MOD) 
public class BlockInit {
    public static final Block ruby_block = null;
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL)).setRegistryName("ruby_block"));
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.UNCOMMON)).setRegistryName("ruby_block"));
    }
}