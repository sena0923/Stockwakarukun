<%-- ヘッダー　入居者専用 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">


<h1>ストックわかる君</h1>

<div class="header-right">
<c:if test="${sessionScope.resident.isAuthenticated()}">

	<div class="header-name">
		<span class="user">${sessionScope.resident.getName()} さん</span>
		<a class="logout-link" href="rdLogoutCon.jsp">ログアウト</a>
	</div>

	<div class="hamburger" id="hamburger">
      <span></span>
      <span></span>
      <span></span>
    <nav id="nav">
      <a href="rd_stockList.jsp">ストック管理</a>
      <a href="../ecSite/EClist.jsp">ECサイト</a>
      <a href="rdInfoDisplay.jsp">マイページ</a>
      <a href="rdLogoutCon.jsp">ログアウト</a>
    </nav>
    </div>
    </c:if>
</div>


<script>
	document.addEventListener("DOMContentLoaded", function() {
	const hamburger = document.getElementById('hamburger');
	const nav = document.getElementById('nav');

		hamburger.addEventListener('click', function() {
		nav.classList.toggle('active');
		hamburger.classList.toggle('open');
	});
	});

</script>

