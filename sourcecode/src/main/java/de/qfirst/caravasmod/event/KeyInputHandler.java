package de.qfirst.caravasmod.event;

import de.qfirst.caravasmod.effects.StompEffect;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY = "key.category.qfirstmod.caravas";
    public static final String KEY_STOMP = "key.qfirstmod.stomp";

    public static KeyBinding stompingKey;
    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(stompingKey.wasPressed()){
                StompEffect.key = true;
            }
            else {
                StompEffect.key = false;
            }
        });
    }
    public static void register(){
        stompingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_STOMP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATEGORY
        ));

        registerKeyInputs();
    }
}
