<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>入居者情報変更画面</title>
    <style>
        body {
            min-height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
            font-family: "Hiragino Sans", "Meiryo", sans-serif;

            display: flex;
            flex-direction: column; /* タイトルは上、フォームは中央へ */
            align-items: center;
        }

        /* タイトルは画面上部に固定 */
        h1 {
            font-size: 2rem;
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
            position: sticky;
            top: 0;
            background-color: #f5f5f5;
            padding: 15px 0;
            width: 100%;
        }

        /* フォームを中央寄せ */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;

            width: 100%;
            max-width: 350px;
            margin-top: 30px;
        }

        h2 {
            font-size: 1.1rem;
            margin: 10px 0 5px 0;
            width: 100%;
        }

        label {
            width: 100%;
            margin-bottom: 5px;
            display: block;
        }

        input {
            height: 45px;
            width: 100%;
            font-size: 1rem;
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        .btn2 {
            margin-top: 25px;
            height: 50px;
            width: 100%;
            font-size: 1.1rem;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn2:hover {
            background-color: #45a049;
        }

        /* スマホ調整 */
        @media screen and (max-width: 480px) {
            h1 {
                font-size: 1.6rem;
                padding: 10px 0;
            }
            input, .btn2 {
                width: 90vw;
            }
        }
    </style>
</head>

<body>

    <h1>ユーザー情報変更画面</h1>

    <form method="post" action="NyuChangeExecute.action" onsubmit="return validateForm();">
         <label>コースを選んでください</label>
      <div class="radio-group column">
        <div class="radio-item">
          <input id="radio-a" type="radio" name="course" value="1" checked>
          <label for="radio-a">自立コース</label>
        </div>
        <div class="radio-item">
          <input id="radio-b" type="radio" name="course" value="2">
          <label for="radio-b">要介護コース</label>
        </div>
      </div>

        <h2>パスワード</h2>
        <input type="password" id="password" name="password" pattern="^[0-9]+$" required>

        <h2>パスワード(確認用)</h2>
        <input type="password" id="passwordConfirm" name="passwordConfirm" pattern="^[0-9]+$" required placeholder="もう一度入力">

        <p id="passwordError" style="color: red; display: none;"></p>

        <button class="btn2" type="submit">完了</button>
    </form>

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

</body>
</html>
