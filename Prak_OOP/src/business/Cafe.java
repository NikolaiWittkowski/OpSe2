package business;

public class Cafe {
	
	// Name des Buergeramtes
    private String name;
    // Ort
    private String ort;
    // Beschreibung
    private String beschreibung;
    //mit angeschlossener Bäckerei? 
    private boolean mitBackwerk;
    // Kafeeprodukte des Cafe
    private String[] kaffeeprodukte;



	
	public Cafe(String name, String ort, String beschreibung, boolean mitBackwerk, String[] kaffeeprodukte) {
		super();
		this.name = name;
		this.ort = ort;
		this.beschreibung = beschreibung;
		this.mitBackwerk = mitBackwerk;
		this.kaffeeprodukte = kaffeeprodukte;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getOrt() {
		return ort;
	}



	public void setOrt(String ort) {
		this.ort = ort;
	}



	public String getBeschreibung() {
		return beschreibung;
	}



	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}



	public boolean isMitBackwerk() {
		return mitBackwerk;
	}



	public void setMitBackwerk(boolean mitBackwerk) {
		this.mitBackwerk = mitBackwerk;
	}



	public String[] getKaffeeprodukte() {
		return kaffeeprodukte;
	}



	public void setKaffeeprodukte(String[] kaffeeprodukte) {
		this.kaffeeprodukte = kaffeeprodukte;
	}



	public String getKaffeeProdukteAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getKaffeeprodukte().length - 1; i++) {
			ergebnis = ergebnis + this.getKaffeeprodukte()[i] + trenner; 
		}
		return ergebnis	+ this.getKaffeeprodukte()[i];
	}
	
	public String gibCafeZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getOrt() + trenner
  		    + this.getBeschreibung() + trenner
  		    + this.isMitBackwerk() + trenner + "\n"
  		    + this.getKaffeeProdukteAlsString(trenner) + "\n";
  	}
}

