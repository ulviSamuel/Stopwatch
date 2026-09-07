package it.volta.ts.ulivisamuel.cronometro.stati;

import java.util.Date;

import it.volta.ts.ulivisamuel.cronometro.biz.Cronometro;
import it.volta.ts.ulivisamuel.cronometro.listener.CronoEvent;

public class StatoPause extends StatiCronometro
{
	public StatoPause(Cronometro cronometro)
	{
		super(cronometro);
		cronometro.getCronoConsoleListener().mostra(new CronoEvent("\nStato: cronometro in pausa"));
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void bottoneRun()
	{
		cronometro.setStato(new StatoGo(cronometro));
		Date attuale = new Date();
		cronometro.setFinePausa(attuale);
		cronometro.calcolaPausa();
		cronometro.mostraTempoGiro(attuale);
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void bottoneReset() 
	{
		cronometro.setStato(new StatoReset(cronometro));
	}
}
