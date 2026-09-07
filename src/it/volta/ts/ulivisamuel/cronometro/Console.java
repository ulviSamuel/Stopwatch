package it.volta.ts.ulivisamuel.cronometro;

import java.util.Scanner;

import it.volta.ts.ulivisamuel.cronometro.biz.Cronometro;
import it.volta.ts.ulivisamuel.cronometro.listener.CronoConsoleListener;
import it.volta.ts.ulivisamuel.cronometro.stati.StatoReset;
import it.volta.ts.ulivisamuel.cronometro.util.Util;

public class Console 
{
	private Cronometro crono;
	private Scanner    scanner;
	
	//---------------------------------------------------------------------------------------------
	
	public Console()
	{
		crono = new Cronometro();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void esegui()
	{
		scanner = new Scanner(System.in);
		crono.setCronoListener(new CronoConsoleListener());
		crono.setStato(new StatoReset(crono));
		menu();
		scanner.close();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void menu()
	{
		String  menu = "\nFunzioni:\n   S.start/giro\n   R.reset\n   E.esci";
		String  scelta;
		boolean continua = true;
		while(continua)
		{
			scelta = Util.leggiChar(scanner, menu, true, null);
			switch(scelta)
			{
			case "S": case "s":
				crono.bottoneRun();
			break;	
			case "R": case "r":
				crono.bottoneReset();
			break;
			case "E": case "e":
				continua = false;
			break;
			}
		}
	}
}
