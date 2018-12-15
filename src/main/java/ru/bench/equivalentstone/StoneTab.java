package ru.bench.equivalentstone;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StoneTab extends Main.ModElement {

    public static CreativeTabs tab = new CreativeTabs("tab_equivalentstone") {

        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(StoneItem.block, (int) (1));
        }

        @SideOnly(Side.CLIENT)
        public boolean hasSearchBar() {
            return true;
        }
    }.setBackgroundImageName("item_search.png");

}
