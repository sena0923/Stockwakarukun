<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseSin.jsp">
	<c:param name="title">
		連絡帳一覧
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conList.css">
	</c:param>

	<c:param name="content">
		<form class="notification-list" action="Sin_conCreate.action" method="get" >
			<a class = "back" href="SinMenu.action">戻る</a>

		    <h1>連絡帳</h1>
		    <h2>通知一覧</h2>

			<c:if test="${empty list}">
				<p>メッセージはありません。</p>
			</c:if>

			<ul>
			    <c:forEach var="m" items ="${list}">

			      <li class="notification">
			        <span class="date"><fmt:formatDate value="${m.da_ti}" pattern="yyyy/MM/dd"/></span>
			         <div class = "title_content">
			        <c:if test="${m.message_choice.choise != null}">
			        	<span class="badge">返信</span>
			        </c:if>
			        <a class="title" href="Sin_conContent.action?rd_id=${resident.rd_id}&rt_id=${relatives.rt_id}&me_id=${m.me_id}">${m.title}</a>
			      	</div>
			      </li>
				</c:forEach>
			</ul>

		  </form>

	</c:param>
</c:import>
