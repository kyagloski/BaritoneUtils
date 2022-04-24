package net.fabricmc.example;

import net.minecraft.client.MinecraftClient;
import baritone.api.BaritoneAPI;

import static net.fabricmc.example.BaritoneToolbox.LOGGER;

public class Commands {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void about() {
        // prints about text
        // currently can be exploited to get bot kicked (spam)
        // TODO: implement cooldown or input spam filter
        String[] aboutTexts = { "+-------BARITONE-TOOLBOX-------+",
                "+-adds global chat commands------+",
                "+-for remote baritone bots -------+",
                "+-creator::github.com/kyagloski ----+",
                "+--------------- --------------+"};
        for (String str : aboutTexts) {
            mc.player.sendChatMessage(str);
            try { Thread.sleep(100); }
            catch(Exception e) { return; } // this is good practice, trust me
        }

    }

    public static void help() {
        LOGGER.info(String.format("help text"));
    }

    public static void baritoneTest(String message) {
        // goto spawn
        message = message.substring(1);
        if (message.contains("path")) { mc.player.sendChatMessage("pathing..."); }
        mc.player.sendChatMessage(message);
    }

}
