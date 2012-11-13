/**
 * 
 */
package code;

/**
 * @author Oded
 *
 * Commments by Tom Hedges
 *
 */
public class NumberEncoder {

	// Initiate empty array of 'chars' called "code" 
	private char[] code = null;
	// Initiate empty array of 'chars' called "invertedCode" 
	private char[] invertedCode = null;

	

	public NumberEncoder(String newCode){
		// Initiate string called "lim", containing "09"
		String lim = new String("09");
		// Initiate array of 'chars' called "limits", containing '0' and '9'
		char[] limits = lim.toCharArray();
		
		// code is null on first pass, so no error
		if(code != null) throw new NumberFormatException("code already set!");
		// if entered string is wrong length, then show error
		if(newCode.length() != 10) throw new NumberFormatException("replaceWithString wrong length!");
		
		invertedCode = new char[newCode.length()];		
		code = newCode.toCharArray();
		if (!isNumeric(code)) throw new NumberFormatException("Non digit in code - v01!");
		
		for(char i = limits[0]; i<=limits[1]; i++){
			invertedCode[Character.getNumericValue(code[Character.getNumericValue(i)])] = i;
		}
	}



	public String decode(String number) {
		char[] decodedNumber = number.toCharArray();
		int digit;

		for(int i=0; i< decodedNumber.length; i++){
			digit = Character.getNumericValue(decodedNumber[i]);
			switch(digit){
			case 0: decodedNumber[i] = code[digit]; break;
			case 1: decodedNumber[i] = code[digit]; break;
			case 2: decodedNumber[i] = code[digit]; break;
			case 3: decodedNumber[i] = code[digit]; break;
			case 4: decodedNumber[i] = code[digit]; break;
			case 5: decodedNumber[i] = code[digit]; break;
			case 6: decodedNumber[i] = code[digit]; break;
			case 7: decodedNumber[i] = code[digit]; break;
			case 8: decodedNumber[i] = code[digit]; break;
			case 9: decodedNumber[i] = code[digit]; break;
			default: throw new NumberFormatException("Non digit in code - v02");
			}
		}
		return new String(decodedNumber);
	}
	
	public String encode(String number) {
		char[] encodedNumber = number.toCharArray();
		int digit;
		for(int i=0; i< encodedNumber.length; i++){
			digit = Character.getNumericValue(encodedNumber[i]);
			switch(digit){
			case 0: encodedNumber[i] = invertedCode[digit]; break;
			case 1: encodedNumber[i] = invertedCode[digit]; break;
			case 2: encodedNumber[i] = invertedCode[digit]; break;
			case 3: encodedNumber[i] = invertedCode[digit]; break;
			case 4: encodedNumber[i] = invertedCode[digit]; break;
			case 5: encodedNumber[i] = invertedCode[digit]; break;
			case 6: encodedNumber[i] = invertedCode[digit]; break;
			case 7: encodedNumber[i] = invertedCode[digit]; break;
			case 8: encodedNumber[i] = invertedCode[digit]; break;
			case 9: encodedNumber[i] = invertedCode[digit]; break;
			default: throw new NumberFormatException("Non digit in number - v03");
			}
		}
		return new String(encodedNumber);
	}
	
	
	public boolean isNumeric(char[] candidate){
		for(int i=0; i< candidate.length; i++){
			if (!Character.isDigit(candidate[i]))	return false ;
		}		
		return true;
	}
	
	
}