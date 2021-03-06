package ru.bench.equivalentstone.recipes.flowers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class FlowerAlliumToAzureBluet extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.flower_azure_bluet;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.flower_allium),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":flower_allium_to_azure_bluet"), new ResourceLocation("custom"), recStack, recipe);
    }
}