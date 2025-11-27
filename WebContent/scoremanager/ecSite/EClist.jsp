<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>EC商品一覧</title>
</head>
<body>

<%@ include file="../../headerEC.jsp" %>

<div class="ec-page">

    <!-- メッセージ表示 -->
    <c:if test="${param.msg == 'added'}">
        <p style="color: green;">カートに追加されました</p>
    </c:if>

    <ul>
        <c:forEach var="goods" items="${goodsList}">
            <li>
                商品名：${goods.goods_name}　
                価格：${goods.price}円　
                在庫：${goods.stock}
                <a href="cartExecute?goods_id=${goods.goods_id}">
                   カートに入れる
                </a>
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>