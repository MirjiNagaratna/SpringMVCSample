package com.sonata.mirji.injectingBean;

public class TextEditor {
	
	public SpellChecker spellChecker;

	public SpellChecker getSpellChecker() {
		System.out.println("getSpellChecker");
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("setSpellChecker");
		this.spellChecker = spellChecker;
	}
	
	public void checkSpell(){
		this.spellChecker.correctSpelling();
	}

}
