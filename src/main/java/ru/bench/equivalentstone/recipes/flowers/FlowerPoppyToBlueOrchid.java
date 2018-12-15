package ru.bench.equivalentstone.recipes.flowers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class FlowerPoppyToBlueOrchid extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.flower_blue_orchid;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.flower_poppy),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":flower_flower_poppy_to_blue_orchid"), new ResourceLocation("custom"), recStack, recipe);
    }
}