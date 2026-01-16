<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>購入完了画面</title>

<style>
body {
    text-align: center;
}

.back-button {
    font-size: 20px;
    padding: 15px 40px;
    background-color: #4CAF50; /* 緑色 */
    color: white;
    border: none;
    border-radius: 10px;      /* 角を丸く */
    cursor: pointer;
}

.back-button:hover {
    opacity: 0.8;
}
</style>

</head>
<body>

<h2>ご購入ありがとうございました</h2>

<form action="AllExecute.action">
    <input type="submit" value="戻る" class="back-button">
</form>

</body>
</html>
