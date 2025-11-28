<%-- 介護士が閲覧する入居者リスト画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		入居者一覧
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kai_rdList.css">
	</c:param>

	<c:param name="content">
		<form class="container"  action="RdSearch.action" method="get">
			<h1>入居者一覧</h1>

			<div class="search">
					<label for="f1" class="label">入居者名</label>
					<input type="text" name="name" placeholder="フルネーム - スペース入力不可" required>
					<button type="submit" class="btn-search" id="filter-button">検索</button>
			</div>

			<p>詳細を押下すると入居者の連絡帳やプロフィールが確認できます。</p>

					<table class="table">
						<tr>
							<th>入居者氏名</th>
							<th>性別</th>
							<th>コース</th>
							<th>詳細</th>
						</tr>
						<c:forEach var="resident" items="${list}">
							<tr>
								<td>${resident.name}</td>
								<td>${resident.gender}</td>
								<td>${resident.course.course_name}</td>
								<td><a href="Kai_rdMenu.action?rd_id=${resident.rd_id}">詳細</a></td>
							</tr>
						</c:forEach>
					</table>
			<a href="KaiMenu.action" class="back-btn">ホームへ戻る</a>
		</form>
	</c:param>
</c:import>


<%--
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>入居者一覧</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
    font-family: sans-serif;
    background-color: #f5f5f5;
  }

  /* 画面中央配置 */
  body {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  /* 中央に配置されるカード */
  .container {
    background: #fff;
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    text-align: center;
    width: 600px;
    max-width: 95%;
  }

  h1 {
    margin-bottom: 10px;
  }

  p {
    margin: 8px 0;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
    margin-bottom: 20px;
  }

  th, td {
    padding: 8px;
    border-bottom: 1px solid #ddd;
  }

  th {
    background: #f0f0f0;
  }

  a {
    text-decoration: none;
    background: #b8d200;
    color: #000;
    border-radius: 5px;
    padding: 5px 12px;
    display: inline-block;
    font-weight: bold;
  }

  a:hover {
    background: #a5bf00;
  }

  /* 戻るボタン */
  .back-btn {
    margin-top: 20px;
    background: #ccc;
    color: #000;
    padding: 8px 16px;
    border-radius: 6px;
    display: inline-block;
  }

  .back-btn:hover {
    background: #bbb;
  }
</style>
</head>
<body>
  <div class="container">
    <h1>入居者一覧</h1>
    <p>詳細を押下すると入居者の連絡帳やプロフィールが確認できます。</p>

    <table>
      <tr>
        <th>名前</th>
        <th>誕生日</th>
        <th>性別</th>
        <th>コース</th>
        <th>詳細</th>
      </tr>
      <tr>
        <td>△△さん</td>
        <td>4月5日</td>
        <td>男</td>
        <td>要介護コース</td>
        <td><a href="詳細.jsp">詳細</a></td>
      </tr>
      <tr>
        <td>□□さん</td>
        <td>7月17日</td>
        <td>女</td>
        <td>独立コース</td>
        <td><a href="詳細.jsp">詳細</a></td>
      </tr>
      <tr>
        <td>〇〇さん</td>
        <td>10月2日</td>
        <td>男</td>
        <td>独立コース</td>
        <td><a href="詳細.jsp">詳細</a></td>
      </tr>
      <tr>
        <td>▽▽さん</td>
        <td>9月26日</td>
        <td>女</td>
        <td>要介護コース</td>
        <td><a href="詳細.jsp">詳細</a></td>
      </tr>
    </table>

    <a href="kai_menu.jsp" class="back-btn">ホームへ戻る</a>
  </div>
</body>
</html>
--%>