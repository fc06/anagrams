package TestInterface;

public class Carac {

public Carac(char c, int i) {
	this.nbrChar=i;
	this.car=c;
}

public Carac() {
	this.nbrChar=0;
	this.car=0;
}

//from "lelalo", "l" we set carac to ("l", 3)
//from "lelalo", "t" we set carac to ("t", 0)
public void setCarac(String s, char c) {
	int i =0;
	for (int j=0; j < s.length(); j++ ) {
		if (s.charAt(j)==c) {
			i++;
		}
	}
	this.nbrChar = i;
	this.car = c;
}

public int getNbrChar() {
	return nbrChar;
}
public void setNbrChar(int i) {
	this.nbrChar = i;
}

public char getCar() {
	return car;
}
public void setCar(char car) {
	this.car = car;
}
	
int nbrChar; //number of characters in the word
char car; //character in the word
}