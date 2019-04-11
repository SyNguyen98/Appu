package Command;

import MainFrame.InputPanel;
import java.util.Stack;

public class Calculator {   
    public static boolean findKey(String str) {
        for (int i = 0; i < str.length(); i++)
            if(Character.isLetter(str.charAt(i)))
                return false;
        return true;
    }
    
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
                        stack.pop(); 
                    }
                    else { 
                        result += " ";
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
            if(Character.isDigit(token)) {
                String str = "";
		while (Character.isDigit(postfix.charAt(i)))
                    str += postfix.charAt(i++);
                stack.push(str);
                i--;
            }
        }
        return stack.peek();
    }
    
    public static String getResult() {
        Internet.online = false;
        String commandString = InputPanel.inputField.getText();
        String postfix = infix2Postfix(commandString);
        return calculator(postfix);
    }
}
