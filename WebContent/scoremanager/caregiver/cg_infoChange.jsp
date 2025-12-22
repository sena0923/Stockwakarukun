<%-- 介護士アカウント更新入力画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		介護士アカウント変更画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="Kai_infoChangeExecute.action" method="get">
				<h1>介護士アカウント変更</h1>

			<c:if test="${not empty errors}">
				<ul style="color:red;">
					<c:forEach var="err" items="${errors}">
						<li>${err.value}</li>
					</c:forEach>
				</ul>
			</c:if>

	        <div class="controll">
	            <label for="name">氏名 <span class="required">必須</span></label>
	            <input type="text" value="${cg.name}" id="name" name="name" required>
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
        	<input type="hidden" name="cg_id" value="${cg.staffid}">
            <button class="btn" type="submit">変更</button>
            <a href="Kai_account.action?cg_num=${cg.staffid}">キャンセル</a>
        </div>

		</form>
	</c:param>
</c:import>