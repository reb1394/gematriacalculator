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
<head>
	<title>Gematria Calculator</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>
<body>

<h1>Gematria Calculator</h1>

Please enter the text to calculate below: 

<form name="form" action = "" method="get">
	<input type='text' name='word' value='<%=word %>'>
	<input type='submit' value='Calculate'>
</form>

<script type="text/javascript"> 
//<![CDATA[
 function virtKB(char) {
  	document.form.word.value = document.form.word.value + char;
 }
 //]]>
</script>

<table id="vk"> 
    <tr> 
        <td colspan="10" class="kbTitle"> 
            Virtual Keyboard מקלדת וירטואלית</td> 
    </tr> 
    <tr> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('א');">א</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ב');">ב</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ג');">ג</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ד');">ד</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ה');">ה</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ו');">ו</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ז');">ז</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ח');">ח</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ט');">ט</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('י');">י</td> 
    </tr> 
    <tr> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('כ');">כ</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ך');">ך</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ל');">ל</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('מ');">מ</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ם');">ם</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('נ');">נ</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ן');">ן</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ס');">ס</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ע');">ע</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('פ');">פ</td> 
    </tr> 
    <tr> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ף');">ף</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('צ');">צ</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ץ');">ץ</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ק');">ק</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ר');">ר</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ש');">ש</td> 
        <td class="keyboard" ondblclick="this.click()" onclick="virtKB('ת');">ת</td> 
        <td class="keyboard" title="space" ondblclick="this.click()" onclick="virtKB(' ');">_</td> 
        <td></td> 
    </tr> 
</table>

<%
	if(word != "") {
		// Display results
        
        char[] wordChar = word.toCharArray();
        for(GematriaMethod m : g.methods) {
        	out.println("<br>" + m.getEnglishName() + " = " + m.calc(wordChar));
        }
	}
%>

<p><a href="/test">Test Suite</a></p>

</body>
</html>