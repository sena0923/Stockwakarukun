<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

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
  input[type="number"],
  input[type="file"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
  }

  input[type="file"] {
    padding: 5px;
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

  #preview {
    display: block;
    width: 100%;
    max-height: 200px;
    object-fit: cover;
    margin-top: 10px;
    border-radius: 8px;
  }

  /* 🔻全体のエラーメッセージ表示用 */
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
    <!-- 🔻 onsubmitにチェック関数を追加 -->
    <form id="productForm" action="product_list.html" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">

      <div class="form-group">
        <label for="image">商品画像</label>
        <input type="file" id="image" name="image" accept="image/*" onchange="previewImage(event)">
        <img id="preview" alt="プレビュー画像" style="display:none;">
      </div>

      <div class="form-group">
        <label for="name">商品名</label>
        <input type="text" id="name" name="name">
      </div>

      <div class="form-group">
        <label for="price">値段（円）</label>
        <input type="number" id="price" name="price" min="0">
      </div>

      <div class="form-group">
        <label for="price">在庫数</label>
        <input type="number" id="price" name="price" min="0">
      </div>

      <!-- 🔻ここに全体エラーメッセージ領域 -->
      <div id="generalError"></div>

      <button type="submit">登録する</button>
    </form>
  </div>

  <script>
    // 画像プレビュー処理
    function previewImage(event) {
      const reader = new FileReader();
      reader.onload = function() {
        const preview = document.getElementById('preview');
        preview.src = reader.result;
        preview.style.display = 'block';
      };
      reader.readAsDataURL(event.target.files[0]);
    }

    // 🔻未入力チェック
    function checkForm() {
      const image = document.getElementById("image").files.length;
      const name = document.getElementById("name").value.trim();
      const price = document.getElementById("price").value.trim();
      const generalError = document.getElementById("generalError");

      // 既存メッセージをリセット
      generalError.textContent = "";

      let hasError = false;

      if (image === 0 || name === "" || price === "") {
        hasError = true;
      }

      if (hasError) {
        generalError.textContent = "未入力の項目があります。";
        return false; // 送信中止
      }

      return true; // 送信OK
    }
  </script>
</body>
</html>
