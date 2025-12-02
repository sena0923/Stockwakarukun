<%-- 介護士アカウント情報表示画面 --%>

<%-- 介護士ログイン画面 --%>
<%-- ログインJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		アカウント表示
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="#" method="get">
			<a href="" class="back">戻る</a>

			<h1>アカウント情報</h1>


			<div class="controll">
			<a class="">職員番号：${caregiver.staffid}</a>
			<br>
			<a class="">職員名：${caregiver.name}</a>
			<br>
			<a class="">パスワード：${caregiver.password}</a>
	        </div>


	        <div class="button-group">
	            <button class="btn-info" type="submit">変更</button>

			</div>
		</form>
	</c:param>
</c:import>





<%--
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>介護士情報</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
  }

  /* 中央配置 */
  body {
    display: flex;
    flex-direction: column;
    justify-content: center; /* 縦方向中央 */
    align-items: center;     /* 横方向中央 */
    background-color: #f5f5f5;
    font-family: sans-serif;
  }

  h1 {
    margin-bottom: 20px;
  }

  p {
    margin: 5px 0;
    font-size: 18px;
  }

  a {
    text-decoration: none;
    background: #b8d200;
    color: #000;
    border-radius: 0.25em;
    padding: 1em 2em 0.8em;
    line-height: 1;
    display: inline-block;
    font-weight: bold;
    margin-top: 10px;
  }

  a:hover {
    background: #a5bf00;
  }

  /* 戻るボタンのスタイル */
  .back-button {
    background: #ccc;
    color: #000;
    margin-top: 30px;
  }

  .back-button:hover {
    background: #999;
  }
</style>
</head>


<body>
  <h1>介護士情報</h1>
  <p>名前 | ○○</p>
  <p>職員番号 | 1234</p>

  <a href="cg_infoChange.jsp">情報更新</a>
  <a href="logoutkai.jsp">ログアウト</a>
  <a href="kai_menu.jsp" class="back-button">戻る</a>
</body>
</html>
--%>