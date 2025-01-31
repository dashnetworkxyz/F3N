package xyz.dashnetwork.f3n;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "dashnetwork-f3n", version = "1.0")
public class F3N {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKey() != Keyboard.KEY_N)
            return;

        if (!Keyboard.isKeyDown(Keyboard.KEY_F3) || !Keyboard.isKeyDown(Keyboard.KEY_N))
            return;

        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

        if (player != null) {
            if (player.capabilities.isCreativeMode)
                player.sendChatMessage("/gamemode spectator");
            else
                player.sendChatMessage("/gamemode creative");
        }
    }

}
