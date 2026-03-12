package BasicQuestions;

import java.util.Stack;

public class isValidParanthasies {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) { // s.split("")~= s.toCharArray
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static boolean isValidParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	// without Stack
	public static boolean isValidWithoutStack(String s) {
		int count = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '(')
				count++;
			else {
				count--;
				if (count < 0)
					return false;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		String bracketsCheck = "{[()]}";
		System.out.println("isValid(bracketsCheck); is++++>" + isValid(bracketsCheck));
		// Balanced Parentheses (Only ( and ))
		String Input = "(()())";
		// Output: true
		System.out.println("isValidParentheses is:::" + isValidParentheses(Input));

	}

}
