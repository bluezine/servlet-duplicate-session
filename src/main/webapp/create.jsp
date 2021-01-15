<%@page import="kr.co.bluezine.duplicate.session.DuplicateSessionCode"%>
<%
	session.setAttribute(DuplicateSessionCode.SESSION_IDENTITY_KEY, request.getParameter("id"));
%>