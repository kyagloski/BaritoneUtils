package net.fabricmc.example.mixin;

import net.fabricmc.example.InGameHudAccess;
import net.minecraft.client.gui.ClientChatListener;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.network.MessageType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Map;

//@Mixin(ChatHud.class)
//public class GetChatMixin {
//    @Inject(method = "addMessage(Lnet/minecraft/text/Text;I)V", at = @At("HEAD"))
//    public void addMessage(Text text, int messageId, CallbackInfo info) {
//        try {
//            Field field = ChatHud.class.getDeclaredField("field_2064");
//            List<?> lines = (List<?>) field.get(MinecraftClient.getInstance().inGameHud.getChatHud());
//            ExampleMod.LOGGER.info(lines.toString());
//        } catch (Exception e) {
//            ExampleMod.LOGGER.info("error");
//        }
//    }
//}

@Mixin(InGameHud.class)
public class InGameHudMixin implements InGameHudAccess {

    @Shadow
    @Final
    private Map<MessageType, List<ClientChatListener>> listeners;

    public void registerChatListener(MessageType messageType, ClientChatListener listener) {
        this.listeners.get(messageType).add(listener);
    }
}
