package leetcode301;

import java.util.ArrayList;
import java.util.List;

public class FindAllValidParenthesesFunction {
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();

		remove(s, result, 0, 0, '(', ')');

		return result;
	}

	// First remove all the extra closed parenthesis first
	// Then reverse the string to remove all the extra closed parenthesis
	private void remove(String s, List<String> result, int iStart, int jStart, char openPar, char closedPar) {
		int numOfOpen = 0;
		int numOfClosed = 0;

		for (int i = iStart; i < s.length(); i++) {
			if (s.charAt(i) == openPar) {
				numOfOpen++;
			} else if (s.charAt(i) == closedPar) {
				numOfClosed++;
			}

			// Remove extra parentheses
			if (numOfClosed > numOfOpen) {
				
				// Remove the first closed parentheses from j to i, skip duplicates
				for (int j = jStart; j <= i; j++) {
					if (s.charAt(j) == closedPar && (j == jStart || s.charAt(j - 1) != closedPar)) {
						remove(s.substring(0, j) + s.substring(j + 1, s.length()), result, i, j, openPar, closedPar);
					}
				}
				
				// End this level of recursion
				return;
			}
		}

		// For first run down, no more invalid closed parenthesis
		// Reverse to check the if there is any extra open parenthesis
		String reversedWord = new StringBuilder(s).reverse().toString();

		// '(' mean we finished removing extra closed parenthesis
		if (openPar == '(') {
			remove(reversedWord, result, 0, 0, ')', '(');
		} else { // ')' mean we finished removing extra open parenthesis too
			result.add(reversedWord);
		}
	}
}
