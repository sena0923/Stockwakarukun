<%-- 連絡帳　親族＿連絡帳詳細画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseSin.jsp">
	<c:param name="title">
		連絡帳内容
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conContent.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="#" method="get" >
			<a class="back-con" href="Sin_conList.action?rd_id=${resident.rd_id}">戻る</a>


		    <div class="recipient">
		    	<h1>連絡帳　内容</h1>
		    	<a>入居者：${resident.name} さん</a>
		    </div>

		    <div class="con-main">
			    <div class="con-list">
			    	<ul>
						<c:forEach var="m" items ="${list}">
							<li class="notification  ${m.me_id == param.me_id ? 'active' : ''}">
								<span class="date"><fmt:formatDate value="${m.da_ti}" pattern="yyyy/MM/dd"/></span>
								<a class="title" href="Sin_conContent.action?rd_id=${resident.rd_id}&rt_id=${relatives.rt_id}&me_id=${m.me_id}">${m.title}</a>
							</li>
						</c:forEach>
					</ul>
			    </div>

			    <div class="input-list">
					<div class="taitle">
						<a>件名：${message.title}</a>
					</div>

					<div class="con">
						<a>内容</a>
						<p><c:out value="${message.message}" escapeXml="true"/></p>
					</div>

					<div class="reply">
						<a>返信</a>
						<%-- 返信があった場合，if処理で表示 --%>
						<%-- まだ無い場合，「-----」 --%>
						<p>------</p>
					</div>

					<div class="text-right">
						<input type="hidden" name="rd_id" value="${resident.rd_id}">
						<input type="hidden" name="rt_id" value="${relatives.rt_id}">
						<button class="" id="submitBtn" disabled>返信</button>
					</div>
				</div>
			</div><%-- class="con-main"ここまで --%>

			<script>
				// ラジオボタンが選択されたら送信ボタンを有効化
				const radios = document.querySelectorAll('input[name="cheak"]');
				const submitBtn = document.getElementById('submitBtn');

				radios.forEach(radio => {
					radio.addEventListener('change', () => {
						submitBtn.disabled = false;
					});
				});
			</script>
		</form>
	</c:param>
</c:import>

