<%-- 連絡帳　介護士＿入力画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../../baseKai.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳作成
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conInput.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="Kai_conCreateExecute.action" method="get" >
			<a class="back-con" href="Kai_conList.action?rd_id=${resident.rd_id}">戻る</a>


		    <div class="recipient">
		    	<h1>連絡帳　作成</h1>
		    	<a>入居者：${resident.name} さん</a>
		    </div>

		    <div class="input-list">
    		<div>
		        <a>件名</a><input type="text" name="title" required>
		        <br>
		        <a>内容</a>
		        <br><textarea name="content" required></textarea>
   			</div>

    		<div>
				<a>返信欄選択 ※いずれか一つ必ず選択してください。</a>
				<div>
					<input type="radio" name="cheak" value="1">Yes / No
					<input type="radio" name="cheak" value="2">確認しました
					<input type="radio" name="cheak" value="3">返信不要
				</div>
			</div>

			<div class="text-right">
				<input type="hidden" name="rd_id" value="${resident.rd_id}">
				<input type="hidden" name="rt_id" value="${relatives.rt_id}">
				<button class="" id="submitBtn" disabled>送信</button>
				<a href="Kai_conList.action?rd_id=${resident.rd_id}" class="">キャンセル</a>
			</div>
			</div>

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

