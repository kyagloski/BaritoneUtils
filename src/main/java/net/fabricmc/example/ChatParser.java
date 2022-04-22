package net.fabricmc.example;

import net.minecraft.text.TranslatableText;
import java.util.UUID;
import static net.fabricmc.example.BaritoneUtils.LOGGER;

public class ChatParser {
    UUID sender;
    TranslatableText message;

    public ChatParser(UUID sender, TranslatableText message) {
        this.sender = sender;
        this.message = message;
    }

    public int testParse() {
        for (int i = 0; i < 10; i++) {
            LOGGER.info("a");
        }
        return 1;
    }

    public int testString() {
        return 1;
    }
}
