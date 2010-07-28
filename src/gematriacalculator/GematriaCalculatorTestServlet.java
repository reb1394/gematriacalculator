package gematriacalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

class GematriaCalculatorTester {
	public PrintWriter out;
	public int totalTests = 0;
	public int totalErrors = 0;
	
	
	public void testGematriaResultType(GematriaResultType result, int expectedValue, int expectedValueSofit, boolean expectedSofit) {
		totalTests++;
		
		if( 	result.value != expectedValue 
			||  result.valueSofit != expectedValueSofit
			||  result.hasSofit != expectedSofit ) {
			
			totalErrors++;
			// Log the error
			if(out != null) {
				out.println("<p><b>Test failed!</b>");
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;name = " + result.name);
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;word = " + result.word);
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;result = " + result.value + "(expected: " + expectedValue + ")");
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;result sofit = " + result.valueSofit + "(expected: " + expectedValueSofit + ")");
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;has sofit = " + result.hasSofit + "(expected: " + expectedSofit + ")");
			}
		}
	}
}


@SuppressWarnings("serial")
public class GematriaCalculatorTestServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
    	resp.setContentType("text/html; charset=UTF-8");       
        PrintWriter out = resp.getWriter();   
        GematriaCalculatorTester t = new GematriaCalculatorTester();
        t.out = out;
        out.println("<h1>Gematria Calculator Test Suite</h1>");
        
        
        // Test Absolute Method 
        t.testGematriaResultType(new GematriaResultTypeAbsolute("חסד"),72,72,false);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("חן"),58,708,true);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("ירוממוך"),322,802,true);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("סלה"),95,95,false);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("המברך"),267,747,true);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("בטובו"),25,25,false);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("לעשות"),806,806,false);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("ושאבתם"),749,1309,true);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("אומר"),247,247,false);
        t.testGematriaResultType(new GematriaResultTypeAbsolute("תקע בשופר"),1158,1158,false);

        // Test Ordinal Method
        t.testGematriaResultType(new GematriaResultTypeOrdinal("חסד"),27,27,false);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("חן"),22,33,true);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("ירוממוך"),79,91,true);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("סלה"),32,32,false);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("המברך"),51,63,true);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("בטובו"),25,25,false);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("לעשות"),77,77,false);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("ושאבתם"),65,76,true);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("אומר"),40,40,false);
        t.testGematriaResultType(new GematriaResultTypeOrdinal("תקע בשופר"),123,123,false);

        // Test Reduced Method
        t.testGematriaResultType(new GematriaResultTypeReduced("חסד"),18,18,false);
        t.testGematriaResultType(new GematriaResultTypeReduced("חן"),13,15,true);
        t.testGematriaResultType(new GematriaResultTypeReduced("ירוממוך"),25,28,true);
        t.testGematriaResultType(new GematriaResultTypeReduced("סלה"),14,14,false);
        t.testGematriaResultType(new GematriaResultTypeReduced("המברך"),15,18,true);
        t.testGematriaResultType(new GematriaResultTypeReduced("בטובו"),25,25,false);
        t.testGematriaResultType(new GematriaResultTypeReduced("לעשות"),23,23,false);
        t.testGematriaResultType(new GematriaResultTypeReduced("ושאבתם"),20,22,true);
        t.testGematriaResultType(new GematriaResultTypeReduced("אומר"),13,13,false);
        t.testGematriaResultType(new GematriaResultTypeReduced("תקע בשופר"),33,33,false);

        // Test Integral Reduced Method
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("חסד"),9,9,false);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("חן"),4,6,true);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("ירוממוך"),7,1,true);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("סלה"),5,5,false);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("המברך"),6,9,true);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("בטובו"),7,7,false);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("לעשות"),5,5,false);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("ושאבתם"),2,4,true);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("אומר"),4,4,false);
        t.testGematriaResultType(new GematriaResultTypeIntegralReduced("תקע בשופר"),6,6,false);

        // Test Atbash Method
        t.testGematriaResultType(new GematriaResultTypeAtbash("חסד"),168,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("חן"),69,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("ירוממוך"),253,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("סלה"),118,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("המברך"),433,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("בטובו"),810,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("לעשות"),110,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("ושאבתם"),793,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("אומר"),493,0,false);
        t.testGematriaResultType(new GematriaResultTypeAtbash("תקע בשופר"),403,0,false);

        // Test Albam Method
        t.testGematriaResultType(new GematriaResultTypeAlbam("חסד"),164,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("חן"),103,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("ירוממוך"),873,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("סלה"),75,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("המברך"),521,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("בטובו"),440,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("לעשות"),116,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("ושאבתם"),182,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("אומר"),121,0,false);
        t.testGematriaResultType(new GematriaResultTypeAlbam("תקע בשופר"),178,0,false);

        // Test Avgad Method
        t.testGematriaResultType(new GematriaResultTypeAvgad("חסד"),84,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("חן"),69,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("ירוממוך"),464,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("סלה"),116,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("המברך"),389,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("בטובו"),30,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("לעשות"),528,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("ושאבתם"),463,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("אומר"),359,0,false);
        t.testGematriaResultType(new GematriaResultTypeAvgad("תקע בשופר"),1081,0,false);

        out.println("<br>Total tests = " + t.totalTests);
        out.println("<br>Tests errors = " + t.totalErrors);
        
	}
}
