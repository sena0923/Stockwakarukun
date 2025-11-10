<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>登録完了</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
        text-align: center;
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        margin-top: 250px;
    }

    h1 {
        color: #333;
        font-size: 36px;
        margin-bottom: 40px;
    }

    button {
        background-color: #4CAF50;
        color: white;
        padding: 15px 30px;
        font-size: 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #45a049;
    }
  </style>
</head>

<body>
    <h1>新規登録が完了しました</h1>
    <form action="親族/親族ログイン.jsp" method="get">
        <button type="submit">ログイン画面へ</button>
    </form>
</body>
</html>