package ru.bench.equivalentstone.recipes.flowers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class FlowerOxeyeDaisyToDandelion extends Main.ModElement{

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = Main.flower_dandelion;
        Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(StoneItem.block, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(Main.flower_oxeye_daisy),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":flower_oxeye_daisy_to_dandelion"), new ResourceLocation("custom"), recStack, recipe);
    }
}