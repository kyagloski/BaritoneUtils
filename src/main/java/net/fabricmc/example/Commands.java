package net.fabricmc.example;

import net.minecraft.client.MinecraftClient;

public class Commands {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void about() {
        String[] aboutTexts = {"+--------BARITONE-UTILS--------+",
                "+-adds global chat commands------+",
                "+-for remote baritone bots-------+",
                "+-created by: github.com/kyagloski/"};
        for (String str : aboutTexts) {
            mc.player.sendChatMessage(str);
            try { Thread.sleep(100); }
            catch(Exception e) { return; }
        }
    }

}
