<%-- ヘッダー　親族専用 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">


<h1>ストックわかる君</h1>

<div class="header-right">
<c:if test="${sessionScope.relatives.isAuthenticated()}">

	<div class="header-name">
		<span class="user">${sessionScope.relatives.getName()} さん</span>
		<a class="logout-link" href="rtLogout.jsp">ログアウト</a>
	</div>

	<div class="hamburger" id="hamburger">
      <span></span>
      <span></span>
      <span></span>
    <nav id="nav">
      <a href="Sin_stockList.action?rt_id=${relatives.rt_id}">ストック管理</a>
      <a href="../ecSite/EClist.jsp">ECサイト</a>
      <a href="Sin_conList.action">連絡帳</a>
      <a href="rtInfoDisplay.jsp">マイページ</a>
      <a href="rtLogoutCon.jsp">ログアウト</a>
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

