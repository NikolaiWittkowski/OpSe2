package MVC;

import business.CafeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class CafeView {
	
	private CafeControl caCon;
	private CafeModel caMod;
	
	private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblOrt   		= new Label("Ort:");
    private Label lblBeschreibung 	 		= new Label("Beschreibung:");
    private Label lblBackwerk		= new Label("Bäckerei angeschlossen:");
    private Label lblKaffeeprodukte  		= new Label("Kaffeeprodukte:");
    TextField txtName 	 			= new TextField();
    TextField txtOrt		= new TextField();
    TextField txtBeschreibung		= new TextField();
    TextField txtMitBackwerk		= new TextField();
    TextField txtKaffeeprodukte	= new TextField();
    TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
	
	 public CafeView(Stage primaryStage) {

	}

	private void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblOrt.setLayoutX(20);
	    	lblOrt.setLayoutY(130);
	    	lblBeschreibung.setLayoutX(20);
	    	lblBeschreibung.setLayoutY(170);
	    	lblBackwerk.setLayoutX(20);
	    	lblBackwerk.setLayoutY(210);
	    	lblKaffeeprodukte.setLayoutX(20);
	    	lblKaffeeprodukte.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblOrt, lblBeschreibung,
	       		lblBackwerk, lblKaffeeprodukte);
	    
	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtOrt.setLayoutX(170);
	    	txtOrt.setLayoutY(130);
	    	txtOrt.setPrefWidth(200);
	    	txtBeschreibung.setLayoutX(170);
	    	txtBeschreibung.setLayoutY(170);
	    	txtBeschreibung.setPrefWidth(200);
	    	txtMitBackwerk.setLayoutX(170);
	    	txtMitBackwerk.setLayoutY(210);
	    	txtMitBackwerk.setPrefWidth(200);
	    	txtKaffeeprodukte.setLayoutX(170);
	    	txtKaffeeprodukte.setLayoutY(250);
	    	txtKaffeeprodukte.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtName, txtOrt, txtBeschreibung,
	     		txtMitBackwerk, txtKaffeeprodukte);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }
	   
	   private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	caCon.nehmeCafeAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		    		caCon.zeigeCafeAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		    		caMod.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			    	caMod.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					caMod.schreibeCafeInCsvDatei();
				}	
		    });
	    }
	   
	   public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    
	    public void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn();
	    }

}
