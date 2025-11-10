<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品更新画面</title>
<style>
  * {
    box-sizing: border-box;
  }

  body {
    font-family: "游ゴシック体", "Yu Gothic", sans-serif;
    background-color: #f5f5f5;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0;
    padding: 100px 15px 20px; /* ヘッダーの高さ分の余白を確保 */
    min-height: 100vh;
  }

  /* ===== ヘッダー ===== */
  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    background-color: #333;
    color: #fff;
    width: 100%;
    position: fixed; /* ← 上に固定 */
    top: 0;
    left: 0;
    z-index: 10;
  }

  header h1 {
    font-size: 1.5rem;
  }

  /* ===== ハンバーガー ===== */
  .hamburger {
    width: 30px;
    cursor: pointer;
  }

  .hamburger span {
    display: block;
    height: 3px;
    background-color: white;
    margin: 6px 0;
    transition: 0.3s;
  }

  .hamburger.open span:nth-child(1) {
    transform: rotate(45deg) translateY(8px);
  }
  .hamburger.open span:nth-child(2) {
    opacity: 0;
  }
  .hamburger.open span:nth-child(3) {
    transform: rotate(-45deg) translateY(-8px);
  }

  /* ===== ナビゲーション ===== */
  nav {
    display: none;
    flex-direction: column;
    background-color: #444;
    position: absolute;
    top: 60px;
    right: 0;
    width: 180px;
    border-radius: 0 0 0 10px;
  }

  nav.active {
    display: flex;
  }

  nav a {
    color: white;
    padding: 12px;
    text-decoration: none;
    border-bottom: 1px solid #555;
  }

  nav a:hover {
    background-color: #555;
  }

  /* ===== メインコンテンツ ===== */
  .container {
    background: #fff;
    padding: 35px 25px;
    border-radius: 15px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    width: 100%;
    max-width: 420px;
  }

  h2 {
    text-align: center;
    margin-bottom: 25px;
    font-size: 1.6rem;
    color: #333;
  }

  .form-group {
    margin-bottom: 25px;
  }

  label {
    display: block;
    font-weight: bold;
    margin-bottom: 8px;
    font-size: 1.2rem;
    color: #222;
  }

  input[type="text"],
  input[type="number"] {
    width: 100%;
    padding: 14px;
    border: 2px solid #aaa;
    border-radius: 8px;
    font-size: 1.2rem;
  }

  input:focus {
    outline: none;
    border-color: #7ba800;
  }

  button {
    width: 100%;
    padding: 16px;
    border: none;
    background-color: #b8d200;
    color: #000;
    border-radius: 8px;
    font-weight: bold;
    font-size: 1.3rem;
    cursor: pointer;
    transition: background 0.2s;
  }

  button:hover {
    background-color: #a5bf00;
  }

  #generalError {
    color: red;
    text-align: center;
    font-weight: bold;
    margin-bottom: 20px;
    font-size: 1.1rem;
  }

  @media (max-width: 480px) {
    body {
      padding-top: 80px;
    }

    .container {
      padding: 25px 15px;
    }

    h2 {
      font-size: 1.4rem;
    }

    label,
    input,
    button {
      font-size: 1.1rem;
    }
  }
</style>
</head>
<body>
  <header>
    <h1>ストックわかる君</h1>
    <div class="hamburger" id="hamburger">
      <span></span>
      <span></span>
      <span></span>
    </div>
    <nav id="nav">
      <a href="#">備品管理</a>
      <a href="#">購入</a>
      <a href="#">連絡帳</a>
      <a href="#">終活のすゝめ</a>
      <a href="#">アルバム</a>
      <a href="#">プロフィール</a>
      <a href="#">ユーザー情報表示</a>
      <a href="#">ログアウト</a>
    </nav>
  </header>

  <div class="container">
    <h2>商品更新画面</h2>
    <form id="productForm" action="在庫登録完了.html" method="post" onsubmit="return checkForm();">
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
    // フォームチェック
    function checkForm() {
      const name = document.getElementById("name").value.trim();
      const stock = document.getElementById("stock").value.trim();
      const errorDiv = document.getElementById("generalError");

      if (name === "" || stock === "") {
        errorDiv.textContent = "未入力の項目があります";
        return false;
      }

      errorDiv.textContent = "";
      return true;
    }

    // ハンバーガーメニュー制御
    const hamburger = document.getElementById("hamburger");
    const nav = document.getElementById("nav");

    hamburger.addEventListener("click", () => {
      hamburger.classList.toggle("open");
      nav.classList.toggle("active");
    });
  </script>
</body>
</html>
