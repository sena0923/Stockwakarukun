<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseNyu.jsp" %>
<link rel="stylesheet" href="../css/base.css">
<main>
	  <h2 style="font-size: 50px;">ユーザー情報</h2>

	  <form class="content" action="NyuDisplayExecute.action" method="get">

			<span>ユーザーID：${rd_id}</span><br>
      	    <span>名前：${name}</span><br>
            <span>パスワード：${password}</span><br>
	  </form>

	  <%--
=======
	  <form class="content" action="NyuLoginExecute.action" method="get">
>>>>>>> branch 'master' of https://github.com/sena0923/Stockwakarukun.git
		<p style="font-size: 40px;">
		    名前 | <%= request.getAttribute("userName") != null ? request.getAttribute("userName") : "" %>
		</p>
		  <p style="font-size: 30px;">パスワード | ＊＊＊＊＊＊</p>
		<p style="font-size: 25px;">
		    ログインID | <%= request.getAttribute("rd_id") != null ? request.getAttribute("rd_id") : "" %>
		</p>
	   --%>

	  <div class="button-container">
	    <button onclick="location.href='./rdHome.jsp'">戻る</button>
	    <button onclick="location.href='./rdInfoChange.jsp'">変更する</button>
	  </div>

	  <style>
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

</main>
