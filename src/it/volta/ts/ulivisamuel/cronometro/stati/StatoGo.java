package it.volta.ts.ulivisamuel.cronometro.stati;

import java.util.Date;

import it.volta.ts.ulivisamuel.cronometro.biz.Cronometro;
import it.volta.ts.ulivisamuel.cronometro.listener.CronoEvent;

public class StatoGo extends StatiCronometro
{
	public StatoGo(Cronometro cronometro)
	{
		super(cronometro);
		cronometro.getCronoConsoleListener().mostra(new CronoEvent("\nStato: cronometro in conteggio"));
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void bottoneRun()
	{
		Date attuale = new Date();
		cronometro.mostraTempoGiro(attuale);
		cronometro.setInizioCronometraggioGiro(attuale);
		cronometro.azzeraPausaGiro();
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void bottoneReset() 
	{
		cronometro.setStato(new StatoPause(cronometro));
		Date attuale = new Date();
		cronometro.mostraTempoGiro(attuale);
		cronometro.setInizioPausa(attuale);
	}
}
