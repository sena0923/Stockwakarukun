<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳一覧
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conList.css">
	</c:param>

	<c:param name="content">
		<form class="notification-list" action="Kai_conCreate.action" method="get" >
			<a class = "back" href="Kai_rdMenu.action?rd_id=${resident.rd_id}">戻る</a>

		    <h1>連絡帳　${resident.name} さん</h1>

			<div class="contact">
				<input type="hidden" name="rd_id" value="${resident.rd_id}">
				<input type="hidden" name="rt_id" value="${relatives.rt_id}">
				<button class="add">連絡を作成</button>
			</div>

		    <h2>通知一覧</h2>

			<c:if test="${empty list}">
				<p>メッセージはありません。</p>
			</c:if>

			<ul>
			    <c:forEach var="m" items ="${list}">

			      <li class="notification">
			        <span class="date"><fmt:formatDate value="${m.da_ti}" pattern="yyyy/MM/dd"/></span>
			        <span class="title" href="#">${m.title}</span>
			      </li>
				</c:forEach>
			</ul>


		  </form>

	</c:param>
</c:import>
