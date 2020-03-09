package baunilla.earthtojava.init;

import baunilla.earthtojava.EarthToJava;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(EarthToJava.MOD_ID)
@Mod.EventBusSubscriber(modid = EarthToJava.MOD_ID, bus = Bus.MOD)
public class BlockInit {
    public static final Block ruby_block = null;
    public static final Block ruby_ore = null;
    
    public static final Block buttercup = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL)).setRegistryName("ruby_block"));
        event.getRegistry().register(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f)).setRegistryName("ruby_ore")); 
        
        event.getRegistry().register(new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0f).sound(SoundType.PLANT)).setRegistryName("buttercup")); 
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.UNCOMMON)).setRegistryName("ruby_block"));
        event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.UNCOMMON)).setRegistryName("ruby_ore"));

        event.getRegistry().register(new BlockItem(buttercup, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName("buttercup"));
    }
}