<%-- 共通テンプレート 介護士専用 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
 	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/baseKai.css">
	<title>${param.title}</title>
  	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	${param.scripts}
</head>
<body>


  <header>
	<c:import url="/headerKai.jsp" />
  </header>

  <main>
	<c:if test="${sessionScope.caregiver.isAuthenticated()}">
		<c:import url="/navigation.jsp" />
	</c:if>
		<div class="content">
			${param.content}
		</div>
  </main>


	<footer>
		<a href="#" id="page-top"><i class="blogicon-chevron-up">▲</i></a>
	</footer>


<script>
$(function() {
  var pageTop = $('#page-top');
  pageTop.hide(); // 初期は非表示
  $(window).scroll(function() {
    if ($(this).scrollTop() > 10) {
      pageTop.fadeIn();
    } else {
      pageTop.fadeOut();
    }
  });
  pageTop.click(function() {
    $('html, body').animate({ scrollTop: 0 }, 500);
    return false;
  });
});
</script>



</body>
</html>
