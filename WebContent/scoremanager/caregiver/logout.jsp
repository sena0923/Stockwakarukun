<%-- 本当にログアウトしても大丈夫ですか画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		ログアウトしますか？
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout.css">
	</c:param>

	<c:param name="content">
	<div class="container">
		  <h1>ログアウトしますか</h1>
			<div>
				<a class="logout_link" href="KaiLogout.action">はい</a>
				<a class="logout_link" href="#" onclick="history.back()">いいえ</a>
			</div>
	</div>
	</c:param>
</c:import>


<%--
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>ログアウト確認</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
  }

  /* Flexboxで中央寄せ */
  body {
    display: flex;
    flex-direction: column; /* 縦方向に並べる */
    justify-content: center; /* 垂直中央 */
    align-items: center;     /* 水平中央 */
    background-color: #f5f5f5;
    font-family: sans-serif;
  }

  h1 {
    margin-bottom: 20px;
  }

  a {
    display: inline-block;
    margin: 0 10px;
    padding: 10px 20px;
    text-decoration: none;
    background-color: #b8d200;
    color: #000;
    border-radius: 6px;
    font-weight: bold;
  }

  a:hover {
    background-color: #a5bf00;
  }
</style>
</head>
<body>
  <h1>ログアウトしますか</h1>
  <div>
    <a href="Yes.jsp">はい</a>
    <a href="MYP.jsp">いいえ</a>
  </div>
</body>
</html>

--%>