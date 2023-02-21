package citi;

import java.util.*;
import java.util.stream.*;

public class PrincClass {
	    
	    private static boolean[] taken;

		public static void main(String args[]) {
		      testEquals("Lowercase: ", normalizeSolution(groupAnagrams(List.of("tn", "cab", "vwa", "bca", "nt", "abc"))), "[[abc,bca,cab],[nt,tn],[vwa]]");

		      testEquals("Mixed-case: ", normalizeSolution(groupAnagrams(List.of("Tn", "cab", "vwa", "BCA", "nt", "abc"))), "[[BCA,abc,cab],[Tn,nt],[vwa]]");

		      testEquals("Empty list test: ", normalizeSolution(groupAnagrams(List.of())), "[]");
	      
	    }

	  public static List<List<String>> groupAnagrams(List<String> words) {

	   //l is the list of list reorganized by group of anagrams  
	   List<List<String>> l = new ArrayList<>();

	   //we add list iof boolean to check if the item was already taken in a list
	   taken = new boolean[words.size()];
	   
   
	   for (int k=0; k<=words.size()-1;k++) 
	   		{ArrayList <String> subList = new ArrayList <String> ();
			String a = new String (words.get(k));

			if (!taken[k]) 
				subList.add(a);
			    taken[k]=true;
				{for (int i=k+1;i<=(words.size()-1);i++) {
						String b = new String(words.get(i));
						if (a.length()==b.length()){
							//we check if a and b are anagrams
							// we move characters in the word a and compare to the word b
							//1 letter is blocked the 2 others exchanged
							
							//first control we exchange charaters in the word
							//it is not required used in our cases but we need generic solution
							if (!taken[i]) 
								{for (int m=0;m<a.length();m++) 
									{for (int n=0;n<a.length();n++) 
										if (!(taken[k] && taken[i])) {
											StringBuffer c = new StringBuffer();
											c.append(a);
											char x, y;
											x=c.charAt(n);
											y=c.charAt(m);
											c.setCharAt(n, y);
											c.setCharAt(m, x);
											c.toString();
											if ((c.toString().toUpperCase()).equals(b.toUpperCase())){
												//a and b are anagrams
												if (b.length() != 0 && b!= null) {
													subList.add(b);
												}
												
												taken[k]=true;
												taken[i]=true;}
										}
									}
								}
							//2nd checking not covered 
							//we move the letters like a train, last character come to the 1st
							//it moves in loop till the train is come back
							if (!taken[i]) 
								{StringBuffer c = new StringBuffer();
								c.append(a);
								for (int m=1; m <a.length();m++)
									{StringBuffer y = new StringBuffer();
									y=train(c);	
									y.toString();
									if (!(taken[k] && taken[i])) {
										if ((y.toString().toUpperCase()).equals(b.toUpperCase()))
										{//a and b are anagrams
											if (b.length() != 0 && b!= null) {
												subList.add(b);
											}
											taken[k]=true;
											taken[i]=true;
										}
									}
									c= y;
									}	
								}
						}
				}	
			}
		  	if (subList.size() != 0) {
		  		l.add(subList);
		  	}
   		}
	return (l);
}
	  
	    private static StringBuffer train(StringBuffer x) {
			StringBuffer c = new StringBuffer();
			c.append(x);
			char z;
			z=x.charAt(x.length()-1);
			c.setCharAt(0, z);
			for (int n=0;n<(x.length()-1);n++)  
			   {z=x.charAt(n);
				c.setCharAt(n+1, z);
				}
			c.toString();

			return(c);
	    }

	  
		    private static String normalizeSolution(List<List<String>> solution) {
		        return solution.stream()
		                        .map(l -> 
		                                    l.stream()
		                                    .sorted()
		                                    .collect(Collectors.joining(",", "[", "]")))
		                        .sorted()
		                        .collect(Collectors.joining(",", "[", "]"));
		        
		    }
		    
		    private static void testEquals(String name, Object actual, Object expected) {
		        System.out.println("Test " + name + (expected.equals(actual) ? "PASSED" : "FAILED"));
		    }

}
