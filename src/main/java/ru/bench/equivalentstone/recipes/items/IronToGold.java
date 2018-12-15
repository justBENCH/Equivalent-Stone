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

public class IronToGold extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
            ItemStack recStack = Main.gold;
            Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                    Ingredient.fromStacks(Main.iron), Ingredient.fromStacks(Main.iron),
                    Ingredient.fromStacks(Main.iron), Ingredient.fromStacks(Main.iron),
                    Ingredient.fromStacks(Main.iron), Ingredient.fromStacks(Main.iron),
                    Ingredient.fromStacks(Main.iron), Ingredient.fromStacks(Main.iron),};
            GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID + ":iron_to_gold"), new ResourceLocation("custom"), recStack, recipe);
    }
}


