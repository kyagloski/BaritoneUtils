package net.fabricmc.example;

import net.minecraft.text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.UUID;

import static net.fabricmc.example.BaritoneUtils.LOGGER;


public class ChatParser {

    public static void handleNewChat(UUID sender, Text message) {
        String message_str = message.getString();
        Matcher m = Pattern.compile("<(.+?)>").matcher(message_str); // grab player name
        String player_string = null;
        if (m.find()) { player_string = m.group(1); }
        else { LOGGER.info("cannot find player name. exiting."); return; }
        if (player_string == null) { return; } // make call to check whitelist here, when its implemented
        String message_contents = message_str.split(" ", 2)[1]; // grab all contents after first space
        parseMessageContents(message_contents);
    }
    private static void parseMessageContents(String message) {
        LOGGER.info(message);
    }
}
