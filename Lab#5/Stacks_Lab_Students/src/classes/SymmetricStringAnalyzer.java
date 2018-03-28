package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}

	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		// ADD MISSING CODE
		SLLStack <Character> stack = new SLLStack<Character>(); 
		for (int i=0; i < s.length(); i++) { 
			char c = s.charAt(i); 
			if (!Character.isLetter(c)){
				return false;
			}
			else{ // es letra
				if (Character.isUpperCase(c)){
					//hacer push
					stack.push(c);
				}

				//es minuscula
				else if (stack.isEmpty())
					return false; 
				else { // es minuscula y no esta vacio
					char t = stack.top(); 
					if (t == Character.toUpperCase(c))
						stack.pop();  
					else 
						return false; 
				}
			} 
		}
		return stack.isEmpty();  // need to change if necessary....		
	}

	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
			throws StringIsNotSymmetricException 
	{	String withP="";

	if(isValidContent()){

		for (int i=0; i < s.length(); i++){
			char c = s.charAt(i);

			if (Character.isUpperCase(c)){

				withP=withP+" <"+ c+" ";
			}
			else{
				withP=withP+ c+"> ";	
			}
		}
	}
	return withP; 
	}

}
