<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../../baseNyu.jsp">

    <c:param name="title">
        入居者ECストック管理画面
    </c:param>

    <c:param name="scripts">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stock_phone.css">
    </c:param>

    <c:param name="content">

        <form class="container" action="Nyu_ECstockUpdate.action" method="post">

            <a class="back-con" href="NyuMenu.action">戻る</a>

            <h1>ECサイトストック</h1>

            <div class="tab-container">
                <a class="type_list" href="Nyu_stockList.action?rd_id=${resident.rd_id}">
                    個人ストック
                </a>
                <a class="type_list non">
                    ECサイトストック
                </a>
            </div>

            <table class="table">

                <!-- ECストック一覧 -->
                <c:forEach var="stock" items="${iiList}">
                    <tr>

                        <!-- 商品名 -->
                        <td>${stock.goods.goods_name}</td>

                        <!-- 数量 -->
                        <td>
						    <div class="qty">

						        <button type="button" class="down">-</button>

						        <input type="number"
						               name="count_${stock.goods_id}"
						               value="${stock.quantity}"
						               class="qty-input"
						               min="0"
						               style="<c:if test='${stock.quantity == 0}'>color:red; font-weight:bold;</c:if>">

						    </div>
						</td>

                    </tr>
                </c:forEach>

                <!-- ECストックが0件の場合 -->
                <c:if test="${empty iiList}">
                    <tr>
                        <td colspan="3" style="text-align:center; padding:20px;">
                            ECサイトで購入されたストックはありません
                        </td>
                    </tr>
                </c:if>

            </table>

            <!-- 数量減ボタンの動作 -->
            <script>
                document.querySelectorAll('.qty').forEach(qtyDiv => {
                    const qtyDown = qtyDiv.querySelector('.down');
                    const input = qtyDiv.querySelector('.qty-input');

                    qtyDown.addEventListener('click', () => {
                        let num = parseInt(input.value);
                        if (num > 0) {
                            input.value = num - 1;
                        }
                    });
                });
            </script>

            <input type="hidden" name="rd_id" value="${resident.rd_id}">

            <button type="submit" class="update_link">更新</button>

        </form>

    </c:param>

</c:import>