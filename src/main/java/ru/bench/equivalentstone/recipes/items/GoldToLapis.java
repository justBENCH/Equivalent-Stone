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

public class GoldToLapis extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = new ItemStack(Items.DYE, 8, 4);
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.gold), Ingredient.fromStacks(Main.gold),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":gold_to_lapis"), new ResourceLocation("custom"), recStack, recipe);
    }
}
