package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.network.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaritoneUtils implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ChatCommands.register();

		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			((InGameHudAccess)client.inGameHud).registerChatListener(
					MessageType.CHAT,
					(type, message, sender) -> {
						LOGGER.info(String.format("\nSENT MESSAGE%s\n", message.toString()));
					});
		});
	}
}
