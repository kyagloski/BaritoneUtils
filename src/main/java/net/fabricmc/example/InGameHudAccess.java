package net.fabricmc.example;

import net.minecraft.client.gui.ClientChatListener;
import net.minecraft.network.MessageType;

public interface InGameHudAccess {
    void registerChatListener(MessageType messageType, ClientChatListener listener);
}