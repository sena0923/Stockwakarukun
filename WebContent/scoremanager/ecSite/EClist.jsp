<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>EC商品一覧</title>

<style>
/* ページ全体 */
.ec-page {
    display: flex;
    flex-direction: column;
    align-items: center;
}

/* 通知メッセージ */
#popupMessage {
    position: fixed;
    top: 20px;
    right: 20px;
    background: #4CAF50;
    color: white;
    padding: 12px 20px;
    border-radius: 6px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.2);
    display: none;
    z-index: 9999;
}

ul {
    list-style: none;
    padding: 0;
}

li {
    margin: 15px 0;
    padding: 10px;
    border: 1px solid #ccc;
    width: 400px;
    display: flex;
    align-items: center;
    gap: 10px;
}
</style>

</head>
<body>

<%@ include file="../../headerEC.jsp" %>

<div id="popupMessage">カートに追加されました</div>

<div class="ec-page">
<ul>
    <c:if test="${not empty goodsList}">
        <c:forEach var="goods" items="${goodsList}">
            <li>
                <!-- DBの GOODS_IMAGEPATH に合わせて画像表示 -->
                <img src="${pageContext.request.contextPath}/images/${goods.goods_imagepath}"
                     width="150" height="150"
                     onerror="this.src='${pageContext.request.contextPath}/images/noimage.png';">

                <div>
                    <div>商品名: ${goods.goods_name}</div>
                    <div>価格: ${goods.price}円</div>
                    <div>在庫: ${goods.stock}</div>

                    <c:choose>
                        <c:when test="${goods.stock > 0}">
                            <a href="#" onclick="addToCart('${goods.goods_id}'); return false;">
                                カートに入れる
                            </a>
                        </c:when>
                        <c:otherwise>
                            <span style="color:red; font-weight:bold;">在庫なし</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </li>
        </c:forEach>
    </c:if>
    <c:if test="${empty goodsList}">
        <li>商品は登録されていません</li>
    </c:if>
</ul>
</div>

<script>
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String goodsId = request.getParameter("goods_id");

        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(goodsId);
        session.setAttribute("cart", cart);

        response.getWriter().write("OK");
    }
}

function showPopup() {
    const popup = document.getElementById("popupMessage");
    popup.style.display = "block";

    setTimeout(() => {
        popup.style.display = "none";
    }, 2000);
}

function addToCart(goodsId) {
    fetch("${pageContext.request.contextPath}/addToCart", {  // Servlet URL
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "goods_id=" + goodsId
    })
    .then(response => response.text())
    .then(() => {
        showPopup();
    })
    .catch(() => {
        alert("エラーが発生しました");
    });
}
</script>

</body>
</html>
