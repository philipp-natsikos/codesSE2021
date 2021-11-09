package org.hbrs.se1.ws21.uebung1.control;

import java.util.HashMap;

public class GermanTranslator implements Translator {

	public String date = "Okt/2021"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		HashMap<Integer, String> integerStringHashMap = new HashMap<>();
		integerStringHashMap.put(1, "eins");
		integerStringHashMap.put(2, "zwei");
		integerStringHashMap.put(3, "drei");
		integerStringHashMap.put(4, "vier");
		integerStringHashMap.put(5, "fünf");
		integerStringHashMap.put(6, "sechs");
		integerStringHashMap.put(7, "sieben");
		integerStringHashMap.put(8, "acht");
		integerStringHashMap.put(9, "neun");
		integerStringHashMap.put(10, "zehn");
		return integerStringHashMap.getOrDefault(number,"Übersetzung der Zahl " + number + " nicht\n" +
				"möglich" + version);
	}
		
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2021))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
