<%-- 介護士ログイン画面 --%>
<%-- ログインJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai2.jsp">
	<c:param name="title">
		ストックわかるくん
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="KaiLoginExecute.action" method="post">
			<h1>介護士ログイン</h1>

			<c:if test="${errors.size()>0}">
				<div>
					<ul>
						<c:forEach var="error" items="${errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>

			<div class="controll">
			<label for="staffnum">職員番号</label>
				<input type="text" id="staffnum" name="staffnum" required>
			</div>

	        <div class="controll">
	            <label for="password">パスワード</label>
	            <input id="password" type="password" name="password" required>
	        </div>



	        <!-- 入力欄のすぐ下に配置 -->
	        <div class="button-group">
	            <button class=btn type="submit">ログイン</button>
	            <a href="cg_create.jsp" class="btn">新規登録画面へ</a>
			</div>
		</form>
	</c:param>
</c:import>
