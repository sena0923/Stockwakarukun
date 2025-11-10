<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>入居者新規登録画面</title>
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>

  <main>
    <h1>新規登録画面</h1>

    <form id="residentForm" action="入居者新規登録完了.jsp" method="post">

      <!-- コース選択 -->
      <label>コースを選んでください</label>
      <div class="radio-group column">
        <div class="radio-item">
          <input id="radio-a" type="radio" name="course" value="ziritu" checked>
          <label for="radio-a">自立コース</label>
        </div>
        <div class="radio-item">
          <input id="radio-b" type="radio" name="course" value="youkaigo">
          <label for="radio-b">要介護コース</label>
        </div>
      </div>

      <!-- 名前 -->
      <label for="name">お名前</label>
      <input type="text" id="name" name="name" required>

      <!-- フリガナ -->
      <label for="kana">お名前（フリガナ）</label>
      <input type="text" id="kana" name="kana" pattern="[\u30A0-\u30FF]+" title="カタカナのみ入力してください" required>

      <!-- 性別 -->
      <label>性別</label>
      <div class="radio-group column">
        <div class="radio-item">
          <input id="radio-c" type="radio" name="gender" value="男" checked>
          <label for="radio-c">男</label>
        </div>
        <div class="radio-item">
          <input id="radio-d" type="radio" name="gender" value="女">
          <label for="radio-d">女</label>
        </div>
        <div class="radio-item">
          <input id="radio-e" type="radio" name="gender" value="回答しない">
          <label for="radio-e">回答しない</label>
        </div>
      </div>

      <!-- ログインID -->
      <label for="login-id">ログインID</label>
      <input type="text" id="login-id" name="login-id" pattern="^[0-9]+$" required>
      <p id="id-error" class="error" style="display: none;">⚠ このログインIDはすでに使われています。</p>

      <!-- パスワード -->
      <label for="password">パスワード</label>
      <input type="password" id="password" name="password" pattern="^[0-9]+$" required>

      <!-- パスワード確認 -->
      <label for="passwordconfirm">パスワード（確認用）</label>
      <input type="password" id="passwordconfirm" name="passwordconfirm" pattern="^[0-9]+$" required>
      <p id="password-error" class="error" style="display: none;">⚠ パスワードが一致していません。</p>

      <p id="form-message" class="error" style="display: none;">⚠ サーバーに接続できませんでした。</p>

      <button class="btn2" type="submit">登録</button>
    </form>
  </main>

  <script>
    const form = document.getElementById("residentForm");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("passwordconfirm");
    const loginId = document.getElementById("login-id");
    const passwordError = document.getElementById("password-error");
    const idError = document.getElementById("id-error");
    const formMessage = document.getElementById("form-message");

    form.addEventListener("submit", async function(event) {
      passwordError.style.display = "none";
      idError.style.display = "none";
      formMessage.style.display = "none";

      if (password.value !== confirmPassword.value) {
        event.preventDefault();
        passwordError.style.display = "block";
        confirmPassword.style.border = "2px solid red";
        return;
      }

      try {
        const res = await fetch("get_registered_ids.php");
        const registeredIds = await res.json();

        if (registeredIds.includes(loginId.value)) {
          event.preventDefault();
          idError.style.display = "block";
          loginId.style.border = "2px solid red";
        }
      } catch (error) {
        event.preventDefault();
        formMessage.style.display = "block";
      }
    });
  </script>

</body>
</html>