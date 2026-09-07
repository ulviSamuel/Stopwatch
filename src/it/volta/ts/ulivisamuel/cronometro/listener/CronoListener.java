package it.volta.ts.ulivisamuel.cronometro.listener;

import java.util.EventListener;

public interface CronoListener extends EventListener
{
	public void mostra(CronoEvent event);
}
