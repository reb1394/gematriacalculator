package gematriacalculator;

public abstract class GematriaResultType {
	public String name;
	public String nameHebrew;
	public String description;
	public String word;
	public int value;
	public int valueSofit;
	public boolean hasSofit;
	
	// COMMON FUNCTIONS
	
	protected int getCharVal(char letter) {
		switch(letter) {
			case 'א': return 1;
			case 'ב': return 2;
			case 'ג': return 3;
			case 'ד': return 4;
			case 'ה': return 5;
			case 'ו': return 6;
			case 'ז': return 7;
			case 'ח': return 8;
			case 'ט': return 9;
			case 'י': return 10;
			case 'כ':
			case 'ך': return 20;
			case 'ל': return 30;
			case 'מ':
			case 'ם': return 40;
			case 'נ':
			case 'ן': return 50;
			case 'ס': return 60;
			case 'ע': return 70;
			case 'פ':
			case 'ף': return 80;
			case 'צ':
			case 'ץ': return 90;
			case 'ק': return 100;
			case 'ר': return 200;
			case 'ש': return 300;
			case 'ת': return 400;
			default:  return 0;
		}
	}
	
	protected int getCharValSofit(char letter) {
		switch(letter) {
			case 'א': return 1;
			case 'ב': return 2;
			case 'ג': return 3;
			case 'ד': return 4;
			case 'ה': return 5;
			case 'ו': return 6;
			case 'ז': return 7;
			case 'ח': return 8;
			case 'ט': return 9;
			case 'י': return 10;
			case 'כ': return 20;
			case 'ל': return 30;
			case 'מ': return 40;
			case 'נ': return 50;
			case 'ס': return 60;
			case 'ע': return 70;
			case 'פ': return 80;
			case 'צ': return 90;
			case 'ק': return 100;
			case 'ר': return 200;
			case 'ש': return 300;
			case 'ת': return 400;
			case 'ך': return 500; 
			case 'ם': return 600;
			case 'ן': return 700;
			case 'ף': return 800;
			case 'ץ': return 900;
			default:  return 0;
		}
	}
	
	protected int getCharValOrdinal(char letter) {
		switch(letter) {
			case 'א': return 1;
			case 'ב': return 2;
			case 'ג': return 3;
			case 'ד': return 4;
			case 'ה': return 5;
			case 'ו': return 6;
			case 'ז': return 7;
			case 'ח': return 8;
			case 'ט': return 9;
			case 'י': return 10;
			case 'כ':
			case 'ך': return 11;
			case 'ל': return 12;
			case 'מ':
			case 'ם': return 13;
			case 'נ':
			case 'ן': return 14;
			case 'ס': return 15;
			case 'ע': return 16;
			case 'פ':
			case 'ף': return 17;
			case 'צ':
			case 'ץ': return 18;
			case 'ק': return 19;
			case 'ר': return 20;
			case 'ש': return 21;
			case 'ת': return 22;
			default:  return 0;
		}
	}
	
	protected int getCharValOrdinalSofit(char letter) {
		switch(letter) {
			case 'א': return 1;
			case 'ב': return 2;
			case 'ג': return 3;
			case 'ד': return 4;
			case 'ה': return 5;
			case 'ו': return 6;
			case 'ז': return 7;
			case 'ח': return 8;
			case 'ט': return 9;
			case 'י': return 10;
			case 'כ': return 11;
			case 'ל': return 12;
			case 'מ': return 13;
			case 'נ': return 14;
			case 'ס': return 15;
			case 'ע': return 16;
			case 'פ': return 17;
			case 'צ': return 18;
			case 'ק': return 19;
			case 'ר': return 20;
			case 'ש': return 21;
			case 'ת': return 22;
			case 'ך': return 23; 
			case 'ם': return 24;
			case 'ן': return 25;
			case 'ף': return 26;
			case 'ץ': return 27;
			default:  return 0;
		}
	}
	
	protected int doReduce(int number) {
		// Performs reduce (mispar katan) e.g. 15 = 6 (5 + 1), 23 = 5 (2+3) etc.
		if(number < 0) return 0;
		char charArray[] = Integer.toString(number).toCharArray();
		int reduced = 0;
		for(char c : charArray)
			reduced += Integer.parseInt(Character.toString(c));
		if(reduced > 9) reduced = doReduce(reduced);
		return reduced;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////
//
//   GEMATRIA METHODS
//
//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaResultTypeAbsolute extends GematriaResultType {

	public GematriaResultTypeAbsolute (String word) {
		this.word = word;
		this.name = "Absolute";
		this.nameHebrew = "מספר הכרחי";
		this.description = "Most common type of Gematria. Alef equals 1, beit equals 2, and so on. The tenth letter, yud is numerically equivalent to 10, and successive letters equal 20, 30, 40, and so on. The letter kuf near the end of the alphabet, equals 100; and the last letter, tav equals 400.";		
		
		for(char c : word.toCharArray() ) {
			this.value += getCharVal(c);
			this.valueSofit += getCharValSofit(c);
		}
		this.hasSofit = (this.value != this.valueSofit);
	}

}

class GematriaResultTypeOrdinal extends GematriaResultType {

	public GematriaResultTypeOrdinal (String word) {
		this.word = word;
		this.name = "Ordinal";
		this.nameHebrew = "מספר סידורי";
		this.description = "Each of the 22 letters is given an equivalent from one to twenty-two. For example, alef equals 1, kaf equals 11, taf = 22. In the sofit variant the final kaf equals 23, and final tzadik equal 27.";		
		
		for(char c : word.toCharArray() ) {
			this.value += getCharValOrdinal(c);
			this.valueSofit += getCharValOrdinalSofit(c);
		}
		this.hasSofit = (this.value != this.valueSofit);
	}

}


class GematriaResultTypeReduced extends GematriaResultType {

	public GematriaResultTypeReduced (String word) {
		this.word = word;
		this.name = "Reduced";
		this.nameHebrew = "מספר קטן";
		this.description = "Each letter is reduced to a figure of one digit. For example, in this reckoning, alef equals 1, yud equals 10, kuf equals 100) would all have a numerical value of 1; beit equals 2, kaf equals 20, and reish equals 200 would all have a numerical value of 2, and so on";		
		
		for(char c : word.toCharArray() ) {
			this.value += doReduce(getCharVal(c));
			this.valueSofit += doReduce(getCharValSofit(c));
		}
		this.hasSofit = (this.value != this.valueSofit);
	}

}

class GematriaResultTypeIntegralReduced extends GematriaResultType {

	public GematriaResultTypeIntegralReduced (String word) {
		this.word = word;
		this.name = "Integral Reduced";
		this.nameHebrew = "מספר קטן מספר";
		this.description = "In this method, the total numerical value of a word is reduced to one digit. Should the sum of these numbers exceed 9, the integer values of the total are repeatedly added to each other to produce a single-digit figure. The same value will be arrived at regardless of whether it is the absolute values, the ordinal values, or the reduced values that are being counted.";		
		
		for(char c : word.toCharArray() ) {
			this.value += getCharVal(c);
			this.valueSofit += getCharValSofit(c);
		}
		this.value = doReduce(this.value);
		this.valueSofit = doReduce(this.valueSofit);
		
		this.hasSofit = (this.value != this.valueSofit);
	}

}

class GematriaResultTypeAtbash extends GematriaResultType {

	public GematriaResultTypeAtbash (String word) {
		this.word = word;
		this.name = "Atbash";
		this.nameHebrew = "את בש";
		this.description = "Exchanges each letter in a word or a phrase by opposite letters. Opposite letters are determined by substituting the first letter of the Hebrew alphabet (Aleph) with the last letter (Tav), the second letter (Bet) with the next to last (Shin), etc";		
		
		for(char c : word.toCharArray() )
			this.value += getCharVal(doCharSubs(c));
		
		this.hasSofit = false;
	}
	
	private char doCharSubs(char letter) {
        switch(letter) {
            case 'א': return 'ת';
            case 'ב': return 'ש';
            case 'ג': return 'ר';
            case 'ד': return 'ק';
            case 'ה': return 'צ';
            case 'ו': return 'פ';
            case 'ז': return 'ע';
            case 'ח': return 'ס';
            case 'ט': return 'נ';
            case 'י': return 'מ';
            case 'כ':
            case 'ך': return 'ל';
            case 'ל': return 'כ';
            case 'מ':
            case 'ם': return 'י';
            case 'נ':
            case 'ן': return 'ט';
            case 'ס': return 'ח';
            case 'ע': return 'ז';
            case 'פ':
            case 'ף': return 'ו';
            case 'צ':
            case 'ץ': return 'ה';
            case 'ק': return 'ד';
            case 'ר': return 'ג';
            case 'ש': return 'ב';
            case 'ת': return 'א';
            default:  return letter;
        }
	}
	
}

class GematriaResultTypeAlbam extends GematriaResultType {

	public GematriaResultTypeAlbam (String word) {
		this.word = word;
		this.name = "Albam";
		this.nameHebrew = "אל בם";
		this.description = "The alphabet is divided in half, eleven letters in each section. The first letter of the first series is exchanged for the first letter of the second series, the second letter of the first series for the second letter of the second series and so forth.";		
		
		for(char c : word.toCharArray() )
			this.value += getCharVal(doCharSubs(c));
		
		this.hasSofit = false;
	}
	
	private char doCharSubs(char letter) {
		switch(letter) {
			case 'א': return 'ל';
			case 'ב': return 'מ';
			case 'ג': return 'נ';
			case 'ד': return 'ס';
			case 'ה': return 'ע';
			case 'ו': return 'פ';
			case 'ז': return 'צ';
			case 'ח': return 'ק';
			case 'ט': return 'ר';
			case 'י': return 'ש';
			case 'כ':
			case 'ך': return 'ת';
			case 'ל': return 'א';
			case 'מ':
			case 'ם': return 'ב';
			case 'נ':
			case 'ן': return 'ג';
			case 'ס': return 'ד';
			case 'ע': return 'ה';
			case 'פ':
			case 'ף': return 'ו';
			case 'צ':
			case 'ץ': return 'ז';
			case 'ק': return 'ח';
			case 'ר': return 'ט';
			case 'ש': return 'י';
			case 'ת': return 'כ';
			default:  return letter;
		}
	}
	
}

class GematriaResultTypeAvgad extends GematriaResultType {

	public GematriaResultTypeAvgad (String word) {
		this.word = word;
		this.name = "Avgad";
		this.nameHebrew = "אב גד";
		this.description = "Replaces each letter by the next one. Tav becomes Aleph";		
		
		for(char c : word.toCharArray() )
			this.value += getCharVal(doCharSubs(c));
		
		this.hasSofit = false;
	}
	
	private char doCharSubs(char letter) {
		switch(letter) {
			case 'א': return 'ב';
			case 'ב': return 'ג';
			case 'ג': return 'ד';
			case 'ד': return 'ה';
			case 'ה': return 'ו';
			case 'ו': return 'ז';
			case 'ז': return 'ח';
			case 'ח': return 'ט';
			case 'ט': return 'י';
			case 'י': return 'כ';
			case 'כ':
			case 'ך': return 'ל';
			case 'ל': return 'מ';
			case 'מ':
			case 'ם': return 'נ';
			case 'נ':
			case 'ן': return 'ס';
			case 'ס': return 'ע';
			case 'ע': return 'פ';
			case 'פ':
			case 'ף': return 'צ';
			case 'צ':
			case 'ץ': return 'ק';
			case 'ק': return 'ר';
			case 'ר': return 'ש';
			case 'ש': return 'ת';
			case 'ת': return 'א';
			default:  return letter;
		}
	}
}