<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseNyu.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">

<main>
  <div class="mainmenu">
    <ul>
      <li><a href="Nyu_stockList.action?rd_id=${resident.rd_id}">ストック管理</a></li>
	  <li><a href="../ECsite/AllExecute.action">購入</a></li>
	  <li><a href="./rdInfoDisplay.jsp">ユーザー情報表示</a></li>
	  <li><a href="./rdLogoutCon.jsp">ログアウト</a></li>
    </ul>
  </div>
</main>