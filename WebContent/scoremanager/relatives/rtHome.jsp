<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../baseSin.jsp" %>

<link rel="stylesheet" href="../css/base.css">

<main>

  <div class="home-container">

    <c:if test="${hasExpiredProduct}">
      <p>hasExpiredProduct = ${hasExpiredProduct}</p>
      <div class="warning">
        <li><a>購入から8カ月経過した商品があります</a></li>
      </div>
    </c:if>
  </div>

  <div class="mainmenu">
    <ul>
      <li><a href="Sin_stockList.action?rt_id=${relatives.rt_id}">備品管理</a></li>
      <li><a href="../ecSite/EClist.jsp">購入</a></li>
      <li><a href="${pageContext.request.contextPath}/scoremanager/relatives/Sin_conList.action">連絡帳</a></li>
      <li><a href="SinDisplayExecute.action">ユーザー情報表示</a></li>
      <li><a href="./rtLogoutCon.jsp">ログアウト</a></li>
    </ul>
  </div>
</main>
