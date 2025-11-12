<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品更新画面</title>
<style>
  body {
    font-family: sans-serif;
    background-color: #f5f5f5;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
  }

  .container {
    background: #fff;
    padding: 40px 50px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    width: 400px;
  }

  h2 {
    text-align: center;
    margin-bottom: 25px;
  }

  .form-group {
    margin-bottom: 15px;
  }

  label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
  }

  input[type="text"],
  input[type="number"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
  }

  button {
    width: 100%;
    padding: 10px;
    border: 1px solid #999;
    background-color: #fff;
    border-radius: 5px;
    font-weight: bold;
    cursor: pointer;
    transition: background 0.2s;
  }

  button:hover {
    background-color: #f2f2f2;
  }

  #generalError {
    color: red;
    text-align: center;
    font-weight: bold;
    margin-bottom: 15px;
  }
</style>
</head>
<body>
  <div class="container">
    <h2>商品更新画面</h2>

    <form id="productForm" action="在庫登録完了.jsp" method="post" onsubmit="return checkForm();">
      <div id="generalError"></div>

      <div class="form-group">
        <label for="name">商品名</label>
        <input type="text" id="name" name="name">
      </div>

      <div class="form-group">
        <label for="stock">在庫数</label>
        <input type="number" id="stock" name="stock" min="0">
      </div>

      <button type="submit">更新する</button>
    </form>
  </div>

  <script>
    function checkForm() {
      const name = document.getElementById("name").value.trim();
      const stock = document.getElementById("stock").value.trim();
      const errorDiv = document.getElementById("generalError");

      if (name === "" || stock === "") {
        errorDiv.textContent = "未入力の項目があります";
        return false;
      }

      errorDiv.textContent = ""; // エラーを消す
      return true;
    }
  </script>
</body>
</html>
