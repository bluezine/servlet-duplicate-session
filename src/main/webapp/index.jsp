<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.co.bluezine.duplicate.session.DuplicateSessionListener"%>
<%@page import="kr.co.bluezine.duplicate.session.DuplicateSessionCode"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<table>
		<tr>
			<td><%= (String) session.getAttribute(DuplicateSessionCode.SESSION_IDENTITY_KEY) %></td>
		</tr>
		<tr>
			<td><%= DuplicateSessionListener.sessions %></td>
		</tr>
	</table>
</body>
</html>
