package ru.bench.equivalentstone.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.bench.equivalentstone.Main;
import ru.bench.equivalentstone.StoneItem;

public class itemEquivalentStone extends Main.ModElement {

    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = new ItemStack(StoneItem.block, 1);
        Ingredient[] recipe = {Ingredient.fromStacks(Main.charcoal),
                Ingredient.fromStacks(Main.coal), Ingredient.fromStacks(Main.iron),
                Ingredient.fromStacks(Main.diamond), Ingredient.fromStacks(Main.stone),
                Ingredient.fromStacks(Main.emerald), Ingredient.fromStacks(Main.gold),
                Ingredient.fromStacks(Main.redstone), Ingredient.fromStacks(Main.lapis),};
        GameRegistry.addShapelessRecipe(new ResourceLocation(Main.MODID+":equivalentstone"), new ResourceLocation("custom"), recStack, recipe);
    }
}
