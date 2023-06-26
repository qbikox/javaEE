<%@ page import="com.example.hashapp.model.Hash" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Hash Generator</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<h1>Add hash:</h1>
<br>
<form action="${pageContext.request.contextPath}/data" method="POST">
    <label for="value">Select a hash value:</label>
    <input type="text" id="value" name="value">
    <input type="submit" value="Add">
</form>
<h1>Saved hashes:</h1>
<br>
<jsp:useBean id="hashList" scope="request" type="java.util.List<com.example.hashapp.model.Hash>"/>

<% for (Hash hash : hashList) { %>
<span><%= "id: " + hash.getId() + " hash: " + hash.getHashValue() %></span>
<form action="${pageContext.request.contextPath}/delete?id=<%=hash.getId()%>" method="POST">
    <button type="submit">Delete</button>
</form>
<% } %>
</body>
</html>
