package com.prakash.leetcode;


public class BitwiseOperator {

	public static void main(String[] args) {
		
		int a = -5, b = -4;
		
		int c = add(a,b);
		int d = subtract(a,b);
		
		System.out.println("Input a = " + a + ", in Binary = " + Integer.toBinaryString(a));
		System.out.println("Input b = " + b + ", in Binary = " + Integer.toBinaryString(b));
		System.out.println("Addition Output (a+b) = " + c + ", in Binary = " + Integer.toBinaryString(c));
		System.out.println("Subtraction Output (a-b) = " + d + ", in Binary = " + Integer.toBinaryString(d));

	}

	private static int subtract(int a, int b) {
		// 2's complement gives opposite sign number => (~b + 1) - (5 => -5) - (-5= 5(~b + 1))
		return add(a,add(~b, 1));
	}

	private static int add(int a, int b) {
		
		int carry = a & b;
		if(carry == 0)
			return a ^ b;
		
		return add(a ^ b, carry << 1);
	}

}
