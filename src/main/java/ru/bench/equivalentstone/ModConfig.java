package ru.bench.equivalentstone;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModConfig {
    private static Configuration config = null;

    public static final String ModSettings = "general";
    public static int Durability;
    public static boolean InfiniteUse;

    public static void preInit() {
        File configFile = new File(Loader.instance().getConfigDir(), Main.MODID+".cfg");
        config = new Configuration(configFile);
        syncFromFiles();
    }

    public static Configuration getConfig() {
        return config;
    }

    public static void syncFromFiles()
    {
        syncConfig(true, true);
    }

    private static void syncConfig(boolean loadFromConfigFile, boolean readFieldsFromConfig) {
        if (loadFromConfigFile) {
            config.load();
        }

        Property propertyDurability = config.get(ModSettings, "Durability", 100);
        propertyDurability.setComment("Stone durability. Min: 10, max: 99999");
        propertyDurability.setMinValue(10);
        propertyDurability.setMaxValue(99999);

        Property propertyInfiniteUse = config.get(ModSettings, "InfiniteUse", false);
        propertyInfiniteUse.setComment("The use of stone is endless");

        List<String> propertyOrderBlocks = new ArrayList<String>();
        propertyOrderBlocks.add(propertyDurability.getName());
        propertyOrderBlocks.add(propertyInfiniteUse.getName());

        config.setCategoryPropertyOrder(ModSettings, propertyOrderBlocks);

        if (readFieldsFromConfig) {
            Durability = propertyDurability.getInt();
            InfiniteUse = propertyInfiniteUse.getBoolean();
        }

        propertyDurability.set(Durability);
        propertyInfiniteUse.set(InfiniteUse);

        if (config.hasChanged()) {
            config.save();
        }
    }
}
