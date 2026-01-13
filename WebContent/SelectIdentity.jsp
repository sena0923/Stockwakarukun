<%-- 身分選択ページ --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<div class="Gradation_1">

<main>
<form class="container">
	<a>ストックわかる君</a>
	<h1>あなたの立場を選択</h1>

<form class="container">
  <div class="button-row">
    <a href="caregiver/KaiLogin.action" class="btn1">介護士</a>
    <a href="resident/NyuLogin.action" class="btn1">入居者</a>
    <a href="relatives/SinLogin.action" class="btn1">親族</a>
  </div>
</form>
</main>
</div>


<style>
html, body {
  height: 100%;
  margin: 0;
  padding: 0;
}

html, body {
  overflow-x: hidden;
}


  body {
    font-family: "Hiragino Sans", "Meiryo", sans-serif;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    margin: 0;
    background-color: #f7f7f7;
  }

  a{
  font-family:"ヒラギノ丸ゴ Pro W4","ヒラギノ丸ゴ Pro","Hiragino Maru Gothic Pro","ヒラギノ角ゴ Pro W3","Hiragino Kaku Gothic Pro","HG丸ｺﾞｼｯｸM-PRO","HGMaruGothicMPRO";
  }

  h1 {
    margin-bottom: 50px;
    text-align: center;
    color: #333;
  }

.container {
    background: #fff;
    padding: 30px 50px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    text-align: center;
    width: 100%;
	box-sizing: border-box; <%-- paddingを含めてワイド100％を計算 --%>
}

  .button-row {
    display: flex;
    gap: 30px;
    flex-wrap: wrap;
    justify-content: center;
  }

  .btn1 {
    display: inline-block;
    padding: 15px 40px;
    background-color: #4CAF50;
    color: white;
    text-decoration: none;
    font-size: 1.2rem;
    border-radius: 8px;
    transition: background-color 0.3s;
  }

  .btn1:hover {
    background-color: #45a049;
  }

  @media screen and (max-width: 400px) {
    .button-row {
      gap: 15px;
    }
</style>