package MVC;

import business.Cafe;
import business.CafeModel;
import javafx.stage.Stage;

public class CafeControl {
	
	private CafeView caView;
	private CafeModel caMod;
	private Cafe cafe;
	
	public CafeControl(Stage primaryStage) {
		this.caMod = new CafeModel();
		this.caView = new CafeView(this, caMod, primaryStage);
	}
	
    void nehmeCafeAuf(){
    	try{
    		this.cafe = new Cafe(
    			caView.txtName.getText(), 
   	            caView.txtOrt.getText(),
   	            caView.txtBeschreibung.getText(),
   	            Boolean.parseBoolean(caView.txtMitBackwerk.getText()),
    		    caView.txtKaffeeprodukte.getText().split(";"));
    		caView.zeigeInformationsfensterAn("Das Cafe wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		caView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    void zeigeCafeAn(){
    	if(this.cafe != null){
    		caView.txtAnzeige.setText(
    			this.cafe.gibCafeZurueck(' '));
    	}
    	else{
    		caView.zeigeInformationsfensterAn("Bisher wurde kein Cafe aufgenommen!");
    	}
    }

}
