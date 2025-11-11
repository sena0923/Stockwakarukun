<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
  // セッションを破棄
  session.invalidate();

  // ログアウト完了画面へリダイレクト
  response.sendRedirect("./親族ログアウト完了.jsp");
%>