package net.fabricmc.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;

public class ChatParser {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void handleNewChat(MessageType type, Text raw_message) {
        // handles incoming chat messages
        String messageStr = raw_message.getString();
        String body = getMessageBody(messageStr);
        String player = getPlayerString(messageStr); // get/check player string
        if (body != null) { runCommand(body); }
    }

    private static String getPlayerString(String message) {
        // gets player string using regex (there's probably a better way)
        // TODO check if player in whitelist
        return message.split(" ")[0];
    }

    private static String getMessageBody(String message) {
        try {
            String[] splitMessage = message.split(": ");
            if (splitMessage[0].contains("whispers to you")) {
                WhisperEcho.LOGGER.info(splitMessage[1]);
                return splitMessage[1];
            }
        } catch (Exception e) { return null; }
        return null;
    }

    public static void runCommand(String message) {
        mc.player.sendChatMessage(message);
    }
}
