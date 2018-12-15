package ru.bench.equivalentstone;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import ru.bench.equivalentstone.recipes.*;
import ru.bench.equivalentstone.recipes.blocks.*;
import ru.bench.equivalentstone.recipes.fish.*;
import ru.bench.equivalentstone.recipes.flowers.*;
import ru.bench.equivalentstone.recipes.food.*;
import ru.bench.equivalentstone.recipes.items.*;
import ru.bench.equivalentstone.recipes.mushrooms.*;
import ru.bench.equivalentstone.recipes.saplings.*;

import java.util.List;
import java.util.ArrayList;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)

public class Main {
    public static final String MODID = "equivalentstone";
    public static final String VERSION = "1.0.0";
    public static final String NAME = "Equivalent Stone";

    @SidedProxy(clientSide = "ru.bench.equivalentstone.ClientProxy", serverSide = "ru.bench.equivalentstone.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static Main instance;
    public static final List<ModElement> elements = new ArrayList<>();

    //items
    public static ItemStack charcoal = new ItemStack(Items.COAL,1,1);
    public static ItemStack coal = new ItemStack(Items.COAL,1);
    public static ItemStack iron = new ItemStack(Items.IRON_INGOT,1);
    public static ItemStack redstone = new ItemStack(Items.REDSTONE,1);
    public static ItemStack lapis = new ItemStack(Items.DYE,1,4);
    public static ItemStack gold = new ItemStack(Items.GOLD_INGOT,1);
    public static ItemStack diamond = new ItemStack(Items.DIAMOND,1);
    public static ItemStack emerald = new ItemStack(Items.EMERALD,1);
    public static ItemStack stone = new ItemStack(Blocks.STONE,1);

    //saplings
    public static ItemStack sapling_oak = new ItemStack(Blocks.SAPLING,1);
    public static ItemStack sapling_spruce = new ItemStack(Blocks.SAPLING,1,1);
    public static ItemStack sapling_birch = new ItemStack(Blocks.SAPLING,1,2);
    public static ItemStack sapling_jungle = new ItemStack(Blocks.SAPLING,1,3);
    public static ItemStack sapling_acacia = new ItemStack(Blocks.SAPLING,1,4);
    public static ItemStack sapling_dark_oak = new ItemStack(Blocks.SAPLING,1,5);

    //flowers
    public static ItemStack flower_dandelion = new ItemStack(Blocks.YELLOW_FLOWER,1);
    public static ItemStack flower_poppy = new ItemStack(Blocks.RED_FLOWER,1);
    public static ItemStack flower_blue_orchid = new ItemStack(Blocks.RED_FLOWER,1,1);
    public static ItemStack flower_allium = new ItemStack(Blocks.RED_FLOWER,1,2);
    public static ItemStack flower_azure_bluet = new ItemStack(Blocks.RED_FLOWER,1,3);
    public static ItemStack flower_red_tulip = new ItemStack(Blocks.RED_FLOWER,1,4);
    public static ItemStack flower_orange_tulip = new ItemStack(Blocks.RED_FLOWER,1,5);
    public static ItemStack flower_white_tulip = new ItemStack(Blocks.RED_FLOWER,1,6);
    public static ItemStack flower_pink_tulip = new ItemStack(Blocks.RED_FLOWER,1,7);
    public static ItemStack flower_oxeye_daisy = new ItemStack(Blocks.RED_FLOWER,1,8);

    //mushrooms
    public static ItemStack mushroom_brown = new ItemStack(Blocks.BROWN_MUSHROOM,1);
    public static ItemStack mushroom_red = new ItemStack(Blocks.RED_MUSHROOM,1);

    //fish
    public static ItemStack fish = new ItemStack(Items.FISH,1);
    public static ItemStack fish_salmon = new ItemStack(Items.FISH,1, 1);
    public static ItemStack fish_clown = new ItemStack(Items.FISH,1, 2);
    public static ItemStack fish_puffer = new ItemStack(Items.FISH,1, 3);

    //food
    public static ItemStack food_apple = new ItemStack(Items.APPLE,1);
    public static ItemStack food_beetroot = new ItemStack(Items.BEETROOT,1);
    public static ItemStack food_carrot = new ItemStack(Items.CARROT,1);

    public static ItemStack food_cooked_beef = new ItemStack(Items.COOKED_BEEF,1);
    public static ItemStack food_cooked_porkchop = new ItemStack(Items.COOKED_PORKCHOP,1);
    public static ItemStack food_cooked_mutton = new ItemStack(Items.COOKED_MUTTON,1);

    //blocks
    public static ItemStack block_clay = new ItemStack(Blocks.CLAY,1);
    public static ItemStack block_sandstone = new ItemStack(Blocks.SANDSTONE,1, OreDictionary.WILDCARD_VALUE);

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        elements.forEach(element -> element.load(event));
        proxy.registerRenderers(this);
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        elements.forEach(element -> element.serverLoad(event));
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT)
            OBJLoader.INSTANCE.addDomain(MODID);
        elements.forEach(element -> {
            element.instance = this.instance;
            element.preInit(event);
        });
    }


    static {
        elements.add(new StoneItem());
        elements.add(new itemEquivalentStone());
        elements.add(new StoneTab());

        //recipes
        elements.add(new IronToGold());
        elements.add(new RedstoneToIron());
        elements.add(new LapisToGold());
        elements.add(new CharcoalToCoal());
        elements.add(new GoldToDiamond());
        elements.add(new GoldToLapis());
        elements.add(new CoalToCharcoal());
        elements.add(new GoldToIron());
        elements.add(new DiamondToGold());
        elements.add(new IronToRedstone());
        elements.add(new EmeraldToDiamond());
        elements.add(new DiamondToEmerald());

        elements.add(new SaplingAcaciaToDarkOak());
        elements.add(new SaplingBirchToJungle());
        elements.add(new SaplingDarkOakToOak());
        elements.add(new SaplingJungleToAcacia());
        elements.add(new SaplingOakToSpruce());
        elements.add(new SaplingSpruceToBirch());

        elements.add(new FlowerAlliumToAzureBluet());
        elements.add(new FlowerAzureBluetToRedTulip());
        elements.add(new FlowerBlueOrchidToAllium());
        elements.add(new FlowerDandelionToPoppy());
        elements.add(new FlowerOrangeTulipToWhiteTulip());
        elements.add(new FlowerOxeyeDaisyToDandelion());
        elements.add(new FlowerPinkTulipToOxeyeDaisy());
        elements.add(new FlowerPoppyToBlueOrchid());
        elements.add(new FlowerRedTulipToOrangeTulip());
        elements.add(new FlowerWhiteTulipToPinkTulip());

        elements.add(new MushroomBrownToRed());
        elements.add(new MushroomRedToBrown());

        elements.add(new FishClownToPuffer());
        elements.add(new FishPufferToFish());
        elements.add(new FishSalmonToClown());
        elements.add(new FishToSalmon());

        elements.add(new FoodAppleToBeetroot());
        elements.add(new FoodBeetrootToCarrot());
        elements.add(new FoodCarrotToApple());

        elements.add(new FoodBeefToPorkchop());
        elements.add(new FoodMuttonToBeef());
        elements.add(new FoodPorkchopToMutton());

        elements.add(new BlockClayToSandstone());
        elements.add(new BlockSandstoneToClay());
    }

    public static class ModElement {
        public static Object instance;
        public void load(FMLInitializationEvent event) {
        }
        public void serverLoad(FMLServerStartingEvent event) {
        }
        public void preInit(FMLPreInitializationEvent event) {
        }
        public void registerRenderers() {
        }
    }


}
