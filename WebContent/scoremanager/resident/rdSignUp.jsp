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
            display: flex;
            flex-direction: column;
            background-color: #f5f5f5;
            margin: 0;
            font-family: "Hiragino Sans", "Meiryo", sans-serif;
        }

        /* タイトルを上部に固定して中央に揃える */
        h1 {
            font-size: 2rem;
            text-align: center;
            margin-top: 40px;
            margin-bottom: 30px;
        }

        /* フォーム全体を中央に配置するためのコンテナ */
        .form-wrapper {
            flex: 1;                        /* 余白を全て受け取って中央に配置 */
            display: flex;
            flex-direction: column;
            justify-content: center;        /* 縦方向中央 */
            align-items: center;            /* 横方向中央 */
            width: 100%;
        }

        h2 {
            font-size: 1.1rem;
            margin: 10px 0 5px 0;
        }

        input {
            height: 45px;
            width: 80vw;
            max-width: 300px;
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

        @media screen and (max-width: 480px) {
            h1 {
                font-size: 1.6rem;
                margin-top: 25px;
                margin-bottom: 20px;
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

    <div class="form-wrapper">
        <form method="post" action="./rdInfoChangeComplete.jsp" onsubmit="return validateForm();">

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

            <h2>パスワード</h2>
            <input type="password" id="password" name="password" pattern="^[0-9]+$" required>

            <h2>パスワード(確認用)</h2>
            <input type="password" id="passwordConfirm" name="passwordConfirm" pattern="^[0-9]+$" required placeholder="もう一度入力">

            <p id="passwordError" style="color: red; display: none;"></p>

            <button class="btn2" type="submit">完了</button>

        </form>
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

</body>
</html>
