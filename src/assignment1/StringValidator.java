package assignment1;


/**
 * Validates a String and checks if brackets are correct
 * @author danielhertzman-ericson
 *
 */
public class StringValidator {
	private String input;
	private Stack stack;
	
	public StringValidator(String string, Stack stack) {
		
		this.input = string;
		this.stack = stack;
	
	}
	
	/**
	 * Checks if brackets in the String are correct.
	 * @return true if brackets are correct
	 */
	public boolean checkText() {	
		
		if (input != null) {
			
			for (int i = 0; i < input.length(); i++) {
				
				char c = input.charAt(i);
				
				if (c == '(' || c == '[' || c == '{') {
					
					stack.push(c);
					
				}
	
				if (c == ')' || c == ']' || c == '}') {
					
					char o = (char)stack.pop();
					if (o == 0) 
						return false;
					
					
					switch (c) {
						
					case ')':  
						if (o != '(')
							return false;
						break;
						
					case ']':
						if (o != '[') 
							return false;
						break;
						
					case '}':
						if (o != '{')
							return false;
						break;
					}
				}
			}
		}
		
		return stack.isEmpty();
		
		
	}
	
	public String getText() {
		return input;
	}

}
