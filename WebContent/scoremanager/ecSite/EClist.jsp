<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EC商品一覧</title>

<style>
#popupMessage {
    position: fixed;
    top: 20px;
    left: 50%;
    transform: translateX(-50%);
    background: #4CAF50;
    color: white;
    padding: 12px 20px;
    border-radius: 6px;
    display: none;
    z-index: 9999;
}

.ec-page ul {
    list-style: none;
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    padding: 0;
}

.ec-page li {
    border: 1px solid #ccc;
    padding: 10px;
    width: 220px;
    text-align: center;
}

/* =========================
   スマホ用（768px以下）
========================= */
@media screen and (max-width: 768px) {

    .ec-page ul {
        flex-direction: column;
        align-items: center;
        gap: 15px;
    }

    .ec-page li {
        width: 90%;
        padding: 15px;
        font-size: 16px;
    }

    .ec-page img {
        width: 180px;
        height: 180px;
        object-fit: contain;
    }

    .ec-page button {
        width: 100%;
        padding: 14px;
        font-size: 18px;
        margin-top: 10px;
        border-radius: 6px;
        touch-action: manipulation;   /* ★スマホ用 */
        pointer-events: auto;         /* ★タップ確実化 */
    }

    .ec-page form {
        position: relative;
        z-index: 10;                  /* ★ヘッダー被り対策 */
    }

    #popupMessage {
        top: 10px;
        width: 80%;
        text-align: center;
        font-size: 16px;
    }

    #rotateWarning {
    display: none;
    background-color: #ffdddd;
    color: red;
    font-weight: bold;
    text-align: center;
    padding: 10px;
}
}
</style>

<!-- ★ 横向きチェック（ここに追加） -->
<script>
document.addEventListener("DOMContentLoaded", function() {

    if (sessionStorage.getItem("orientationChecked")) return;

    if (window.innerWidth < 768 && window.innerHeight > window.innerWidth) {
        alert("横向きでご利用ください");
        sessionStorage.setItem("orientationChecked", "true");
    }

});
</script>



</head>


<body>

<div id="rotateWarning">
    横向きでご利用ください
</div>


<%@ include file="../../headerEC.jsp" %>

<div id="popupMessage">カートに追加されました</div>

<c:if test="${not empty sessionScope.cartAdded}">
<script>
document.addEventListener("DOMContentLoaded", function() {
    const popup = document.getElementById("popupMessage");
    popup.style.display = "block";
    setTimeout(() => popup.style.display = "none", 2000);
});

if (window.innerWidth < 768) {
    alert("横向きでご利用ください");
}
</script>

<c:remove var="cartAdded" scope="session" />
</c:if>

<div class="ec-page">
<ul>

<c:forEach var="goods" items="${goodsList}">
<li>

<img
    src="${pageContext.request.contextPath}${goods.image_path}"
    width="150"
    height="150"
    onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/images/noimage.png';"
    alt="商品画像">

<div>商品名：${goods.goods_name}</div>
<div>価格：${goods.price}円</div>
<div>在庫：${goods.stock}</div>

<c:choose>
<c:when test="${goods.stock > 0}">
<form action="${pageContext.request.contextPath}/scoremanager/ECsite/AddCartExecute.action" method="post">
    <input type="hidden" name="goods_id" value="${goods.goods_id}">
    <input type="hidden" name="quantity" value="1">
    <input type="hidden" name="price" value="${goods.price}">
    <button type="submit">カートに入れる</button>
</form>
</c:when>
<c:otherwise>
<span style="color:red; font-weight:bold;">在庫なし</span>
</c:otherwise>
</c:choose>

</li>
</c:forEach>

</ul>
</div>

<!-- ★スマホのみ強制submit補助 -->
<script>
if (window.innerWidth <= 768) {
    document.querySelectorAll(".ec-page form").forEach(form => {
        form.addEventListener("touchend", function() {
            form.submit();
        });
    });
}
</script>

<script>
function checkOrientation() {
    const warning = document.getElementById("rotateWarning");

    if (window.innerWidth < 768 && window.innerHeight > window.innerWidth) {
        warning.style.display = "block";
    } else {
        warning.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", checkOrientation);
window.addEventListener("resize", checkOrientation);
</script>

</body>
</html>
