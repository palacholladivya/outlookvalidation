package com.simple.base;

import org.codehaus.plexus.util.Base64;

public class EncodingDecoding {

	
	public String encodeString(String text) {
		byte[] encoded = Base64.encodeBase64(text.getBytes());
		String encodedString = new String(encoded);
		System.out.println("Encoded String is: " + encodedString);
		return encodedString;
		
	}
	
	public String decodeString(String text) {
		byte[] decoded =  Base64.decodeBase64(text.getBytes());
		String decodedString =  new String(decoded);
		System.out.println(decodedString);
		return decodedString;
	}
	
	
	public static void main(String[] args) {
		EncodingDecoding en =  new EncodingDecoding();
		en.encodeString("Narayanarao1@");
	}
}

