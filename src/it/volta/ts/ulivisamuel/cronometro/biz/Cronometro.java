package it.volta.ts.ulivisamuel.cronometro.biz;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import it.volta.ts.ulivisamuel.cronometro.listener.CronoConsoleListener;
import it.volta.ts.ulivisamuel.cronometro.listener.CronoEvent;
import it.volta.ts.ulivisamuel.cronometro.stati.StatiCronometro;

public class Cronometro
{
	private CronoConsoleListener cronoListener;
	private StatiCronometro      stato;
	private Date                 inizioCronometraggio;
	private Date                 inizioCronometraggioGiro;
	private Date                 inizioPausa;
	private Date                 finePausa;
	private long                 totalPausa;
	private long                 totalPausaGiro;
	
	//---------------------------------------------------------------------------------------------
	
	public Cronometro()
	{
		stato                    = null;
		inizioCronometraggio     = null;
		inizioCronometraggioGiro = null;
		inizioPausa              = null;
		finePausa                = null;
		cronoListener            = null;
		totalPausa               = 0;
		totalPausaGiro           = 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void setStato(StatiCronometro stato)
	{
		this.stato = stato;
	}
	
	public void setCronoListener(CronoConsoleListener cronoListener)
	{
		this.cronoListener = cronoListener;
	}
	
	public void setInizioCronometraggio(Date inizioCronometraggio)
	{
		this.inizioCronometraggio = inizioCronometraggio;
	}
	
	public void setInizioCronometraggioGiro(Date inizioCronometraggioGiro)
	{
		this.inizioCronometraggioGiro = inizioCronometraggioGiro;
	}
	
	public void setInizioPausa(Date pausaTotale)
	{
		this.inizioPausa = pausaTotale;
	}
	
	public void setFinePausa(Date finePausa)
	{
		this.finePausa = finePausa;
	}
	
	
	
	public CronoConsoleListener getCronoConsoleListener()
	{
		return cronoListener;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void azzeraPause()
	{
		totalPausa     = 0;
		totalPausaGiro = 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void azzeraPausaGiro()
	{
		totalPausaGiro = 0;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void calcolaPausa()
	{
		totalPausa     = totalPausa     + (finePausa.getTime() - inizioPausa.getTime());
		totalPausaGiro = totalPausaGiro + (finePausa.getTime() - inizioPausa.getTime());
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void bottoneRun()
	{
		stato.bottoneRun(); 
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void bottoneReset()
	{
		stato.bottoneReset();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void mostraTempoGiro(Date attuale)
	{
		mostraTempo(attuale, inizioCronometraggio    , totalPausa    , "Tempo totale:");
		mostraTempo(attuale, inizioCronometraggioGiro, totalPausaGiro, "Tempo giro:");
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void mostraTempo(Date attuale, Date inizioCronometraggio, long pausa, String mess)
	{
		long diff = attuale.getTime() - inizioCronometraggio.getTime() - pausa;
		String format = String.format("%s:%s:%s h:m:s", Long.toString(TimeUnit.MILLISECONDS.toHours(diff))
				                                      , Long.toString(TimeUnit.MILLISECONDS.toMinutes(diff))
				                                      , Long.toString(TimeUnit.MILLISECONDS.toSeconds(diff)));
		String s = String.format("\n%s\nTempo %s", mess, format);
		cronoListener.mostra(new CronoEvent(s));
	}
}
