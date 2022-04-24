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
		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			((InGameHudAccess)client.inGameHud).registerChatListener(
					MessageType.SYSTEM, // system type for whispers (chat for chat)
					(type, message, sender) -> {
						ChatParser.handleNewChat(type, message);
					});
		});
	}
}
