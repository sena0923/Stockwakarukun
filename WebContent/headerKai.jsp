<%-- ヘッダー介護士専用 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">


<h1>ストックわかる君</h1>

<div class="header-right">
<c:if test="${sessionScope.caregiver.isAuthenticated()}">

		<span class="user">${sessionScope.caregiver.getName()} さん</span>
		<a class="logout-link" href="logout.jsp">ログアウト</a>


	<div class="hamburger" id="hamburger">
      <span></span>
      <span></span>
      <span></span>
    <nav id="nav">
      <a href="RdList.action">入居者一覧</a>
      <a href="cg_infoDisplay.jsp">マイページ</a>
      <a href="logout.jsp">ログアウト</a>
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

