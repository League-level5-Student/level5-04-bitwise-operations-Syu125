package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.jar.Manifest;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	public static void main(String[] args) {
		convertBase64Char('B');
	}

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		for (int i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				int value = i;
				byte bin = convertDecimal(convert(value));
				System.out.println("answer: " + bin);
				return bin;
			}
		}
		return 0;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		byte[] test = new byte[4];
		byte[] result = new byte[3];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < base64Chars.length; j++) {
				if (base64Chars[j] == s.charAt(i)) {
					byte bin = convertDecimal(convert(j));
					test[i] = bin;
				}
			}
		}
		int count = 0;
		result[0] = (byte) ((test[count] << 2) | (test[count + 1] >> 4));
		count++;
		result[1] = (byte) ((test[count] << 4) | (test[count + 1] >> 2));
		count++;
		result[2] = (byte) ((test[count] << 6) | (test[count + 1]));
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;

	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] test = new byte[file.length()];
		byte[] result = new byte[file.length() - file.length() / 4];
		for (int i = 0; i < file.length(); i++) {
			for (int j = 0; j < base64Chars.length; j++) {
				if (base64Chars[j] == file.charAt(i)) {
					byte bin = convertDecimal(convert(j));
					test[i] = bin;
				}
			}
		}
		int add = 0;
		for (int j = 0; j < result.length; j+=3) {
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					result[j] = (byte) ((test[i + add] << 2) | (test[i + 1 + add] >> 4));
				} else if (i == 1) {
					result[j+1] = (byte) ((test[i + add] << 4) | (test[i + 1 + add] >> 2));
				} else {
					result[j+2] = (byte) ((test[i + add] << 6) | (test[i + 1 + add]));
				}
				System.out.println("result " + result[j]);
			}
			
			add += 4;
		}
		for (byte b : result) {
			System.out.println("byte: " + b);
		}
		return result;
	}

	public static int[] convert(int b) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count = 1;
		for (int i = 0; i < b; i++) {
			if (count <= b) {
				a.add(count);
				count *= 2;
			}
		}
		int[] binary = new int[a.size()];
		for (int i = a.size() - 1; i >= 0; i--) {
			if (b - a.get(i) >= 0) {
				b -= a.get(i);
				binary[a.size() - 1 - i] = 1;
			} else {
				binary[a.size() - 1 - i] = 0;
			}
		}
		return binary;
	}

	public static byte convertDecimal(int[] binary) {
		int count = 1;
		byte num = 0;
		int[] decimal = new int[binary.length];
		for (int j = binary.length - 1; j >= 0; j--) {
			decimal[j] = count;
			count *= 2;
			num += decimal[j] * binary[j];
		}

		return num;
	}
}
