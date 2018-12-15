package ru.bench.equivalentstone.recipes.food;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class FoodCarrotToApple extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.food_apple;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.food_carrot), Ingredient.fromStacks(Main.food_carrot)};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":food_carrot_to_apple"), new ResourceLocation("custom"), recStack, recipe);
    }
}