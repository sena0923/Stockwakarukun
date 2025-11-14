<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>入居者ログイン画面</title>
  <link rel="stylesheet" href="../../css/login.css">
</head>
<body>

  <h1>ログイン画面</h1>

  <form id="loginForm" method="post">

    <!-- ログインID -->
    <label for="login-id">ログインID</label>
    <input type="text" id="login-id" name="login-id" pattern="^[0-9]+$" required>

    <!-- パスワード -->
    <label for="password">パスワード</label>
    <input type="password" id="password" name="password" pattern="^[0-9]+$" required>

    <!-- エラーメッセージ表示 -->
    <p id="login-error" class="error-message">
      <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>

    <button class="btn2" type="submit">ログイン</button>
  </form>

  <br>
  <a href="./rdSignUp.jsp">新規登録</a>

  <script>
    const form = document.getElementById("loginForm");
    const loginId = document.getElementById("login-id");
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
      }

      // 仮の認証（本番ではサーバー側で処理）
      if (idValue === "5678" && pwValue === "9999") {
        errorDiv.style.color = "green";
        errorDiv.textContent = "ログイン成功！";
        // window.location.href = "./親族ホーム.html"; // 実際の遷移先
      } else {
        errorDiv.textContent = "ログインIDまたはパスワードが正しくありません。";
      }
    });
  </script>

</body>
</html>




<%--
<c:redirect url="rdHome.jsp">

	<c:param name="title">
		ストックわかるくん
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="NyuLoginExecute.action" method="get">
			<h1>入居者ログイン画面</h1>

			<div class="controll">
			<label for="name">ログインID</label>
			<input type="text" id="" name="rd_id" required>
			</div>

	        <p id="error-message"></p>

	        <div class="controll">
	            <label for="mypassword">パスワード</label>
	            <input id="mypassword" type="password" name="password" required>
	        </div>

	        <!-- 入力欄のすぐ下に配置 -->
	        <div class="button-group">
	            <button class=btn-primary type="submit">ログイン</button>
			</div>
		</form>

	            <a href="rdSignUp.jsp">新規登録画面へ</a>


	</c:param>
</c:redirect>







<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/login.css">
</head>
<body>

  <h1>入居者ログイン画面</h1>

  <form id="loginForm" action="親族ログインチェック.jsp" method="post">

    <!-- ログインID -->
    <label for="login-id">ログインID</label>
    <input type="text" id="login-id" name="login-id" pattern="^[0-9]+$" required>

    <!-- パスワード -->
    <label for="password">パスワード</label>
    <input type="password" id="password" name="password" pattern="^[0-9]+$" required>

    <!-- エラーメッセージ表示 -->
    <p id="login-error" class="error-message">
      <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>

    <button class="btn2" type="submit">ログイン</button>
  </form>

  <br>
  <a href="./rdSignUp.jsp">新規登録</a>

  <script>
	  document.getElementById("loginForm").addEventListener("submit", function(event) {
	      event.preventDefault(); // ページリロードを防ぐ

	      const loginId = document.getElementById("login-id").value.trim();
	      const password = document.getElementById("password").value.trim();
	      const errorDiv = document.getElementById("login-error");
	      errorDiv.textContent = ""; // 既存のエラーリセット

	      // 入力チェック
	      if (!loginId || !password) {
	        errorDiv.textContent = "ログインIDとパスワードを入力してください。";
	        return;
	      }

	      // 仮の認証（実際はサーバー通信でチェック）
	      // ID: 1234 / PW: 0000 として成功
	      if (loginId === "1234" && password === "0000") {
	        errorDiv.style.color = "green";
	        errorDiv.textContent = "ログイン成功！";
	        // 実際は次ページへ遷移する場合：
	        // window.location.href = "./入居者ホーム.html";
	      } else {
	        errorDiv.style.color = "red";
	        errorDiv.textContent = "ログインIDまたはパスワードが正しくありません。";
	      }
	    });
  </script>


</body>
</html>

--%>