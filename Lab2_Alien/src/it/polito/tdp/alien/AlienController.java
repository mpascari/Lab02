/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    		txtResult.clear();
    		txtWord.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String parole = txtWord.getText();
    	
    	if(parole==null){
    		txtResult.setText("Inserire almeno una parola!");
    		return;
    	}
    	
    	String[] vettore = parole.split(" ");
    	String traduzione=null;
    	
    	if(vettore.length==1){
    		traduzione=model.translate(vettore[0]);
    	}else{
    		if(vettore.length==2){
    			model.addWord(vettore[0], vettore[1]);
    		}else{
    			txtResult.setText("Inserire al massimo 2 parole!");
    		}
    	}
    	
    	if(traduzione!=null)
    		txtResult.setText("La traduzione di "+vettore[0]+" è "+traduzione);
    	
    	traduzione=null;
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
