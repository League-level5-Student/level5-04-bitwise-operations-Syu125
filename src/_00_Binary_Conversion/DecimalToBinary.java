package _00_Binary_Conversion;

import java.util.ArrayList;

public class DecimalToBinary {
	public static void main(String[] args) {
		//Converting a decimal number to binary is a little trickier.
		
		//EXAMPLE: Convert 43 to binary
		
		/*
		 * Step 1: Start with one and add a digit the left that is double the value of the previous number.
		 *         Stop when you've passed the target number        
		 *         eg. 43
		 *         	64	32	16	8	4	2	1
		 *        
		 *	Step 2: Remove the left most value (the one that is higher than the target). 
		 *			eg. 43
		 *         	32	16	8	4	2	1
		 *         
		 *  Step 3: Find the combination of values that add up to the target number.
		 *  		eg. 43
		 *         	32	16	8	4	2	1
		 *          43 = 32 + 8 + 2 + 1
		 *         
		 *  Step 4: Every matching number in the list is a 1, and non-matching is a 0.
		 *  		eg. 43
		 *         	32	16	8	4	2	1
		 *          43 = 32 + 8 + 2 + 1
		 *         
		 *          1    0   1   0   1   1
		 *          32	16	 8	 4	 2	 1
		 *         
		 *         43 in decimal is 101011 in binary!
		 */
		DecimalToBinary dtb = new DecimalToBinary();
		dtb.convert(43);
		

	}
	void convert(int decimal){
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 1;
		for (int i = 0; i < decimal; i++) {
			if(count<= decimal){
				a.add(count);
				count*=2;
			}
		}
		int [] binary =  new int[a.size()];
		for (int i = a.size()-1; i >= 0 ; i--) {
			if(decimal-a.get(i) >=0 ){
				decimal -= a.get(i);
				binary[a.size()-1-i] = 1;
			}else{
				binary[a.size()-1-i] = 0;
			}
		}
		
		String value = "";
		for (int i : binary) {
			value = value.concat(String.valueOf(i));
		}
		System.out.println(value);
	}
}
