package net.fabricmc.example;

import net.minecraft.client.MinecraftClient;

public class Commands {

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static int cooldown = 0;

    public static void about() {
        // prints about text
        // currently can be exploited to get bot kicked (spam)
        // TODO: implement cooldown or input spam filter
        String[] aboutTexts = { "+--------BARITONE-UTILS--------+",
                "+-adds global chat commands------+",
                "+-for remote baritone bots -------+",
                "+-created by: github.com/kyagloski -+",
                "+------------------------------+"};
        for (String str : aboutTexts) {
            mc.player.sendChatMessage(str);
            try { Thread.sleep(100); }
            catch(Exception e) { return; } // this is good practice, trust me
        }

    }

    public static void help() {
    }

}
