<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ストックわかるくん</title>
    <style>
        a {text-decoration: none; /* 下線を消す */}
        body {
            text-align: center;
            font-family: sans-serif;
        }

        h1 {
            margin-bottom: 30px;
        }

        .menu {
            display: flex;
            justify-content: center;
            gap: 30px; /* ボタンの間隔 */
        }

        .menu a {
            background: #b8d200;
            color: #000000;
            border-radius: 0.25em;
            padding: 1em 2em 0.8em;
            line-height: 1;
            text-decoration: none;
            display: inline-block;
            font-weight: bold;
        }

        .menu a:hover {
            background: #a5c000; /* ホバー時の色変化 */
        }

        .back-button:hover {
            background: #999;
        }
    </style>
</head>
<body>
    <h1>ストックわかるくん(介護士用)</h1>

    <div class="menu">
        <a href="Mypage.jsp">マイページ</a>
        <a href="入居者一覧.jsp">入居者一覧</a>
    </div>
</body>
</html>
