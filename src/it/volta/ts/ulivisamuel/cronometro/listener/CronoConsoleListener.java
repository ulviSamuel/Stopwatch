package it.volta.ts.ulivisamuel.cronometro.listener;

public class CronoConsoleListener implements CronoListener
{
	@Override
	public void mostra(CronoEvent event)
	{
		System.out.println(event.getSource());
	}
}
