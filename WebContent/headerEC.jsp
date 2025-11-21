<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ストックかえる君</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .site-header {
            border-bottom: 1px solid #ddd;
            background: #22224f;
        }

        .header-top {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
        }

        .logo a {
            font-size: 24px;
            font-weight: bold;
            text-decoration: none;
            color: #ffffff;
        }

        .user-actions a {
            margin-left: 15px;
            text-decoration: none;
            color: #ffffff;
        }

        .main-nav {
            background: #f8f8f8;
            padding: 10px 20px;
        }

        .main-nav ul {
            display: flex;
            flex-wrap: wrap;   /* ✅ スマホで折り返し可能に */
            gap: 20px;
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .main-nav a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        /* 📱 スマホ対応 */
        @media (max-width: 768px) {
            .header-top {
                flex-direction: column;
                align-items: flex-start;
            }
            .user-actions {
                margin-top: 10px;
            }
            .main-nav ul {
                flex-direction: column; /* ✅ 縦並びに変更 */
                gap: 10px;
            }
        }
    </style>
</head>
<body>
<header class="site-header">
    <div class="header-top">
        <div class="logo">
            <a href="index.jsp">ストックかえる君</a>
        </div>
        <div class="user-actions">
            <a href="cart.jsp">カート</a>
        </div>
    </div>
    <nav class="main-nav">
        <ul>
            <li><a href="#">すべて</a></li>
            <li><a href="#">洗面用具</a></li>
            <li><a href="#">タオル類</a></li>
            <li><a href="#">衣類</a></li>
            <li><a href="#">防寒用具</a></li>
            <li><a href="#">備品・日用品</a></li>
            <li><a href="#">娯楽</a></li>
        </ul>
    </nav>
</header>
</body>
</html>