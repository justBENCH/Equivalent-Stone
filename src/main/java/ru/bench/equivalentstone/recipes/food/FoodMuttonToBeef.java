package ru.bench.equivalentstone.recipes.food;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class FoodMuttonToBeef extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.food_cooked_beef;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.food_cooked_mutton)};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":food_mutton_to_beef"), new ResourceLocation("custom"), recStack, recipe);
    }
}