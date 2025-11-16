<%-- ヘッダー　親族専用 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">


<h1>ストックわかる君</h1>

<div class="header-right">
<c:if test="${sessionScope.relatives.isAuthenticated()}">

		<span class="user">${sessionScope.relatives.getName()} さん</span>
		<a class="logout-link" href="Logout.action">ログアウト</a>


	<div class="hamburger" id="hamburger">
      <span></span>
      <span></span>
      <span></span>
    <nav id="nav">
      <a href="#">ストック管理</a>
      <a href="#">ECサイト</a>
      <a href="#">連絡帳</a>
      <a href="#">マイページ</a>
      <a href="#">ログアウト</a>
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

