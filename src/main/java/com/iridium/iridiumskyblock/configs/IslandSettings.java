package com.iridium.iridiumskyblock.configs;

import com.iridium.iridiumcore.Item;
import com.iridium.iridiumcore.dependencies.fasterxml.annotation.JsonIgnoreProperties;
import com.iridium.iridiumcore.dependencies.xseries.XMaterial;
import com.iridium.iridiumskyblock.settings.*;

import java.util.Arrays;

/**
 * The Island setting configuration used by IridiumSkyblock (islandsettings.yml).
 * Is deserialized automatically on plugin startup and reload.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IslandSettings {

    public IslandSettingImpl mobSpawn = new IslandMobSpawn(new Item(XMaterial.ZOMBIE_HEAD, 10, 1, "&b&lMob Spawn", Arrays.asList("&7Change which mobs can spawn on your Island.", "", "&b&lValue", "&7%value%")), IslandMobSpawn.MobSpawnTypes.ALL.name(), true, true);
    public IslandSettingImpl weather = new IslandWeather(new Item(XMaterial.SNOWBALL, 12, 1, "&b&lIsland Weather", Arrays.asList("&7Change the weather of your Island.", "", "&b&lValue", "&7%value%")), IslandWeather.IslandWeatherTypes.DEFAULT.name(), true, true);
    public IslandSettingImpl time = new IslandTime(new Item(XMaterial.CLOCK, 13, 1, "&b&lIsland Time", Arrays.asList("&7Change your Island time.", "", "&b&lValue", "&7%value%")), IslandTime.IslandTimeTypes.DEFAULT.name(), true, true);
    public IslandSettingImpl leafDecay = new IslandSwitchSetting(new Item(XMaterial.OAK_LEAVES, 11, 1, "&b&lLeaf Decay", Arrays.asList("&7Allow leaves to decay on your Island.", "", "&b&lValue", "&7%value%")), IslandSwitchSetting.SwitchTypes.ALLOWED.name(), true, true);
    public IslandSettingImpl endermanGrief = new IslandSwitchSetting(new Item(XMaterial.ENDER_PEARL, 14, 1, "&b&lEnderman Grief", Arrays.asList("&7Allow enderman to grief your Island.", "", "&b&lValue", "&7%value%")), IslandSwitchSetting.SwitchTypes.ALLOWED.name(), true, true);
    public IslandSettingImpl liquidFlow = new IslandSwitchSetting(new Item(XMaterial.WATER_BUCKET, 15, 1, "&b&lLiquid Flow", Arrays.asList("&7Allow Water and Lava to flow on your Island.", "", "&b&lValue", "&7%value%")), IslandSwitchSetting.SwitchTypes.ALLOWED.name(), true, true);
    public IslandSettingImpl tntDamage = new IslandSwitchSetting(new Item(XMaterial.TNT, 16, 1, "&b&lTnT Damage", Arrays.asList("&7Allow TnT to explode on your Island.", "", "&b&lValue", "&7%value%")), IslandSwitchSetting.SwitchTypes.ALLOWED.name(), true, true);
    public IslandSettingImpl fireSpread = new IslandSwitchSetting(new Item(XMaterial.FLINT_AND_STEEL, 19, 1, "&b&lFire Spread", Arrays.asList("&7Allow fire to spread on your Island.", "", "&b&lValue", "&7%value%")), IslandSwitchSetting.SwitchTypes.ALLOWED.name(), true, true);

}
