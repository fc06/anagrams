package TestInterface;
import java.io.IOException;
import java.util.ArrayList;

//tab ''lea ela or ro ea''
//book word0 (l 1, e 1, a 1),false,lea 
// word1 (e 1, l 1, a 1),false,ela
//word2 (o 1, r 1),false,or
//word3 (r 1, r o),false,ro
//word4 (e 1, a o),false,ea

public class Book {

public Book () {
	ArrayList<Word> b = new ArrayList<Word>();
	this.bk=b;}
	
public void setBook (String nameFile) throws IOException{
	
	Tab t = new Tab(nameFile);
	
	for (int i=0; i<t.sizeTab();i++) {
		Word w = new Word();
		w.setWord(t.getTab(i));
		this.bk.add(w);
	}
}

public int sizeBook () {
	return (bk.size());
}
	
ArrayList<Word> bk; //collection of word
}