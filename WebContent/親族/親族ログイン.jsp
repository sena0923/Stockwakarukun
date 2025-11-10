<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>親族ログイン画面</title>
  <link rel="stylesheet" href="css/login.css">
</head>
<body>

  <h1>ログイン画面</h1>

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
  <a href="親族/親族新規登録.jsp">新規登録</a>

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