<%-- 介護士新規登録画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		介護士新規登録
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="KaiCreateExecute.action" method="get">
			<h1>介護士新規登録</h1>
			<div class="controll">
            <label for="facility_pw">施設パスワード <span class="required">必須</span></label>
            <input type="text" id="facility_id" name="facility_id" required>
        </div>

        <div class="controll">
            <label for="name">氏名 <span class="required">必須</span></label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="controll">
            <label for="id">職員番号 <span class="required">必須</span></label>
            <input type="text" id="id" name="id" required>
        </div>

        <div class="controll">
            <label for="pw">パスワード <span class="required">必須</span></label>
            <input type="text" id="pw" name="pw" required>
        </div>

        <div class="controll">
            <label for="pw_2">確認用パスワード <span class="required">必須</span></label>
            <input type="text" id="pw_2" name="pw_2" required>
        </div>


		<c:if test="${not empty errors}">
			<ul style="color:red;">
				<c:forEach var="err" items="${errors}">
					<li>${err.value}</li>
				</c:forEach>
			</ul>
		</c:if>


        <div class="controll">
            <button class="btn" type="submit">新規登録</button>
        </div>
    </form>
	</c:param>
</c:import>





<%--
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>介護士新規登録画面</title>
    <link rel="stylesheet" href="介護.css">
    <style>
        body {
            font-family: sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        form {
            background: #fff;
            padding: 40px 50px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            width: 400px;
        }

        h2 {
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

        .required {
            color: red;
            font-size: 12px;
        }

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
            display: block;
            width: 100%;
            text-align: center;
            transition: background 0.2s, border-color 0.2s;
        }

        .btn:hover {
            background: #f2f2f2;
            border-color: #888;
        }

        #error-message {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <form action="home.jsp" method="get" onsubmit="return validateForm();">
        <h2>介護士新規登録</h2>

        <div class="controll">
            <label for="facility">施設パスワード <span class="required">必須</span></label>
            <input type="text" id="facility" name="facility" required>
        </div>

        <div class="controll">
            <label for="fullname">氏名 <span class="required">必須</span></label>
            <input type="text" id="fullname" name="fullname" required>
        </div>

        <div class="controll">
            <label for="staffnum">職員番号 <span class="required">必須</span></label>
            <input type="text" id="staffnum" name="staffnum" required>
        </div>

        <div class="controll">
            <label for="password">パスワード <span class="required">必須</span></label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="controll">
            <label for="confirm">確認用パスワード <span class="required">必須</span></label>
            <input type="password" id="confirm" name="confirm" required>
        </div>

        <p id="error-message"></p>

        <div class="controll">
            <button class="btn" type="submit">新規登録</button>
        </div>
    </form>

    <script>
        function validateForm() {
            const password = document.getElementById("password").value;
            const confirm = document.getElementById("confirm").value;
            const staffnum = document.getElementById("staffnum").value;
            const errorMessage = document.getElementById("error-message");

            const registeredStaffNumbers = ["A001", "B123", "C999"];

            if (registeredStaffNumbers.includes(staffnum)) {
                errorMessage.textContent = "同じ職員番号が存在しています";
                return false;
            }

            if (password !== confirm) {
                errorMessage.textContent = "パスワードが一致していません";
                return false;
            }

            errorMessage.textContent = "";
            return true;
        }
    </script>
</body>
</html>

--%>