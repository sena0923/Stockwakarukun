<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購入履歴</title>

    <style>
    	.header-area {
		    display: flex;
		    justify-content: center;      /* 中央寄せ */
		    align-items: center;
		    position: relative;           /* 戻るボタンを右に固定するため */
		    margin-bottom: 20px;
		}

		.header-area .back-btn {
		    position: absolute;
		    right: 0;                     /* 右端に配置 */
		    padding: 8px 16px;
		    background: #4a90e2;
		    color: #fff;
		    text-decoration: none;
		    border-radius: 6px;
		    font-weight: bold;
		    transition: 0.2s;
		}

		.header-area .back-btn:hover {
		    background: #357ab8;
		}

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
		.back-btn {
		    padding: 6px 14px;
		    border: 1px solid #666;
		    border-radius: 4px;
		    color: #333;
		    text-decoration: none;
		    transition: 0.2s;
		}
		.back-btn:hover {
		    background: #f0f0f0;
		}

    </style>
</head>

<body>

<div class="header-area">
    <h1>購入履歴</h1>
    <a class="back-btn" href="javascript:history.back();"> 戻る</a>
</div>

<c:if test="${empty purchaseList}">
    <p>購入履歴はありません。</p>
    <button class="back-btn" onclick="history.back();"> 戻る</button>
</c:if>

<c:forEach var="p" items="${purchaseList}">
    <div class="purchase-block">

        <p><strong>購入日：</strong> ${p.purchaseDate}</p>

        <table>
            <tr>
                <th>商品名</th>
                <th>数量</th>
                <th>価格</th>
                <th></th>
            </tr>

            <c:forEach var="d" items="${p.details}">
                <tr>
                    <td>${d.itemName}</td>
                    <td>${d.quantity}</td>
                    <td>${d.price}</td>

                    <td>
                        <form action="${pageContext.request.contextPath}/scoremanager/ECsite/AddCartExecute.action" method="post">
                            <input type="hidden" name="goods_id" value="${d.goodsId}">
                            <input type="hidden" name="quantity" value="${d.quantity}">
                            <input type="hidden" name="price" value="${d.price}">
                            <input type="submit" value="カートに入れる">
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</c:forEach>

</body>
</html>