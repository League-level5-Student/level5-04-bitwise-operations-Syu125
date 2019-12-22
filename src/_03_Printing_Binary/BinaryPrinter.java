package _03_Printing_Binary;

import java.util.ArrayList;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	public static void main(String[] args) {
		BinaryPrinter bp = new BinaryPrinter();
		Byte b = 64;
		Short s = 20;
		bp.printByteBinary(b);
		bp.printShortBinary(s);
	}
	public void printByteBinary(byte b) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 1;
		for (int i = 0; i < b; i++) {
			if(count<= b){
				a.add(count);
				count*=2;
			}
		}
		int [] binary =  new int[a.size()];
		for (int i = a.size()-1; i >= 0 ; i--) {
			if(b-a.get(i) >=0 ){
				b -= a.get(i);
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
	
	public void printShortBinary(short s) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 1;
		for (int i = 0; i < s; i++) {
			if(count<= s){
				a.add(count);
				count*=2;
			}
		}
		int [] binary =  new int[a.size()];
		for (int i = a.size()-1; i >= 0 ; i--) {
			if(s-a.get(i) >=0 ){
				s -= a.get(i);
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
	
	public void printIntBinary(int i) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 1;
		for (int j = 0; j < i; j++) {
			if(count<= i){
				a.add(count);
				count*=2;
			}
		}
		int [] binary =  new int[a.size()];
		for (int j = a.size()-1; j >= 0 ; j--) {
			if(i-a.get(j) >=0 ){
				i -= a.get(j);
				binary[a.size()-1-j] = 1;
			}else{
				binary[a.size()-1-j] = 0;
			}
		}
		
		String value = "";
		for (int j : binary) {
			value = value.concat(String.valueOf(j));
		}
		System.out.println(value);
	}
	
	public void printLongBinary(long l) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 1;
		for (int i = 0; i < l; i++) {
			if(count<= l){
				a.add(count);
				count*=2;
			}
		}
		int [] binary =  new int[a.size()];
		for (int i = a.size()-1; i >= 0 ; i--) {
			if(l-a.get(i) >=0 ){
				l -= a.get(i);
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
