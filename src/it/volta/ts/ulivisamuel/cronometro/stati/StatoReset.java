package it.volta.ts.ulivisamuel.cronometro.stati;

import java.util.Date;

import it.volta.ts.ulivisamuel.cronometro.biz.Cronometro;
import it.volta.ts.ulivisamuel.cronometro.listener.CronoEvent;

public class StatoReset extends StatiCronometro
{
	public StatoReset(Cronometro cronometro)
	{
		super(cronometro);
		cronometro.getCronoConsoleListener().mostra(new CronoEvent("\nStato: cronometro resettato"));
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void bottoneRun()
	{
		cronometro.setStato(new StatoGo(cronometro));
		Date attuale = new Date();
		cronometro.setInizioCronometraggio(attuale);
		cronometro.setInizioCronometraggioGiro(attuale);
		cronometro.azzeraPause();
		cronometro.mostraTempoGiro(attuale);
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void bottoneReset(){}
}
