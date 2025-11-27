<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート内容</title>
</head>
<body>

<%@ include file="../../headerEC.jsp" %>

<h2>🛒 カートの中身</h2>

<c:if test="${empty cartList}">
    <p>カートは空です</p>
</c:if>

<c:if test="${not empty cartList}">
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
            <th>操作</th>
        </tr>
        <c:forEach var="item" items="${cartList}">
            <tr>
                <td>${item.goods_name}</td>
                <td>${item.price}円</td>
                <td>
                    <!-- 数量変更フォーム -->
                    <form action="updateCart" method="post" style="display:inline;">
                        <input type="hidden" name="goods_id" value="${item.goods_id}">
                        <input type="number" name="quantity" value="${item.quantity}" min="1">
                        <input type="submit" value="変更">
                    </form>
                </td>
                <td>
                    <!-- 削除ボタン -->
                    <form action="removeCart" method="post" style="display:inline;">
                        <input type="hidden" name="goods_id" value="${item.goods_id}">
                        <input type="submit" value="削除">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>合計金額: ${totalPrice}円</p>
    <a href="checkout.jsp">購入手続きへ進む</a>
</c:if>

</body>
</html>