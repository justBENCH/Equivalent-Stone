package ru.bench.equivalentstone.recipes.mushrooms;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class MushroomBrownToRed extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.mushroom_red;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.mushroom_brown),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":mushroom_brown_to_red"), new ResourceLocation("custom"), recStack, recipe);
    }
}