package leetcode301;

public class Main {
	public static void main(String[] args) {
		String s = "()())()";
		
		String s1 = "((()";
		
		System.out.println("Input: " + s);
		
		System.out.println("Input1: " + s1);
		
		FindAllValidParenthesesFunction solution = new FindAllValidParenthesesFunction();
		
		System.out.println("Solution: " + solution.removeInvalidParentheses(s));
		System.out.println("Solution1: " + solution.removeInvalidParentheses(s1));
	}
}
