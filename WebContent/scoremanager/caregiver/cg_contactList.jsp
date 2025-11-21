<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳一覧
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conList.css">
	</c:param>

	<c:param name="content">
		<div class="notification-list">
		    <h1>連絡帳</h1>
		    <h2>通知一覧</h2>
		    
		    <c:forEach var="" items ="${}">
		    <ul>
		      <li class="notification">
		        <span class="date">${}</span>
		        <span class="title">${}</span>
		      </li>
		    </ul>
			</c:forEach>
		    
		    
			<div class="contact">
		    <button class="">連絡を作成</button>
			</div>
		  </div>

	</c:param>
</c:import>





<%--
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>通知一覧</title>
  <link rel="stylesheet" href="constyle.css">
</head>
<body>

  <div class="notification-list">
    <h1>連絡帳</h1>
    <h2>通知一覧</h2>
    <ul>
      <li class="notification">
        <span class="date">2025-10-23 10:37</span>
        <span class="title">せんべいの購入依頼</span>
      </li>

      <li class="notification">
        <span class="date">2025-09-28 08:00</span>
        <span class="title">
            <span class="badge">返信</span>
            ＜定期＞施設内でヘアカットを行います</span>
      </li>

      <li class="notification">
        <span class="date">2025-09-13 08:00</span>
        <span class="title">
            <span class="badge">返信</span>
            イベントを行います</span>
      </li>

    </ul>
  </div>

<div class="contact">
    <button class="">連絡を作成</button>
</div>

</body>
</html>
--%>