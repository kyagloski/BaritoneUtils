package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.network.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaritoneToolbox implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("baritone-toolbox");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			((InGameHudAccess)client.inGameHud).registerChatListener(
					MessageType.CHAT,
					(type, message, sender) -> {
						ChatParser.handleNewChat(message);
					});
		});
	}
}
