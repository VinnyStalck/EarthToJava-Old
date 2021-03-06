package baunilla.earthtojava.init;

import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import baunilla.earthtojava.EarthToJava;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EarthToJava.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> HORN = ITEMS.register("horn", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS))); 

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register("ruby_block", () -> new BlockItem(BlockInit.RUBY_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", () -> new BlockItem(BlockInit.RUBY_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> BUTTERCUP = ITEMS.register("buttercup", () -> new BlockItem(BlockInit.BUTTERCUP.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    // Spawn Egg Items
    public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2) {
        SpawnEggItem EGG = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
        return EGG;
    }

}