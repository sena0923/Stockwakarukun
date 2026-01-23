<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴</title>
<style>
    .purchase-block {
        border: 1px solid #ccc;
        padding: 15px;
        margin-bottom: 20px;
        background: #fafafa;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 8px;
        text-align: left;
    }
    th {
        background: #eee;
    }
</style>
</head>
<body>

<h2>購入履歴</h2>

<c:if test="${empty purchaseList}">
    <p>購入履歴はありません。</p>
</c:if>

<c:forEach var="p" items="${purchaseList}">
    <div class="purchase-block">

        <p><strong>購入日：</strong> ${p.purchaseDate}</p>

        <table>
            <tr>
                <th>商品名</th>
                <th>数量</th>
                <th>価格</th>
            </tr>

            <c:forEach var="d" items="${p.details}">
                <tr>
                    <td>${d.itemName}</td>
                    <td>${d.quantity}</td>
                    <td>${d.price}</td>
                </tr>
            </c:forEach>

        </table>

    </div>
</c:forEach>

</body>
</html>