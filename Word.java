package TestInterface;

import java.util.ArrayList;

//a word object is define by an ArrayList of object Carac (character, number of the character in the word)
//'lela'' is {(l,2), (e,1), (a,1)}
//we can add add, remove objects c (char,int) from the word

public class Word extends Carac {
	//a word is made of Carac, it is a group ArrayList of couples (char, number)
	ArrayList<Carac> w;
	//in the book, this word has an anagram
	boolean hasAnagram =false;
	//source: word that is the source of the object word
	String source;
	//number of characters Carac in the source of the word, lela sizeWord=3
	int sizeWord;

	public Word () {
		ArrayList<Carac> w = new ArrayList<Carac>();
		this.w=w;
		this.hasAnagram=false;
		this.source="";
		this.sizeWord=0;
	}
	
	public void setWord (String s) {	
		//construct the collection charInS with the characters included
		// with the word ''lelale'' in charIns {l,e,a}
		//then we can add in word from charIns{(l,3), (e,1), (a,1)}
		this.source=s;	
		String sUpper=s.toUpperCase();

		ArrayList<Character> charInS = new ArrayList<> ();
		boolean taken = false;
		
		//we identify all unique characters in the word, i.e, FREDEERF -> F, R, E, D
		for (int i =0; i<sUpper.length();i++ ) {
			taken = false;
			for (char a : charInS) {
				if (a == sUpper.charAt(i)) taken=true;
			}
			if (taken==false) charInS.add(sUpper.charAt(i));
		}
		
	//we add all characters in Word from charInS
		for (char a : charInS) {
			Carac c = new Carac();
			//example in "lelal" we add in the collection ("l",3), (e,1), (a,1)
			c.setCarac(sUpper, a);
			this.w.add(c);
			this.sizeWord=w.size();
		}
	}
	
	public int setSizeWord (Word w) {
		return this.w.size();
	}

	public ArrayList<Carac> getWordArray() {
		return this.w;
	}
	
	//we define if 2 Carac are equals, it means same number of items and same couples 
	// (char, number of char)
	//if 2 words are equals it means they are anagrams, i.e. lea = ela
	public boolean isAnagramOf (Word e) {
		boolean equals=true ; //if equals is true they are anagrams
		
		//System.out.println("e  " + e.source);
		//System.out.println("w  " + this.source);

		//if they do not have same size the 2 words
		//are not anagrams
		//if the 2 words are the same they they are not anagrams
		if ((this.sizeWord != e.sizeWord) || (this.source.length() != e.source.length()) || 
			(e.source.toUpperCase().equals(this.source.toUpperCase()))) {
			equals=false;
		}
		else {
			//we check that we have the same characters and number of characters in the 2 words
			for (int i =0; i<e.sizeWord;i++ ) {
				equals=false;
				for (int j =0; j<e.sizeWord;j++ ) {
					if (e.getWordArray().get(i).car == this.getWordArray().get(j).car && 
						e.getWordArray().get(i).nbrChar == this.getWordArray().get(j).nbrChar ) {
						equals=true;
						break;
					}
				}	
				if (equals==false) break;	
			}
		}
		
		
		//System.out.println(equals);
		//System.out.println();
		return equals;
	}
}