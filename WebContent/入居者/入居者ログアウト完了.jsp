<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ログアウト完了画面</title>

  <style>
    body {
      height: 80vh;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      margin: 0;
      background-color: #f7f7f7;
      font-family: "Hiragino Sans", "Meiryo", sans-serif;
      text-align: center;
    }

    h1 {
      font-size: 4rem;
      color: #333;
      margin-bottom: 50px;
    }

    a {
      font-size: 2rem;
      color: white;
      background-color: #4CAF50;
      text-decoration: none;
      padding: 15px 40px;
      border-radius: 10px;
      transition: background-color 0.3s;
    }

    a:hover {
      background-color: #45a049;
    }

    @media screen and (max-width: 600px) {
      h1 {
        font-size: 2rem;
      }
      a {
        font-size: 1.2rem;
        padding: 12px 25px;
      }
    }
  </style>
</head>

<body>
  <h1>ログアウトしました</h1>
  <a href="入居者/入居者ログイン.jsp">ログイン画面へ</a>
</body>
</html>