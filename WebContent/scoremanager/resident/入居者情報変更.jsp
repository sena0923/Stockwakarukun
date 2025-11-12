<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>入居者情報変更画面</title>
    <style>
        body {
            height: 80vh;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            background-color: #f5f5f5;
            margin: 0;
            font-family: "Hiragino Sans", "Meiryo", sans-serif;
        }

        h1 {
            font-size: 2rem;
            margin-bottom: 40px;
            text-align: center;
        }

        h2 {
            font-size: 1.1rem;
            margin: 10px 0 5px 0;
        }

        input {
            height: 45px;
            width: 80vw;               /* 画面幅の80% */
            max-width: 300px;          /* 最大幅を設定 */
            font-size: 1rem;
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        .btn2 {
            margin-top: 30px;
            height: 50px;
            width: 80vw;
            max-width: 300px;
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

        /* 小さいスマホ向けに文字や余白を少し調整 */
        @media screen and (max-width: 480px) {
            h1 {
                font-size: 1.6rem;
                margin-bottom: 25px;
            }
            h2 {
                font-size: 1rem;
            }
            input, .btn2 {
                width: 90vw;
            }
        }
    </style>
</head>

<body>

    <h1>ユーザー情報変更画面</h1>

    <form method="post" action="./入居者情報変更完了.jsp" onsubmit="return validateForm();">
        <h2>メールアドレス</h2>
        <input type="email" id="email" name="email" placeholder="example@example.com" required>

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