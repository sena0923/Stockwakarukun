<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
  session.invalidate();
  response.sendRedirect("入居者/入居者ログアウト完了.jsp");
%>