<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
	//セッションを破棄
	session.invalidate();

	// ログアウト完了画面へリダイレクト
	response.sendRedirect("入居者ログアウト完了.jsp");
%>