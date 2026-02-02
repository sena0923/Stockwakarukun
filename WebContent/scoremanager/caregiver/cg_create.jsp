<%-- 介護士新規登録画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai2.jsp">
	<c:param name="title">
		介護士新規登録
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="KaiCreateExecute.action" method="get">
				<h1>介護士新規登録</h1>

			<c:if test="${not empty errors}">
				<ul style="color:red;">
					<c:forEach var="err" items="${errors}">
						<li>${err.value}</li>
					</c:forEach>
				</ul>
			</c:if>

				<div class="controll">
		            <label for="facility_pw">施設パスワード <span class="required">必須</span></label>
		            <input type="text" id="facility_id" name="facility_id" required>
	        	</div>

	        <div class="controll">
	            <label for="name">氏名 <span class="required">必須</span></label>
	            <input type="text" id="name" name="name" required>
	        </div>

	        <div class="controll">
	            <label for="id">職員番号 <span class="required">必須</span></label>
	            <input type="text" id="id" name="id" required>
	        </div>

	        <div class="controll">
	            <label for="pw">パスワード <span class="required">必須</span></label>
	            <input type="text" id="pw" name="pw" required>
	        </div>

	        <div class="controll">
	            <label for="pw_2">確認用パスワード <span class="required">必須</span></label>
	            <input type="text" id="pw_2" name="pw_2" required>
	        </div>


        <div class="select">
            <button class="btn" type="submit">新規登録</button>
        </div>
        <br>
        <a href="KaiLogin.action">ログインへ戻る</a>

		</form>
	</c:param>
</c:import>


