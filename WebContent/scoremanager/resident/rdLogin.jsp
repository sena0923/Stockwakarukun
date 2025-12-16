<%-- 入居者ログイン画面 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>入居者ログイン画面</title>
  <link rel="stylesheet" href="../../css/loginMo.css">
</head>
<body>


<form class="content" action="NyuLoginExecute.action" method="get" style="margin-top: 0;">

	<h1>入居者ログイン画面</h1>


    <!-- ログインID -->
    <label for="RD_ID">ログインID</label>
    <input type="text" id="rd_id" name="rd_id" pattern="^[0-9]+$" required>

    <!-- パスワード -->
    <label for="password">パスワード</label>
    <input type="password" id="password" name="password" pattern="^[0-9]+$" required>

    <!-- エラーメッセージ表示 -->
    <p id="login-error" class="error-message">
      <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>

    <button class="btn2" type="submit">ログイン</button>
    <br><br>
  	<a href="./rdSignUp.jsp">新規登録</a>

  </form>


  <script>
    const form = document.getElementById("loginForm");
    const rd_id = document.getElementById("rd_id");
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
      } else {
        errorDiv.textContent = "ログインIDまたはパスワードが正しくありません。";
      }
    });
  </script>

</body>
</html>
