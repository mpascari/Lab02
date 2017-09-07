package it.polito.tdp.alien.model;

public class TestModel {

	public static void main(String[] args) {
		Model model= new Model();
		
		model.addWord("gaga", "ciao");
		
		String traduzione = model.translate("gaga");
		
		

		
		
	}

}
