package gematriacalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

class GematriaCalculatorTester {
	public PrintWriter out;
	public GematriaMethod method;
	public int totalTests = 0;
	public int totalErrors = 0;
	
	public void doTest(String testString, int expectedResult) {
		int result = method.calc(testString.toCharArray());
		totalTests++;
		
		if(result != expectedResult) {
			totalErrors++;
			// Log the error
			if(out != null) {
				out.println("<p><b>Test failed!</b>");
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;method = " + method.getEnglishName());
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;string = " + testString);
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;expected result = " + expectedResult);
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;returned result = " + result);
			}
		}
	}
	
	public void doTest(String test, int result, int expectedResult) {
		totalTests++;
		
		if(result != expectedResult) {
			totalErrors++;
			// Log the error
			if(out != null) {
				out.println("<p><b>Test failed!</b>");
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;test = " + test);
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;expected result = " + expectedResult);
				out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;returned result = " + result);
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
        out.println("<h1>Gematria Calculator Test Suite</h1>");
        
        GematriaCalculatorTester tester = new GematriaCalculatorTester();
        tester.out = out;
              
        tester.method = new GematriaMethodAbsolute();
        tester.doTest("חסד",72);
        tester.doTest("חן",58);
        tester.doTest("ירוממוך",322);
        tester.doTest("סלה",95);
        tester.doTest("המברך",267);
        tester.doTest("בטובו",25);
        tester.doTest("לעשות",806);
        tester.doTest("ושאבתם",749);
        tester.doTest("אומר",247);
        tester.doTest("תקע בשופר",1158);
        
        tester.method = new GematriaMethodAbsoluteSofit();
        tester.doTest("חסד",72);
        tester.doTest("חן",708);
        tester.doTest("ירוממוך",802);
        tester.doTest("סלה",95);
        tester.doTest("המברך",747);
        tester.doTest("בטובו",25);
        tester.doTest("לעשות",806);
        tester.doTest("ושאבתם",1309);
        tester.doTest("אומר",247);
        tester.doTest("תקע בשופר",1158);
        
        tester.method = new GematriaMethodOrdinal();
        tester.doTest("חסד",27);
        tester.doTest("חן",22);
        tester.doTest("ירוממוך",79);
        tester.doTest("סלה",32);
        tester.doTest("המברך",51);
        tester.doTest("בטובו",25);
        tester.doTest("לעשות",77);
        tester.doTest("ושאבתם",65);
        tester.doTest("אומר",40);
        tester.doTest("תקע בשופר",123);
        
        tester.method = new GematriaMethodOrdinalSofit();
        tester.doTest("חסד",27);
        tester.doTest("חן",33);
        tester.doTest("ירוממוך",91);
        tester.doTest("סלה",32);
        tester.doTest("המברך",63);
        tester.doTest("בטובו",25);
        tester.doTest("לעשות",77);
        tester.doTest("ושאבתם",76);
        tester.doTest("אומר",40);
        tester.doTest("תקע בשופר",123);
        
        tester.method = new GematriaMethodReduced();
        tester.doTest("חסד",18);
        tester.doTest("חן",13);
        tester.doTest("ירוממוך",25);
        tester.doTest("סלה",14);
        tester.doTest("המברך",15);
        tester.doTest("בטובו",25);
        tester.doTest("לעשות",23);
        tester.doTest("ושאבתם",20);
        tester.doTest("אומר",13);
        tester.doTest("תקע בשופר",33);
        
        tester.method = new GematriaMethodReducedSofit();
        tester.doTest("חסד",18);
        tester.doTest("חן",15);
        tester.doTest("ירוממוך",28);
        tester.doTest("סלה",14);
        tester.doTest("המברך",18);
        tester.doTest("בטובו",25);
        tester.doTest("לעשות",23);
        tester.doTest("ושאבתם",22);
        tester.doTest("אומר",13);
        tester.doTest("תקע בשופר",33);
        
        tester.method = new GematriaMethodIntegralReduced();
        tester.doTest("חסד",9);
        tester.doTest("חן",4);
        tester.doTest("ירוממוך",7);
        tester.doTest("סלה",5);
        tester.doTest("המברך",6);
        tester.doTest("בטובו",7);
        tester.doTest("לעשות",5);
        tester.doTest("ושאבתם",2);
        tester.doTest("אומר",4);
        tester.doTest("תקע בשופר",6);
        
        tester.method = new GematriaMethodIntegralReducedSofit();
        tester.doTest("חסד",9);
        tester.doTest("חן",6);
        tester.doTest("ירוממוך",1);
        tester.doTest("סלה",5);
        tester.doTest("המברך",9);
        tester.doTest("בטובו",7);
        tester.doTest("לעשות",5);
        tester.doTest("ושאבתם",4);
        tester.doTest("אומר",4);
        tester.doTest("תקע בשופר",6);
        
        // test common functions
        GematriaCommonFunctions f = new GematriaCommonFunctions();
        tester.doTest("doReduce(-5)",f.doReduce(-5),0);
        tester.doTest("doReduce(0)",f.doReduce(0),0);
        tester.doTest("doReduce(7)",f.doReduce(7),7);
        tester.doTest("doReduce(9)",f.doReduce(9),9);
        tester.doTest("doReduce(1)",f.doReduce(1),1);
        tester.doTest("doReduce(2)",f.doReduce(2),2);       
        tester.doTest("doReduce(69)",f.doReduce(69),6);
        tester.doTest("doReduce(35)",f.doReduce(35),8);
        tester.doTest("doReduce(68)",f.doReduce(68),5);
        tester.doTest("doReduce(81)",f.doReduce(81),9);
        tester.doTest("doReduce(98)",f.doReduce(98),8);
        tester.doTest("doReduce(406)",f.doReduce(406),1);
        tester.doTest("doReduce(282)",f.doReduce(282),3);
        tester.doTest("doReduce(207)",f.doReduce(207),9);
        tester.doTest("doReduce(246)",f.doReduce(246),3);
        tester.doTest("doReduce(812746)",f.doReduce(812746),1);
        tester.doTest("doReduce(425341)",f.doReduce(425341),1);
        tester.doTest("doReduce(658135)",f.doReduce(658135),1);
        tester.doTest("doReduce(664464)",f.doReduce(664464),3);
        tester.doTest("doReduce(608639)",f.doReduce(608639),5);

        out.println("<br>Total tests = " + tester.totalTests);
        out.println("<br>Tests errors = " + tester.totalErrors);
	}
}
