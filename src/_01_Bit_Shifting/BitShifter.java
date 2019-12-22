package _01_Bit_Shifting;

import java.util.ArrayList;

public class BitShifter {
	public static void main(String[] args) {
		BitShifter bs = new BitShifter();
		// 1. Jot down the value of num in binary.
		int num = 4;
		int numShifted = num << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted);
		bs.convert(numShifted);
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		
		// 4. Try shifting num 3 places.
		numShifted = num << 3;
		System.out.println(numShifted);
		bs.convert(numShifted);
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
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
