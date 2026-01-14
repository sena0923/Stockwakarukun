<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>


<h2>購入内容の確認</h2>

<c:forEach var="cart" items="${sessionScope.cartList}">
    <p>${cart.goods_name} × ${cart.quantity} = ${cart.price * cart.quantity}円</p>
</c:forEach>

<form action="../ECsite/PurchaseExecute.action" method="post">
    <button type="submit">購入確定</button>
</form>

</body>
</html>