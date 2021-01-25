<%@ page import="org.owasp.encoder.Encode" %>
<!DOCTYPE html>
<html>
<head><title>Result</title></head>
<body>
<center>
<h1>
    Request output!
</h1>
    <p> <a href="/UrlCheck">back</a> </p>
<%
String url = (String) request.getAttribute("url");
String source = (String) request.getAttribute("source");
out.println(url + "<br>");
out.println("<hr>");
out.println("<textarea rows=\"50\" cols=\"100\">");
out.println(Encode.forHtml(source));
out.println("</textarea>");
out.println("<hr>");
%>
</center>
</body>
</html>