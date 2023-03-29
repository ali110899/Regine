package it.polito.tdp;

import java.util.List;

public class TestRegine {
	public static void main(String args[]) {
		RisolviRegine2 r = new RisolviRegine2() ;
		
		List<Integer>soluzione = r.trovaRegine(6);
		System.out.println(soluzione);
	}
}
