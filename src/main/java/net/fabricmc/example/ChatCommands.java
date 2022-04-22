package net.fabricmc.example;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.literal;

public class ChatCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("about").executes(ChatCommands::about));
        });
    }
    private static int about(CommandContext<ServerCommandSource> context) {
        String about = new String("about about about about about about about about ");
        context.getSource().sendFeedback(new LiteralText(about), true);
        return 1;
    }
}
