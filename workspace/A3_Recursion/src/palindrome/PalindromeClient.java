package palindrome;

public class PalindromeClient {
	
	/***********************************************************
	 * returns true if the given string reads the same forwards 
	 * as backwards.Trivially true for empty or 1-letter strings.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * *********************************************************/
	public static boolean isPalindrome(String s) {
		if (s.length() < 2)
			return true;
		else {
			char first 		= s.charAt(0);
			char last 		= s.charAt(s.length() - 1);
			String middle 	= s.substring(1, s.length()-1);
			
			return (first == last) && isPalindrome(middle);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("madam			 : " + isPalindrome("madam"));
		System.out.println("racecar                  : " + isPalindrome("racecar"));
		System.out.println("step on no pets          : " + isPalindrome("step on no pets"));
		System.out.println("able was I ere I saw elba: " + isPalindrome("able was I ere I saw elba"));
		System.out.println("Java			: " + isPalindrome("Java"));
		System.out.println("rotater			: " + isPalindrome("rotater"));
		System.out.println("byebye			: " + isPalindrome("byebye"));
		System.out.println("notion			: " + isPalindrome("notion"));
		System.out.println("empty			: " + isPalindrome(""));
		System.out.println("single letter a	: " + isPalindrome("a"));

	}
}
