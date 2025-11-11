<%-- 介護士ログイン画面 --%>
<%-- ログインJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../base.jsp">
	<c:param name="title">
		ストックわかるくん
	</c:param>


</c:import>


<%--
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>介護士ログイン画面</title>
    <link rel="stylesheet">
    <style>
        body {
            font-family: sans-serif;
            text-align: center;
            background-color: #f9f9f9;
            margin: 0;
            padding: 40px;
        }

        .content {
            background: #fff;
            padding: 40px 50px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            display: inline-block;
            text-align: left;
        }

        h1 {
            text-align: center;
            margin-bottom: 25px;
        }

        .controll {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        /* シンプルボタンデザイン */
        .btn {
            background: #fff;
            color: #333;
            border: 1px solid #aaa;
            border-radius: 5px;
            padding: 10px 25px;
            font-size: 16px;
            cursor: pointer;
            font-weight: bold;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            transition: background 0.2s, border-color 0.2s;
        }

        .btn:hover {
            background: #f2f2f2;
            border-color: #888;
        }

        /* ボタンを横並びに */
        .button-group {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-top: 25px;
        }

        #error-message {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <form class="content" onsubmit="return checkFacilityPassword();" action="home.html" method="get">
        <h1>介護士ログイン</h1>

        <div class="controll">
            <label for="name">氏名</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="controll">
            <label for="staffnum">職員番号</label>
            <input type="text" id="staffnum" name="staffnum" required>
        </div>

        <div class="controll">
            <label for="facility">施設パスワード</label>
            <input type="password" id="facility" name="facility" required>
        </div>

        <p id="error-message"></p>

        <div class="controll">
            <label for="mypassword">パスワード</label>
            <input id="mypassword" type="password" name="password" required>
        </div>

        <!-- 入力欄のすぐ下に配置 -->
        <div class="button-group">
            <button class="btn" type="submit">ログイン</button>
            <a href="介護士新規登録.jsp" class="btn">新規登録画面へ</a>
        </div>
    </form>

    <script>
        function checkFacilityPassword() {
            const inputPassword = document.getElementById("facility").value;
            const errorMessage = document.getElementById("error-message");

            const registeredPassword = "kaigo123";

            if (inputPassword !== registeredPassword) {
                errorMessage.textContent = "施設パスワードが一致していません";
                return false;
            }

            errorMessage.textContent = "";
            return true;
        }
    </script>
</body>
</html>

--%>
