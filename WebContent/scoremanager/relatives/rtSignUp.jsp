<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <title>親族新規登録画面</title>
  <link rel="stylesheet" href="../../css/style.css">
</head>
<body>



  <h1>新規登録画面</h1>

  <form id="infoForm" action="SinCreateExecute.action" method="post">
    <!-- ログインID -->
    <label for="rt_id">ログインID</label>
	<input type="text" id="rt_id" name="rt_id" value="${rt_id}" pattern="^[0-9]+$" required placeholder="携帯番号を入力。「-」入力不可">
	<span class="error">${errors.rt_id}</span>

    <!-- 入居者ID -->
    <label for="rd_id">対応する入居者のログインID</label>
	<input type="text" id="rd_id" name="rd_id" value="${rd_id}" pattern="^[0-9]+$" required placeholder="入居者の携帯番号を入力。「-」入力不可">
	<span class="error">${errors.rd_id}</span>

    <!-- 名前 -->
    <label for="name">お名前</label>
    <input type="text" id="name" name="name" value="${name}" required>


    <!-- メールアドレス -->
	<label for="e_mail">メールアドレス</label>
	<input type="email" id="e_mail" name="e_mail" value="${e_mail}" required>


    <!-- パスワード -->
    <label for="password">パスワード</label>
	<input type="password" id="password" name="password" required>



    <label for="password-confirm">パスワード（確認用）</label>
    <input type="password" id="password-confirm" name="password-confirm" required>

    <p id="error-msg" class="error" style="display: none;">⚠ パスワードが一致していません。</p>

	<br><br>
    <button class="btn2" type="submit">登録</button>

	<a href="SinLogin.action" class="center-link">ログイン画面</a>

    <style>
    .error {
	  color: red;
	}

    </style>
  </form>

  <script>
    const form = document.getElementById("infoForm");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("password-confirm");
    const errorMsg = document.getElementById("error-msg");

    form.addEventListener("submit", function(event) {
      if (password.value !== confirmPassword.value) {
        event.preventDefault();
        errorMsg.style.display = "block";
        confirmPassword.style.border = "2px solid red";
      } else {
        errorMsg.style.display = "none";
        confirmPassword.style.border = "1px solid #ccc";
      }
    });
  </script>

</body>
</html>