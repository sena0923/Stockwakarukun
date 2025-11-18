<%-- 親族アカウント情報表示画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseSin.jsp" %>
<link rel="stylesheet" href="../css/base.css">

<main>
  	<h2 style="font-size: 50px;">ユーザー情報</h2>

	<c:if test="${not empty relatives}">
	    <p>親族ID: ${relatives.rt_id}</p>
	    <p>名前: ${relatives.name}</p>
	    <p>パスワード: ${relatives.password}</p>
  	</c:if>


  	<div class="button-container">
	    <button onclick="location.href='./rtHome.jsp'">戻る</button>
	    <button onclick="location.href='./rtInfoChange.jsp'">変更する</button>
  	</div>
</main>

<style>
  main {
    font-family: "Hiragino Sans", "Meiryo", sans-serif;
  }

  h2 {
    margin: 0;
    height: 15vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  p {
    margin: 0;
    height: 10vh;
    display: flex;
    justify-content: center;
    align-items: center;
    font-weight: bold;
    color: #333;
  }

  .button-container {
    display: flex;
    gap: 15px;
    justify-content: center;
  }

  button {
    padding: 10px 20px;
    font-size: 16px;
    font-weight: bold;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    color: #fff;
    background-color: #4CAF50;
    transition: background-color 0.3s;
  }

  button:hover {
    background-color: #45a049;
  }
</style>