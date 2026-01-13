<%-- 連絡帳　親族＿連絡帳詳細画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseSin.jsp">
	<c:param name="title">
		連絡帳内容
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conContent_phone.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="Sin_conContentExecute.action" method="get">

			<a class="back-con" href="Sin_conList.action?rd_id=${resident.rd_id}">戻る</a>

			<div class="set">
		    	<h1>連絡帳　内容</h1>

		    	<a>入居者：${resident.name} さん</a>
		    </div>

		    <div class="con-main">

			    <%-- 左側：一覧
			    <div class="con-list">
			    	<ul>
						<c:forEach var="m" items="${list}">
							<li class="notification ${m.me_id == param.me_id ? 'active' : ''}">
								<span class="date">
									<fmt:formatDate value="${m.da_ti}" pattern="yyyy/MM/dd"/>
								</span>
								<div class="title_content">
									<c:if test="${m.message_choice.choise != null}">
										<span class="badge">返信</span>
									</c:if>
									<a class="title"
									   href="Sin_conContent.action?rd_id=${resident.rd_id}&rt_id=${relatives.rt_id}&me_id=${m.me_id}">
										${m.title}
									</a>
								</div>
							</li>
						</c:forEach>
					</ul>
			    </div>
				 --%>

			    <%-- 右側：詳細 --%>
			    <div class="input-list">
				<p>返信 ありがとうございます。</p>
				</div>
			</div>

			<script>
				const inputs = document.querySelectorAll('input[name="cheak"]');
				const submitBtn = document.getElementById('submitBtn');

				inputs.forEach(input => {
					input.addEventListener('change', () => {
						submitBtn.disabled = false;
					});
				});
			</script>

		</form>
	</c:param>
</c:import>
