<%-- 連絡帳　介護士＿入力画面 --%>



<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

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

