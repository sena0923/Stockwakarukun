<%-- 介護士新規登録画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai2.jsp">
	<c:param name="title">
		介護士新規登録Complete
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="KaiCreateExecute.action" method="get">
				<h1>介護士新規登録完了</h1>


        <div class="select">
            <a href="KaiLogin.action">ログイン</a>
        </div>

		</form>
	</c:param>
</c:import>


