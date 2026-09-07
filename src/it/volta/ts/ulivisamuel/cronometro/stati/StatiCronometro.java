package it.volta.ts.ulivisamuel.cronometro.stati;

import it.volta.ts.ulivisamuel.cronometro.biz.Cronometro;

public abstract class StatiCronometro 
{
	protected Cronometro    cronometro;
	
	//---------------------------------------------------------------------------------------------
	
	public StatiCronometro(Cronometro cronometro)
	{
		this.cronometro    = cronometro;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public abstract void bottoneRun();
	public abstract void bottoneReset();
}
	