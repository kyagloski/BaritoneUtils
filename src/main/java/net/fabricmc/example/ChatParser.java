package net.fabricmc.example;

import net.minecraft.text.Text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.fabricmc.example.BaritoneToolbox.LOGGER;


public class ChatParser {

    public static void handleNewChat(Text raw_message) {
        // handles incoming chat messages
        String messageStr = raw_message.getString();
        String player = getPlayerString(messageStr); // get/check player string
        String message = messageStr.split(" ", 2)[1]; // grab all contents after first space
        if (player != null) { parseMessageContents(message); }
    }

    private static String getPlayerString(String message) {
        // gets player string using regex (there's probably a better way)
        // checks if player in whitelist
        Matcher m = Pattern.compile("<(.+?)>").matcher(message); // grab player name
        if (m.find()) {
            String playerString = m.group(1);
            // TODO: whitelist check here
            return playerString;
        } else {
            LOGGER.info("cannot find player name. stopping.");
            return null;
        }
    }
    private static void parseMessageContents(String message) {
        char controlChar = '$'; // require hashtag for start of commands
        if (message.charAt(0) == controlChar) { // i hate java (sometimes)
            LOGGER.info(String.format("found command in: %s", message));
            if (message.contains("about")) { Commands.about(); }
        }
    }
}
