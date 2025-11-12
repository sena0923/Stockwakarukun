<%-- ヘッダー --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">


<h1>ストックわかる君</h1>
<div class="hamburger" id="hamburger">
      <span></span>
      <span></span>
      <span></span>
    </div>
    <nav id="nav">
      <a href="#">備品管理</a>
      <a href="#">購入</a>
      <a href="#">連絡帳</a>
      <a href="#">ユーザー情報表示</a>
      <a href="#">ログアウト</a>
    </nav>



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