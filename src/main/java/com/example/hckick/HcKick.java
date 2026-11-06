package com.example.hckick;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class HcKick implements ModInitializer {

    public static final String MOD_ID = "hckick";

    @Override
    public void onInitialize() {
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if (entity instanceof ServerPlayerEntity player) {
                Text deathMessage = player.getDamageTracker().getDeathMessage();
                player.networkHandler.disconnect(deathMessage);
            }
        });
    }
}
