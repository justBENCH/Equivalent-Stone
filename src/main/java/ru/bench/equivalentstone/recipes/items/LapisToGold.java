package ru.bench.equivalentstone.recipes.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class LapisToGold extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = new ItemStack(Items.GOLD_INGOT, 2);
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.lapis), Ingredient.fromStacks(Main.lapis),
                Ingredient.fromStacks(Main.lapis), Ingredient.fromStacks(Main.lapis),
                Ingredient.fromStacks(Main.lapis), Ingredient.fromStacks(Main.lapis),
                Ingredient.fromStacks(Main.lapis), Ingredient.fromStacks(Main.lapis),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":lapis_to_gold"), new ResourceLocation("custom"), recStack, recipe);
    }
}
