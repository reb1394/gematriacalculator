<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="gematriacalculator.*" %>

<%!	GematriaCalculator g = new GematriaCalculator(); %>
<%
	String word = request.getParameter("word");
	if(word == null) word = "";
%>

<html>
<head><title>Gematria Calculator</title></head>
<body>

<h1>Gematria Calculator</h1>

Please enter the text to calculate below: 

<form action = "" method="get">
	<input type='text' name='word' value='<%=word %>'>
	<input type='submit' value='Calculate'>
</form>

<%
	if(word != "") {
		// Display results
        out.println("<hr>");
        
        char[] wordChar = word.toCharArray();
        for(GematriaMethod m : g.methods) {
        	out.println("<br>" + m.getEnglishName() + " = " + m.calc(wordChar));
        }
	}
%>

<hr>
<a href="/test">Test Suite</a>

</body>
</html>