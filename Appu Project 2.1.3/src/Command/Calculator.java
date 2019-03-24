package Command;

import APPU.MainPanel;
import java.util.Stack;

public class Calculator {
    
    private static int getPriority(char ch) { 
	switch (ch) { 
            case '+': 
            case '-': 
		return 1; 	
            case '*': 
            case '/': 
		return 2; 	
            case '^': 
		return 3; 
	} 
        return 0; 
    }
    
    private static String infix2Postfix(String infix) { 
	String result = ""; 
	Stack<Character> stack = new Stack<>(); 
	
	for (int i = 0; i<infix.length(); ++i) { 
            char token = infix.charAt(i); 	
            if (Character.isLetterOrDigit(token)) 
		result += token; 		
            else 
                if (token == '(') 
                    stack.push(token); 		
                else 
                    if (token == ')') { 
                        while (!stack.isEmpty() && stack.peek() != '(') 
                            result += stack.pop(); 
                        if (!stack.isEmpty() && stack.peek() != '(') 
                            return "Invalid Expression";			 
                        else
                            stack.pop(); 
                    }
                    else { 
                        while (!stack.isEmpty() && getPriority(token) <= getPriority(stack.peek())) 
                            result += stack.pop(); 
                        stack.push(token); 
                    } 
        } 
	while (!stack.isEmpty()) 
            result += stack.pop(); 
	return result; 
    } 
    
    private static String calculator(String postfix) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < postfix.length(); i++) {
            char token = postfix.charAt(i);
            float value1, value2, result = 0;
            if (token == '+' || token == '-' || token == '*' || token == '/' || token == '^') {
                value1 = Float.parseFloat(stack.pop());
		value2 = Float.parseFloat(stack.pop());
		switch (token) {
                    case '+':
                        result = value2 + value1;
                        break;
                    case '-':
                        result = value2 - value1;
                        break;
                    case '*':
                        result = value2 * value1;
                        break;
                    case '/':
                        result = value2 / value1;
                        break;
                    case '^':
                        result = (float) Math.pow(value2, value1);
                        break;
		}
		stack.push(Float.toString(result));
            }
            else
                stack.push(String.valueOf(token)); 
        }
        return stack.peek();
    }
    
    public static String doMath() {
        Commands.online = false;
        String commandString = MainPanel.inputField.getText();
        String postfix = infix2Postfix(commandString.substring(0, commandString.length() - 1));
        return calculator(postfix);
    }
}
