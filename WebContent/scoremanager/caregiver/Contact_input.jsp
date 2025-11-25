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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conList.css">
	</c:param>

	<c:param name="content">
		<form class="notification-list" action="Kai_conCreateExecute.action" method="get" >
		    <h1>連絡帳　${resident.name} さん</h1>
		    <h2>親族名　${relatives.name} さん</h2>

		    <div class="input-list">
    		<div>
		        <a>件名</a><input type="text" name="title" required>
		        <br>
		        <a>内容</a>
		        <br><textarea name="content" rows="10" cols="60" required></textarea>
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





<%--
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>連絡作成</title>
  <link rel="stylesheet" href="constyle.css">
</head>

<body>
    <div class="contact">
    <h1>連絡帳  〇〇さん</h1>
    </div>

    <div class="notification-list">
    <div>
        <a>件名</a><input type="text">
        <br>
        <a>内容</a>
        <br><textarea rows="10" cols="60"></textarea>
    </div>

    <div>
        <a>返信欄選択</a>
        <div>
            <input type="checkbox" name="cheak1" value="ok">Yes / No
            <input type="checkbox" name="cheak2" value="ok">確認しました
            <input type="checkbox" name="cheak3" value="ok">返信不要
        </div>
    </div>

    <div class="text-right">
        <button class="">送信</button>
    </div>

  </div>


</body>
</html>
--%>
