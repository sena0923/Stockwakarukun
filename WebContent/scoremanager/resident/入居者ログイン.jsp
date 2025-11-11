<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
  <a href="入居者/入居者新規登録.jsp">新規登録</a>

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