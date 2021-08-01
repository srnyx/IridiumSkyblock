package com.iridium.iridiumskyblock.placeholders;

import com.google.common.collect.ImmutableMap;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.database.Island;
import com.iridium.iridiumskyblock.database.User;
import com.iridium.iridiumskyblock.managers.IslandManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Placeholders {

    private static final com.iridium.iridiumskyblock.configs.Placeholders placeholdersConfig = IridiumSkyblock.getInstance().getPlaceholders();
    private static final IslandManager islandManager = IridiumSkyblock.getInstance().getIslandManager();

    public static Map<String, Placeholder> placeholders = ImmutableMap.<String, Placeholder>builder()
            .putAll(getIslandPlaceholders("island", player ->
                    IridiumSkyblock.getInstance().getUserManager().getUser(player).getIsland())
            )
            .putAll(getIslandPlaceholders("current", player ->
                    IridiumSkyblock.getInstance().getIslandManager().getIslandViaPlayerLocation(player))
            )
            .putAll(getIslandTopPlaceholders())

            .put("player_rank", player -> {
                User user = IridiumSkyblock.getInstance().getUserManager().getUser(player);
                return user.getIslandRank().getDisplayName();
            })
            .build();

    private static Map<String, Placeholder> getIslandPlaceholders(String startKey, IslandGetter islandGetter) {
        return ImmutableMap.<String, Placeholder>builder()
                .put(startKey + "_name", player ->
                        islandGetter.getIsland(player).map(Island::getName).orElse(placeholdersConfig.islandName)
                )
                .put(startKey + "_owner", player ->
                        islandGetter.getIsland(player).map(island -> island.getOwner().getName()).orElse(placeholdersConfig.islandOwner)
                )
                .put(startKey + "_rank", player ->
                        islandGetter.getIsland(player).map(island -> IridiumSkyblock.getInstance().getNumberFormatter().format(island.getRank())).orElse(placeholdersConfig.islandRank)
                )
                .put(startKey + "_level", player ->
                        islandGetter.getIsland(player).map(island -> IridiumSkyblock.getInstance().getNumberFormatter().format(island.getLevel())).orElse(placeholdersConfig.islandLevel)
                )
                .put(startKey + "_value", player ->
                        islandGetter.getIsland(player).map(Island::getFormattedValue).orElse(placeholdersConfig.islandValue)
                )
                .put(startKey + "_members", player ->
                        islandGetter.getIsland(player).map(island -> IridiumSkyblock.getInstance().getNumberFormatter().format(island.getMembers().size())).orElse(placeholdersConfig.islandMembers)
                )
                .put(startKey + "_experience", player ->
                        islandGetter.getIsland(player).map(Island::getFormattedExperience).orElse(placeholdersConfig.islandExperience)
                )
                .put(startKey + "_experience_required", player ->
                        islandGetter.getIsland(player).map(island -> IridiumSkyblock.getInstance().getNumberFormatter().format(island.getExperienceRequiredToLevelUp())).orElse(placeholdersConfig.islandExperienceRequired)
                )
                .put(startKey + "_experience_remaining", player ->
                        islandGetter.getIsland(player).map(island -> IridiumSkyblock.getInstance().getNumberFormatter().format(island.getExperienceRemainingToLevelUp())).orElse(placeholdersConfig.islandExperienceRemaining)
                )

                // Island Bank Placeholders
                .put(startKey + "_bank_experience", player ->
                        islandGetter.getIsland(player).map(Island::getFormattedBankExperience).orElse(placeholdersConfig.islandBankExperience)
                )
                .put(startKey + "_bank_crystals", player ->
                        islandGetter.getIsland(player).map(Island::getFormattedCrystals).orElse(placeholdersConfig.islandBankCrystals)
                )
                .put(startKey + "_bank_money", player ->
                        islandGetter.getIsland(player).map(Island::getFormattedMoney).orElse(placeholdersConfig.islandBankMoney)
                )

                // Island Upgrade Placeholders
                .put(startKey + "_upgrade_blocklimit_level", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(islandManager.getIslandUpgrade(island, "blocklimit").getLevel())
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_member_level", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(islandManager.getIslandUpgrade(island, "member").getLevel())
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_size_level", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(islandManager.getIslandUpgrade(island, "size").getLevel())
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_generator_level", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(islandManager.getIslandUpgrade(island, "generator").getLevel())
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_warp_level", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(islandManager.getIslandUpgrade(island, "warp").getLevel())
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_member_amount", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(IridiumSkyblock.getInstance().getUpgrades().memberUpgrade.upgrades.get(islandManager.getIslandUpgrade(island, "member").getLevel()).amount)
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_size_dimensions", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(IridiumSkyblock.getInstance().getUpgrades().sizeUpgrade.upgrades.get(islandManager.getIslandUpgrade(island, "size").getLevel()).size)
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .put(startKey + "_upgrade_warp_amount", player -> islandGetter.getIsland(player).map(island ->
                        IridiumSkyblock.getInstance().getNumberFormatter().format(IridiumSkyblock.getInstance().getUpgrades().warpsUpgrade.upgrades.get(islandManager.getIslandUpgrade(island, "warp").getLevel()).amount)
                ).orElse(placeholdersConfig.islandUpgradeBlocklimitLevel))

                .build();
    }

    private static Map<String, Placeholder> getIslandTopPlaceholders() {
        HashMap<String, Placeholder> hashmap = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            hashmap.putAll(getIslandPlaceholders("island_top_" + i, player -> IridiumSkyblock.getInstance().getIslandManager().getIslandById(finalI)));
        }
        return hashmap;
    }

    public interface Placeholder {

        String placeholderProcess(Player player);

    }

    public interface IslandGetter {

        Optional<Island> getIsland(Player player);

    }

}
