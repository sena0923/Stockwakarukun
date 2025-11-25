<%-- 連絡帳　親族＿入力画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳作成
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conList.css">
	</c:param>

	<c:param name="content">
		<form class="notification-list" action="Sin_conCreate.action" method="get" >

			<%--介護士名 --%>
		    <h1>連絡帳　${kai.name} さん</h1>

		    <div class="input-list">
    		<div>
		        <a>件名</a><input type="text" value="title" name="title">
		        <br>
		        <a>内容</a>
		        <br><textarea rows="10" cols="60"></textarea>
   			</div>

    		<div>
				<a>返信欄選択</a>
				<div>
					<input type="radio" name="cheak1" value="yes">Yes
					<input type="radio" name="cheak2" value="no">No
					<input type="radio" name="cheak3" value="check">確認しました
					<input type="radio" name="cheak4" value="no_message">返信不要
				</div>
			</div>

			<div class="text-right">
				<button class="">送信</button>
			</div>
			</div>
		</form>

	</c:param>
</c:import>

