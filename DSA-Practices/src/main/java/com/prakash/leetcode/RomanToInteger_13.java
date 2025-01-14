package com.prakash.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

	public static void main(String[] args) {

		RomanToInteger_13 obj = new RomanToInteger_13();
		
		System.out.println("RomanToInteger_13 - " + obj.romanToInt("XIVI")); // 10 + (-1 + 5) + 1

	}
	
	public int romanToInt(String s) {
        // Map to store Roman numeral values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = romanMap.get(s.charAt(i));

            // Check if this character is smaller than the next
            if (i < n - 1 && current < romanMap.get(s.charAt(i + 1))) {
                result -= current; // Subtract value
            } else {
                result += current; // Add value
            }
        }

        return result;
    }
	
}
