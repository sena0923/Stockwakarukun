<%-- 介護士アカウント更新入力画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseNyu.jsp">
	<c:param name="title">
		入居者アカウント変更画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create_phone.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="NyuChangeExecute.action" method="get" onsubmit="return checkPasswords();">
		<a class="back-con" href="NyuChange.action">戻る</a>

			<h1>アカウント変更</h1>

			<label>①コースを選んでください</label>


				<div class="radio-group column">
					<div class="radio-item">
						<label class="co" for="radio-a">自立コース</label>
						<input id="radio-a" type="radio" name="course" value="1" checked>
					</div>

					<div class="radio-item">
						<label class="co" for="radio-b">要介護コース</label>
						<input id="radio-b" type="radio" name="course" value="2">
					</div>

				</div>

				<br>

        <label>②パスワード</label>
        <input type="password" id="password" name="password"  required>

        <label>③パスワード(確認用)</label>
        <input type="password" id="passwordConfirm" name="passwordConfirm" required placeholder="もう一度入力">

		<c:if test="${not empty errors}">
			<ul style="color:red;">
				<c:forEach var="err" items="${errors}">
					<li>${err.value}</li>
				</c:forEach>
			</ul>
		</c:if>

        <p id="passwordError" style="color: red; display: none;"></p>

		<div class="select">
            <button class="btn" type="submit">変更</button>
		</div>

    <script>
    function validateForm() {
        const pw1 = document.getElementById('password').value;
        const pw2 = document.getElementById('passwordConfirm').value;
        const passwordError = document.getElementById('passwordError');

        if (pw1 === "" || pw2 === "") {
            passwordError.style.display = "block";
            passwordError.textContent = "両方の欄に入力してください。";
            return false;
        }

        if (pw1 !== pw2) {
            passwordError.style.display = "block";
            passwordError.textContent = "パスワードが一致しません。";
            return false;
        }

        passwordError.style.display = "none";
        return true;
    }
    </script>




		</form>
	</c:param>
</c:import>

