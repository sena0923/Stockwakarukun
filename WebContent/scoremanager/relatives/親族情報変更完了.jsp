<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>更新完了</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 70vh;
      margin: 0;
      font-family: "Segoe UI", sans-serif;
      background-color: #f5f5f5;
      padding: 20px;
      box-sizing: border-box;
      text-align: center;
    }

    h1 {
      color: #333;
      margin-bottom: 30px;
      font-size: 24px;
    }

    button {
      padding: 14px 30px;
      font-size: 18px;
      font-weight: bold;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      color: #fff;
      background-color: #4CAF50;
      transition: background-color 0.3s, transform 0.2s;
      width: 100%;
      max-width: 300px;
    }

    button:hover {
      background-color: #45a049;
      transform: translateY(-2px);
    }

    @media (max-width: 400px) {
      h1 {
        font-size: 20px;
      }
      button {
        font-size: 16px;
        padding: 12px 20px;
      }
    }
  </style>
</head>
<body>
  <h1>更新が完了しました</h1>
  <button onclick="location.href='./親族ホーム.jsp'">ホームページへ</button>
</body>
</html>