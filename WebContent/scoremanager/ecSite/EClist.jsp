<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../headerEC.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="../../css/EClist.css">
<meta charset="UTF-8">
<title>EC商品一覧</title>

</head>
<body>

<div class="ec-page">
<h2>ECサイト 商品一覧</h2>

<!-- カテゴリータブ -->
<ul class="category-menu">

   <li class="${selectedCategory == 'All' ? 'active' : ''}">
    	<a href="NyuECExecute.action?category=All">すべて</a>
	</li>

    <li class="${selectedCategory == 'A' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=A">洗面用具</a>
    </li>

    <li class="${selectedCategory == 'B' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=B">タオル</a>
    </li>

    <li class="${selectedCategory == 'C' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=C">衣類</a>
    </li>

    <li class="${selectedCategory == 'D' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=D">防寒</a>
    </li>

    <li class="${selectedCategory == 'E' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=E">備品</a>
    </li>

    <li class="${selectedCategory == 'F' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=F">娯楽</a>
    </li>

</ul>
</div>

<!-- 商品一覧 -->
<div class="product-list">
  <!-- 「すべて」カテゴリが選ばれたときに AllList を表示 -->
<c:if test="${selectedCategory == 'All'}">
    <h3>すべての持ち物リスト</h3>
    <ul>
        <c:forEach var="item" items="${AllList['すべて']}">
            <li>${item}</li>
              <a href="#">カートに入れる</a>
        </c:forEach>

    </ul>
</c:if>
</div>
</body>
</html>
