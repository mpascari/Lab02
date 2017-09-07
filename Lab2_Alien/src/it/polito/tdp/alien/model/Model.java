package it.polito.tdp.alien.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Model {
	
	private List<Word> alienDictionary;
	
	public Model(){
		alienDictionary = new ArrayList<>();
	}
	
	
	
	public void addWord(String alienWord, String translation){
		
		System.out.println("prima: "+alienWord+"  seconda: "+translation);
		
		if(!alienDictionary.contains(new Word(alienWord, null))){
			alienDictionary.add(new Word(alienWord, translation));
		}else{
			alienDictionary.add(alienDictionary.indexOf(new Word(alienWord, null)), new Word(alienWord, translation));
			}
	}
	
	public String translate(String alienWord){
		
		
		Iterator<Word> it = alienDictionary.iterator();
		
		while (it.hasNext()) {
			Word p = it.next();
			if(p.equals(new Word(alienWord, null)))
				return p.getTranslation();			
		}
		
		return null;
	}

}
