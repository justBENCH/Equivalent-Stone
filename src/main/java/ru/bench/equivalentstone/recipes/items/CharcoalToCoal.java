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

public class CharcoalToCoal extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.coal;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.charcoal), Ingredient.fromStacks(Main.charcoal),
                Ingredient.fromStacks(Main.charcoal), Ingredient.fromStacks(Main.charcoal),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":charcoal_to_coal"), new ResourceLocation("custom"), recStack, recipe);
    }
}
