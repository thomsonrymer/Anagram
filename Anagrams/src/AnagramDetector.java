import java.util.Scanner;
import java.util.LinkedList;

public class AnagramDetector {
	//Goal: detect whether or not two String inputs are anagrams of each other

	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean cont = true;
		while (cont) {
			
			System.out.println("Enter a word:");
			String word1 = keyboard.nextLine().toLowerCase();
			
			System.out.println("Enter another word:");
			String word2 = keyboard.nextLine().toLowerCase();
			boolean isAnagram;
			
			isAnagram =	detectAnagram(word1, word2);
			if (isAnagram)
				System.out.println("Yes, the two words are anagrams.");
			else
				System.out.println("No, the two words are not anagrams.");
			
			System.out.println("Continue? (Enter y for yes)");
			char userChoice = keyboard.next().charAt(0);
			if (userChoice != 'y')
				cont = false;
			keyboard.nextLine();
		}
		System.out.println("Goodbye.");

	}
	
	private static boolean detectAnagram(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		
		if (len1 != len2) {
			return false;
		}
		
		LinkedList<Character> list1 = new LinkedList<>();
		LinkedList<Character> list2 = new LinkedList<>();
		
		
		
		for (int i = 0; i < len1; i++) {
			list1.add(word1.charAt(i));
			list2.add(word2.charAt(i));
		}
		
		for(int i = 0; i < len1; i++) {
			Character curChar = new Character(word2.charAt(i));
			if (list1.contains(word2.charAt(i))) {
				list2.removeFirst();
			}
			else {
				return false;
			}
		}
		
		if (list2.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
