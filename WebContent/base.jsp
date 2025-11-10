<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="CSS/base.css">
  <title>ストックわかる君</title>
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
      <a href="#">ユーザー情報表示</a>
      <a href="#">ログアウト</a>
    </nav>
  </header>

  <script>
	  document.addEventListener("DOMContentLoaded", () => {
	      const hamburger = document.getElementById('hamburger');
	      const nav = document.getElementById('nav');

	      hamburger.addEventListener('click', () => {
	        nav.classList.toggle('active');
	        hamburger.classList.toggle('open');
	      });
	  });

  </script>

</body>
</html>