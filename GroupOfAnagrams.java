package TestInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;

//tab ''lea ela or ro ea''
//book word0 (l 1, e 1, a 1),false,lea 
//word1 (e 1, l 1, a 1),false,ela
//word2 (o 1, r 1),false,or
//word3 (r 1, r o),false,ro
//word4 (e 1, a o),false,ea

public class GroupOfAnagrams {

public GroupOfAnagrams () {
	ArrayList<ArrayList<String>> G = new ArrayList<ArrayList<String>>();
		this.anaGroup=G;
}
	
public void setGroupOfAnagrams(Book b, String nameFile) throws IOException {
	int k =0;
	for (int i=0; i<b.sizeBook(); i++) {
		System.out.println(b.bk.get(i).source.toLowerCase());
		checkTime (i, 10);
		//if the word was already identified as anagram we skip
		if (!b.bk.get(i).hasAnagram) {
			ArrayList<String> groupAnagram = new ArrayList<String>(); 
			for (int j=i+1; j<b.sizeBook(); j++) {
				//we check if the word j was already identified as anagram
				if (!b.bk.get(j).hasAnagram) {
					//we check if words i and j are anagram
					if (b.bk.get(i).isAnagramOf(b.bk.get(j))) {
						//we check if the word i was already added in the group of anagram
						if (!checkInAnagramList(b.bk.get(i).source.toLowerCase(), groupAnagram)) {
							groupAnagram.add(b.bk.get(i).source.toLowerCase());
							b.bk.get(i).hasAnagram=true;
						}
						//we identifed word j as checked
						b.bk.get(j).hasAnagram=true;
						//we check if the word j was already added in the group of anagram
						//we add the word j only if it was not added in the group
						if (!checkInAnagramList(b.bk.get(j).source.toLowerCase(), groupAnagram)) {
							groupAnagram.add(b.bk.get(j).source.toLowerCase());
						}
					}
				}
			}
			//we have compared the word i to all the book, we add the group of anagrams
			if (groupAnagram.size()>1) {
				k++;
				this.anaGroup.add(groupAnagram);
				this.writeGroupAnagrams(fileNameAnagrams, groupAnagram, k);
			}
		}
	}
}

private void checkTime (float n, float frequence) {
    float d = n/frequence;
    if (d-(int)d == 0.0) {
        LocalTime myObj = LocalTime.now();
		System.out.println(n*frequence);		
        System.out.println(myObj);
    }
}
//return true if the string is already identified as an anagram
private boolean checkInAnagramList(String Ana, ArrayList<String> A) {
	boolean exist = false;
	for (String s : A) {
		if (s.equals(Ana)) exist=true;			
	}
	return exist;
}

//open the file filename
public void show_file(String fileName, ArrayList<String> a) {
	String[] commands = {"cmd", "/c", fileName};
	try {
		//control file is correct
			//open notepad with file
			Runtime.getRuntime().exec(commands);
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
}

public void showGroupAnagrams() {
	int i =1;
	for (ArrayList<String> a : this.anaGroup) {
		System.out.println("=================");
		System.out.println("Group " +i+ " of anagrams ");
		for (String s : a) {
			System.out.println(s + " ");			
		}
		i++;
	}
}

public void writeGroupAnagrams (String fileNameAnagrams ,ArrayList<String> a, int k) throws IOException {
	PrintWriter f = new PrintWriter (new FileWriter(fileNameAnagrams, true));
	f.println ("===================================================================");
    LocalTime myObj = LocalTime.now();
	f.println("Group " + k + " of anagrams ");
	f.println (myObj);
	for (int i=0; i<a.size(); i++) {
		f.println(a.get(i));
	}
	f.close();
}

ArrayList<ArrayList<String>> anaGroup;
String folderDefault ="C:\\Users\\HP\\eclipse-workspace\\test\\";
String fileNameAnagrams = folderDefault+ "Anagrams.txt"; 

}
