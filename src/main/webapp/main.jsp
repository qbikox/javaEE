<jsp:useBean id="retrievedHash" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hash Generator</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<h1><%= "Generate hash with SHAKE-128" %>
</h1>
<br/>
<br>
<form action="${pageContext.request.contextPath}/" method="post" enctype="multipart/form-data">
    <label for="file">Select a file:</label>
    <input type="file" id="file" name="file">
    <br>
    <br>
    <label for="length">Select a hash length:</label>
    <input type="number" id="length" name="length" value="256" step="8" min="8" data-option>
    <br>
    <br>
    <label for="saving">Is to save:</label>
    <input type="checkbox" id="saving" name="saving" value="true">
    <br>
    <br>
    <input type="submit" value="Generate">
</form>
<br>
<br>
<span>${retrievedHash}</span>
</body>
</html>