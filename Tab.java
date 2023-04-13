package TestInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//tab is a collection with all words in the file
//we construct the collection with separation of the words by breaks ' ', ' ' './/
//.i.e file = ''it was nice" Tab = [it],[was],[nice]
public class Tab{
	ArrayList<String> t;
	
	//builder: fill up array from the file
	public Tab (String nameFile) throws IOException {
		String line;	
		ArrayList<String> tab_ini = new ArrayList<String>();
				
		//reading file we put each word in the array
		BufferedReader fAcc = new BufferedReader (new FileReader (nameFile));

		//we can input the new word only in case of previous char break false and 
		//current break true like 'a ' or 'a,' not in case of ' ;' 
		boolean previous_char_break=false;
		boolean current_char_break=false;
		//write in Tab as  g  vvv b 
		do {
			line=fAcc.readLine();
        	StringBuffer s= new StringBuffer();
        	if (line!=null) {
        		for(int i=0; i<=line.length();i++) {
        			char c;
        			if (i==line.length()){
        				c = '.';
        			} else {
        				c = line.charAt(i);
        			}
        			
        			if (!WordBreak(c)) s.append(c);

            		if (i==0) previous_char_break=false;
        			else previous_char_break=WordBreak(line.charAt(i-1));
        			current_char_break=WordBreak(c);
        			//conditions to assign to a word	
        			if ((!previous_char_break && current_char_break)) {
           				tab_ini.add(s.toString());
        				s.replace(0, s.length(), "");
        			};
        		}
        	}
		} while (line!=null); 	
		this.t=tab_ini;
		fAcc.close();
	}
	
	//return true if it does not stop the word
	public boolean WordBreak(char c) {
		boolean b =false;
		//these characters mean that we stop, the word is finished
		//i.e. fred is nice!   hey! bob? we get 5 words fred is nice hey bob
		char t[]= {'.', '-', '!', ',', '(', ')', ':', ';', '/', '?', ' ', '1', 
				'2', '3', '4', '5', '6','7', '8', '9', '0',
				'?', '/', '<', '>', '=', '+','_',
				'{', '}', '*', '&', '%','^', '$', '#', '@'};
		for (int i = 0;i<t.length-1;i++) {
			if (c==t[i]) b=true;
		};
		return b;
	};

	public int sizeTab () {
		return t.size();
	}
	
	public String getTab(int i) {
			return t.get(i);
	};
	
	public void setT(ArrayList<String> t) {
		this.t = t;
	};
}