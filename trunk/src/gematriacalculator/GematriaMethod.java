package gematriacalculator;

public interface GematriaMethod {
	public int calc(char[] word);
	public String getEnglishName();
	public String getHebrewName();
	public String getDescription();
}

class GematriaCommonFunctions {
	public int getCharVal(char letter) {
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
	
	public int getCharValSofit(char letter) {
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
	
	public int getCharValOrdinal(char letter) {
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
	
	public int getCharValOrdinalSofit(char letter) {
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
	
	public int doReduce(int number) {
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

class GematriaMethodAbsolute implements GematriaMethod {
	public String getEnglishName()		{return "Absolute";}
	public String getHebrewName()		{return "מספר הכרחי";}
	public String getDescription()		{return "Most common type of Gematria";}

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			i += f.getCharVal(c);
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodAbsoluteSofit implements GematriaMethod {
	public String getEnglishName()		{return "Absolute (Sofit)";}
	public String getHebrewName()		{return "מספר הכרחי - סופית";}
	public String getDescription()		{return "Most common type of Gematria, with Sofit letters";}

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			i += f.getCharValSofit(c);
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodOrdinal implements GematriaMethod {
	public String getEnglishName()		{return "Ordinal";}
	public String getHebrewName()		{return "מספר סידורי";}
	public String getDescription()		{return "כ = 11,ל = 12 etc";}

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			i += f.getCharValOrdinal(c);
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodOrdinalSofit implements GematriaMethod {
	public String getEnglishName()		{return "Ordinal (Sofit)";}
	public String getHebrewName()		{return "מספר סידורי - סופית";}
	public String getDescription()		{return "כ = 11,ל = 12 etc with Sofit";}

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			i += f.getCharValOrdinalSofit(c);
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodReduced implements GematriaMethod {
	public String getEnglishName()		{return "Reduced";}
	public String getHebrewName()		{return "מספר קטן";}
	public String getDescription()		{return "א,י,ק = 1. ב,כ,ר = 200";}

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			i += f.doReduce(f.getCharVal(c));
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodReducedSofit implements GematriaMethod {
	public String getEnglishName()		{return "Reduced (Sofit)";}
	public String getHebrewName()		{return "מספר קטן - סופית";}
	public String getDescription()		{return "א,י,ק = 1. ב,כ,ר = 200 with sofit";}

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			i += f.doReduce(f.getCharValSofit(c));
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodAtbash implements GematriaMethod {
	public String getEnglishName()		{return "Atbash";}
	public String getHebrewName()		{return "את בש";}
	public String getDescription()		{return "Atbash";}
	
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

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			char s = doCharSubs(c);
			i += f.getCharVal(s);
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodAlbam implements GematriaMethod {
	public String getEnglishName()		{return "Albam";}
	public String getHebrewName()		{return "אל בם";}
	public String getDescription()		{return "Albam";}
	
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

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			char s = doCharSubs(c);
			i += f.getCharVal(s);
     	}
		return i;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////

class GematriaMethodAvgad implements GematriaMethod {
	public String getEnglishName()		{return "Avgad";}
	public String getHebrewName()		{return "אב גד";}
	public String getDescription()		{return "Avgad";}
	
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

	public int calc(char[] word) {
		GematriaCommonFunctions f = new GematriaCommonFunctions();
		int i = 0;
		for(char c : word) {
			char s = doCharSubs(c);
			i += f.getCharVal(s);
     	}
		return i;
	}
}
