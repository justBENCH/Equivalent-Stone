package ru.bench.equivalentstone;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

public class StoneItem extends Main.ModElement {

    public static Item block;
    static {
        block = (new ItemCustom());
    }

    @Override
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                    .register(block, 0, new ModelResourceLocation(Main.MODID+":equivalent_stone", "inventory"));
        }
    }

    public static class ItemCustom extends Item {

        public ItemCustom() {
            ModConfig.preInit();

            if (ModConfig.InfiniteUse == false) {
                setMaxDamage(ModConfig.Durability);
                setNoRepair();
            }
            maxStackSize = 1;

            setUnlocalizedName("equivalent_stone");
            setRegistryName("equivalent_stone");
            setCreativeTab(StoneTab.tab);
            setContainerItem(this);
            ForgeRegistries.ITEMS.register(this);
        }

        @Override
        public boolean hasContainerItem(ItemStack par1ItemStack) {
            return true;
        }

        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }

        @Override
        public ItemStack getContainerItem(ItemStack par1ItemStack) {
            ItemStack result = par1ItemStack.copy();
            if (ModConfig.InfiniteUse == false) {
                result.setItemDamage(result.getItemDamage() + 1);

                if (result.getItemDamage() >= result.getMaxDamage())
                    return ItemStack.EMPTY;
                return result;
            } else return result;
        }

        @Override
        public int getItemEnchantability() {
            return 0;
        }

        @Override
        public int getMaxItemUseDuration(ItemStack par1ItemStack) {
            return 0;
        }

        @Override
        public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
            return 1F;
        }

        @Override
        public EnumRarity getRarity(ItemStack itemStack) {
            return EnumRarity.EPIC;
        }

    }
}

