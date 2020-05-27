package leetcode301;

public class Main {
	public static void main(String[] args) {
		String s = "()())()";
		
		System.out.println("Input: " + s);
		
		FindAllValidParenthesesFunction solution = new FindAllValidParenthesesFunction();
		
		System.out.println("Solution: " + solution.removeInvalidParentheses(s));
	}
}
