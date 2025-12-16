<%-- 親族ログイン画面 --%>
<%-- ログインJSP --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>親族ログイン画面</title>
  <link rel="stylesheet" href="../../css/loginMo.css">
</head>
<body>

  <form class="content" action="SinLoginExecute.action" method="get">

	<h1>親族ログイン画面</h1>

			<!-- ログインID -->
			<label for="RT_ID">ログインID</label>
			<input type="text" id="rt_id" name="rt_id" pattern="^[0-9]+$" required>

			<!-- パスワード -->
			<label for="password">パスワード</label>
			<input type="password" id="password" name="password" pattern="^[0-9]+$" required>

			<!-- エラーメッセージ表示 -->
			<p id="login-error" class="error-message">
				<%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
			</p>

		<script>
			const form = document.getElementById("loginForm");
			const rd_id = document.getElementById("rt_id");
			const password = document.getElementById("password");
			const errorDiv = document.getElementById("login-error");

			form.addEventListener("submit", function(event) {
				event.preventDefault();
				errorDiv.textContent = "";
				errorDiv.style.color = "red";

				const idValue = loginId.value.trim();
				const pwValue = password.value.trim();

				if (!idValue || !pwValue) {
					errorDiv.textContent = "ログインIDとパスワードを入力してください。";
					return;
				}else {
					errorDiv.textContent = "ログインIDまたはパスワードが正しくありません。";
				}
			});
		</script>



	        <!-- 入力欄のすぐ下に配置 -->

				<button class="btn2" type="submit">ログイン</button>
				<br><br>
				<a href="./rtSignUp.jsp">新規登録</a>

		</form>
</body>
</html>
