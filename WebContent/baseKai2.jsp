<%-- 共通テンプレート 介護士専用 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
 	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/baseKai2.css">
	<title>${param.title}</title>
  	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	${param.scripts}
</head>
<body>


  <header>
	<c:import url="/headerKai2.jsp" />
  </header>

  <main>
	<div class="content">
		${param.content}
	</div>
  </main>


</body>
</html>
