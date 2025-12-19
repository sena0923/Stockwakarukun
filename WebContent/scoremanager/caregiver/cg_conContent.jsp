<%-- 連絡帳　介護士＿入力画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳内容
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conContent.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="#" method="get" >
			<a class="back-con" href="Kai_conList.action?rd_id=${resident.rd_id}">戻る</a>


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
								<div class = "title_content">
			        			<c:if test="${m.message_choice.choise != null}">
			        				<span class="badge">返信</span>
			        			</c:if>
								<a class="title" href="Kai_conContent.action?rd_id=${resident.rd_id}&rt_id=${relatives.rt_id}&me_id=${m.me_id}">${m.title}</a>
								</div>
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
						<p>${message.message}</p>
					</div>

					<div class="reply">
					    <a>返信</a>

					    <c:choose>

					         <%--親族から返信がある場合 --%>
					        <c:when test="${message.message_choice.choise != null}">

					            <c:choose>

									<%-- Yes/No の返信だった場合 --%>
					                <c:when test="${message.message_choice.choise_num == 1}">
					                    <c:choose>
					                    	<c:when test="${message.message_choice.choise == true}">
					                    		<p>返信済みです</p>
					                    		<p>●Yes</p>
					                    	</c:when>
					                    	<c:when test="${message.message_choice.choise == false}">
					                    		<p>返信済みです</p>
					                    		<p>●No</p>
					                    	</c:when>
					                    </c:choose>
					                </c:when>

									<%-- 確認しました の返信だった場合 --%>
					                <c:when test="${message.message_choice.choise_num == 2}">
					                	<p>返信済みです</p>
					                    <p>●確認しました</p>
					                </c:when>

					            </c:choose>

					        </c:when>

							<%-- まだ返信がない場合 --%>
							<c:otherwise>

								<c:choose>

									<%-- Yes/No の返信だった場合 --%>
					                <c:when test="${message.message_choice.choise_num == 1}">
					                	<p>返信は ありません</p>
										<p>〇Yes  〇No</p>
					                </c:when>

									<%-- 確認しました の返信だった場合 --%>
					                <c:when test="${message.message_choice.choise_num == 2}">
					                    <p>返信は ありません</p>
										<p>〇確認しました</p>
					                </c:when>

									<%-- 返信不要 だった場合 --%>
									<c:when test="${message.message_choice.choise_num == 3}">
										<p>〇返信不要です</p>
					                </c:when>

					            </c:choose>

							</c:otherwise>

					    </c:choose>
					</div>


					<div class="text-right">
						<input type="hidden" name="rd_id" value="${resident.rd_id}">
						<input type="hidden" name="rt_id" value="${relatives.rt_id}">
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

