package com.willfp.eco.util.drops.telekinesis;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

@UtilityClass
public final class TelekinesisUtils {
    /**
     * The test service registered to bukkit.
     */
    private TelekinesisTests tests = Bukkit.getServicesManager().load(TelekinesisTests.class);

    /**
     * Test the player for telekinesis.
     * <p>
     * If any test returns true, so does this.
     *
     * @param player The player to test.
     * @return If the player is telekinetic.
     */
    public boolean testPlayer(@NotNull final Player player) {
        return tests.testPlayer(player);
    }

    /**
     * Register a new test to check against.
     *
     * @param test The test to register, where the boolean output is if the player is telekinetic.
     */
    public void registerTest(@NotNull final Function<Player, Boolean> test) {
        tests.registerTest(test);
    }

    /**
     * Update the test to use.
     */
    public void update() {
        tests = Bukkit.getServicesManager().load(TelekinesisTests.class);
    }
}