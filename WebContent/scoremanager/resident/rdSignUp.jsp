<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>入居者情報入力画面</title>
  <link rel="stylesheet" href="../../css/style.css">
</head>
<body>

  <h1>入居者情報入力画面</h1>

  <!-- ★ここを JSP のアクションに変更 -->
  <form id="residentForm" action="NyuCreateExecute.action" method="post">

			<c:if test="${not empty errors}">
				<ul style="color:red;">
					<c:forEach var="err" items="${errors}">
						<li>${err.value}</li>
					</c:forEach>
				</ul>
			</c:if>

    <!-- コース選択 -->
    <div class="row">
      <label>コースを選んでください</label>
      <div class="radio-group column">

        <div class="radio-item">
          <input id="radio-a" type="radio" name="course_id" value="1" checked>
          <label for="radio-a">自立コース</label>
        </div>

        <div class="radio-item">
          <input id="radio-b" type="radio" name="course_id" value="2">
          <label for="radio-b">要介護コース</label>
        </div>

      </div>
    </div>

    <!-- 名前 -->
    <label for="name">お名前</label>
    <input type="text" id="name" name="name" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>" required>

    <!-- 性別 -->
    <div class="row">
      <label>性別</label>
      <div class="radio-group column">
        <div class="radio-item">
          <input id="radio-c" type="radio" name="gender" value="男" checked>
          <label for="radio-c">男</label>
        </div>
        <div class="radio-item">
          <input id="radio-d" type="radio" name="gender" value="女">
          <label for="radio-d">女</label>
        </div>
        <div class="radio-item">
          <input id="radio-e" type="radio" name="gender" value="回答しない">
          <label for="radio-e">回答しない</label>
        </div>
      </div>
    </div>

    <!-- ログインID -->
    <label for="login-id">ログインID</label>
    <input type="text" id="login-id" name="rd_id" pattern="^[0-9]+$"
           value="<%= request.getAttribute("id") != null ? request.getAttribute("id") : "" %>"
           required placeholder="携帯番号を入力。「-」入力不可">
    <div id="id-error" class="error-message">
      <%= request.getAttribute("errors") != null && ((java.util.Map)request.getAttribute("errors")).get("1") != null
          ? ((java.util.Map)request.getAttribute("errors")).get("1")
          : "" %>
    </div>

    <!-- パスワード -->
    <label for="password">パスワード</label>
    <input type="password" id="password" name="password"  required>

    <!-- パスワード確認 -->
    <label for="passwordconfirm">パスワード(確認用)</label>
    <input type="password" id="passwordconfirm" name="password2"  required>

    <div id="password-error" class="error-message">
      <%= request.getAttribute("errors") != null && ((java.util.Map)request.getAttribute("errors")).get("2") != null
          ? ((java.util.Map)request.getAttribute("errors")).get("2")
          : "" %>
    </div>

	<div class="select">
	    <button class="btn2" type="submit">新規登録</button>
	    <a href="NyuLogin.action">ログイン</a>
	</div>

  </form>

</body>
</html>
