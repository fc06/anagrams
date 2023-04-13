package TestInterface;

import java.io.IOException;

public class AnagramsFromBook {

	public static void main(String[] args) throws IOException{

		/*name of accounting, Front-office, report files and folder by default*/
		String fileAccDefault ="Book.txt";
		String folderDefault ="C:\\Users\\HP\\eclipse-workspace\\test\\";
		String fileName = folderDefault+ fileAccDefault; 

		Book b = new Book();
		b.setBook(fileName);
		GroupOfAnagrams gA =new GroupOfAnagrams();
		gA.setGroupOfAnagrams(b, fileName);
		gA.showGroupAnagrams();
	}

}
