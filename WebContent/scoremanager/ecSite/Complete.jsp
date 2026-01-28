<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購入完了</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/complete.css">

    <style>
        body {
            font-family: "Yu Gothic", sans-serif;
            background: linear-gradient(135deg, #f0f8ff, #e6f7ff);
            text-align: center;
            padding: 40px 20px;
        }

        .complete-box {
            background: #fff;
            padding: 40px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            display: inline-block;
            animation: fadeIn 0.8s ease;
        }

        h2 {
            color: #2b7de9;
            font-size: 28px;
            margin-bottom: 15px;
        }

        p {
            font-size: 18px;
            margin-bottom: 30px;
        }

        /* 戻るボタン（中央下） */
        .back-area {
            margin-top: 40px;
        }

        .back-link {
            padding: 12px 28px;
            background: #4a90e2;
            color: #fff;
            text-decoration: none;
            border-radius: 30px;
            font-size: 16px;
            font-weight: bold;
            transition: 0.25s;
            box-shadow: 0 3px 8px rgba(0,0,0,0.15);
        }

        .back-link:hover {
            background: #357ab8;
            transform: translateY(-2px);
        }

        /* ふわっと表示アニメーション */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to   { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>

<body>

<div class="complete-box">
    <h2>購入が完了しました</h2>
    <p>ご利用ありがとうございました。</p>

    <div class="back-area">
        <c:choose>
            <c:when test="${not empty resident}">
                <a class="back-link" href="../../scoremanager/ECsite/AllExecute.action">購入画面へ戻る</a>
            </c:when>

            <c:when test="${not empty selectedResident}">
                <a class="back-link" href="../../scoremanager/ECsite/AllsinExecute.action">購入画面へ戻る</a>
            </c:when>

            <c:when test="${not empty relatives}">
                <a class="back-link" href="../../scoremanager/ECsite/AllsinExecute.action">購入画面へ戻る</a>
            </c:when>
        </c:choose>
    </div>
</div>

</body>
</html>