package com.prakash.leetcode;

public class ToLowerCase {

	public static void main(String[] args) {
		ToLowerCase toLowerCase = new ToLowerCase();
		String str = "Nantha Kumar";
		System.out.println("Result of toLowerCase : " + toLowerCase.toLowerCase(str));

	}
	public String toLowerCase(String input) {
		char[] inputChars = input.toCharArray();
		char[] outputChars = new char[inputChars.length];
		
		for(int i = 0; i < inputChars.length; i++) {
			if((int)inputChars[i] >=65 && (int)inputChars[i] <=90)
				outputChars[i] = (char)((int)inputChars[i] + 32);
			else
				outputChars[i] = inputChars[i];
		}
		return new String(outputChars);   
    }
}
