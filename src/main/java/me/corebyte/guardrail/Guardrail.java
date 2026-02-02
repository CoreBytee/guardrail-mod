package me.corebyte.guardrail;

import me.corebyte.guardrail.mixin.EntityAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Guardrail implements ModInitializer {

	public static final String MOD_ID = "guardrail";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ServerTickEvents.END_SERVER_TICK.register(server -> {
			server
				.getPlayerList()
				.getPlayers()
				.forEach(player -> {
					LOGGER.info(
						Double.toString(((EntityAccessor) player).getPos().y)
					);
				});
		});
	}
}
