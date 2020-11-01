package data.structures;

 import java.util.Scanner;

public class RegularExpression {

	public static void stringMatches() {
		boolean match;
		/*
		 * String s1 = "aaaa"; boolean match = s1.matches(".*");
		 * System.out.println(match);
		 */
		/*
		 * String s2 = "mss"; boolean match = s2.matches("^m.+");
		 * System.out.println(match);
		 */
		/*
		 * String s3 = "2np"; match = s3.matches(".n{1,3}p$");
		 * System.out.println(match);
		 */
		/*
		 * String s4 = "2ybcd"; match = s4.matches("^[0-9].*d$");
		 * System.out.println(match);
		 */
		String s5 = "d9sdds%adsa ";
		match = s5.matches("^.[0-9]{1,3}.*\\s$");
		System.out.println(match);
	}

	public static void eitherOrCheck(String s) {
		boolean match;
		match = s.matches("[a-zA-Z_0-9]*[^\\w]{2}[a-zA-Z_0-9]*");
		System.out.println(match);
	}

	public static boolean matchingAnythingButANewline(String s) {
		boolean match;
		match = s.matches("(.{3}\\.)(.{3}\\.)(.{3}\\.)(.{3})");
		return match;
	}

	public static boolean matchingDigits(String s) {
		boolean match;
		match = s.matches("\\d\\d\\D\\d\\d\\D\\d\\d\\d\\d");
		return match;
	}

	public static boolean isWhiteSpaceNonOrWhiteSpaceCharacter(String s) {
		boolean match = s.matches("\\s\\s\\S\\s\\s\\S\\s\\s");
		return match;
	}

	public static boolean isMatchingStartAndEnd(String s) {
		boolean match = s.matches("^[0-9][a-zA-Z_0-9]{4}\\.$");
		return match;
	}

	public static boolean isMatchingSpecificCharacters(String s) {
		boolean match = s.matches("^[123][120][xs0][30Aa][xsu][.,]$");
		return match;
	}

	public static boolean isExcludingSpecificCharacter(String s) {
		boolean match = s.matches("^[^\\d][^aeiou][^bcDF][^\\r\\n\\t\\f\\s][^AEIOU][^\\.,]$");
		return match;
	}

	public static boolean isMatchingCharacterRanges(String s) {
		boolean match = s.matches("^[a-z][0-9][[A-Z][\\W]][[a-z][\\W]][A-Z].*");
		return match;
	}

	public static boolean isMatchingRepetions(String s) {
		boolean match = s.matches("^[a-zA-Z 02468]{40}[1 3 5 7 9 \\s]{5}$");
		return match;
	}

	public static boolean isMatchingXOrYRepetitions(String s) {
		boolean match = s.matches("^[0-9]{1,2}[a-zA-Z]{3,}\\.{0,3}$");
		return match;
	}

	public static boolean isMatchingZeroOrMoreRepetitions(String s) {
		boolean match = s.matches("^[0-9]{2,}[a-z]{0,}[A-Z]{0,}$");
		return match;
	}

	public static boolean isMatchingOneOrMoreRepetions(String s) {
		boolean match = s.matches("[0-9]{1,}[A-Z]{1,}[a-z]{1,}");
		return match;
	}

	public static boolean isMatchingEndingItems(String s) {
		boolean match = s.matches("^[a-zA-Z]*s$");
		return match;
	}

	public static int isHackerRankTweets(String s,int n) {
		int count = 0;
		for (int i = 0; i < n; i++) 
			count += s.matches(".{0,}[H|h][A|a][c|C][k|K][e|E][r|R][r|R][a|A][n|N][k|K].{0,}$") == true ? 1 : 0;
		return count;
	}
	
	public static boolean capturingAndNonCapturingGroups(String s) {
		return s.matches("(?=.*?[A-Z]).*");
	}
	
	public static boolean alternativeMatching(String s) {
		return s.matches("^(Mr?s|[MDE]r).[a-zA-Z]{1,}$");
	}
	
	public static void main(String[] args) {
		System.out.println(alternativeMatching("Mr.VKDoshi."));
		
	
	}

}
