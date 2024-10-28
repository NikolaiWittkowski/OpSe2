package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import MVC.CafeControl;
import MVC.CafeView;

public class CafeModel {
	
	private Cafe cafe;
	private CafeView caView;
	
	   public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("Cafe.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.cafe = new Cafe(zeile[0], 
	      				(zeile[1]), 
	      				(zeile[2]), 
	      				Boolean.parseBoolean(zeile[3]), zeile[4].split("_"));
	      				ein.close();
	      	  			caView.zeigeInformationsfensterAn(
	      	  	   			"Das Cafe wurden gelesen!");
	      		}
	       		else{
	       			caView.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				caView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				caView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		public void schreibeCafeInCsvDatei() {
			try {
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("CafeAusgabe.csv", true));
				aus.write(cafe.gibCafeZurueck(';'));
				aus.close();
				caView.zeigeInformationsfensterAn(
		   			"Die Cafe wurden gespeichert!");
			}	
			catch(IOException exc){
				caView.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				caView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}

}
