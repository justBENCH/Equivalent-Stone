package ru.bench.equivalentstone.recipes.saplings;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class SaplingAcaciaToDarkOak extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.sapling_dark_oak;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.sapling_acacia),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":sapling_acacia_to_dark_oak"), new ResourceLocation("custom"), recStack, recipe);
    }
}