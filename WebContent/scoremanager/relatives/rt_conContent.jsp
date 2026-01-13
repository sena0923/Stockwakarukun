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

					<div class="taitle">
						<a>件名：${message.title}</a>
					</div>

					<div class="con">
						<a>内容</a>
							<p>${message.message}<p/>
					</div>

					<div class="reply">
					    <a>返信</a>

					    <c:choose>

							<%-- 返信をまだしていない場合 --%>
							<c:when test="${message.message_choice.choise == null}">

								<c:choose>

									<%-- Yes/No を表示する場合 --%>
									<c:when test="${message.message_choice.choise_num == 1}">
										<label>
											<input type="radio" name="cheak" value=true>
												YES
										</label>
										<label style="margin-left:20px;">
					 						<input type="radio" name="cheak" value=false>
					 							NO
					 					</label>
									</c:when>

									<%-- 確認しました を表示する場合 --%>
					                <c:when test="${message.message_choice.choise_num == 2}">
										<label>
											<input type="checkbox" name="cheak" value=true>
												確認しました
										</label>
									</c:when>

									<%-- 返信不要 を表示する場合 --%>
									<c:when test="${message.message_choice.choise_num == 3}">
										<p>返信不要です</p>
									</c:when>

								</c:choose>

					        </c:when>


					        <%-- すでに返信している場合 --%>
							<c:otherwise>
							<p>返信済みです</p>

								<c:choose>

									<%-- Yes/No の返信だった場合 --%>
					                <c:when test="${message.message_choice.choise_num == 1}">
					                    <c:choose>
					                    	<c:when test="${message.message_choice.choise == true}">
					                    		<p>Yes</p>
					                    	</c:when>
					                    	<c:when test="${message.message_choice.choise == false}">
					                    		<p>No</p>
					                    	</c:when>
					                    </c:choose>
					                </c:when>

									<%-- 確認しました の返信だった場合 --%>
					                <c:when test="${message.message_choice.choise_num == 2}">
					                    <p>確認しました</p>
					                </c:when>

					            </c:choose>
					        </c:otherwise>

					    </c:choose>
					</div>


					<div class="text-right">
						<input type="hidden" name="rd_id" value="${resident.rd_id}">
						<input type="hidden" name="rt_id" value="${relatives.rt_id}">
						<input type="hidden" name="me_id" value="${message.me_id}">
						<button id="submitBtn" disabled>返信</button>
					</div>

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
