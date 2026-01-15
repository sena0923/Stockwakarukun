<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../baseSin.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">

<!-- ===== メインコンテンツ ===== -->
<main>




  <div class="mainmenu">
    <ul>

		<c:if test="${hasExpiredProduct}">
		  <!-- 背景 -->
		  <div id="modal-overlay"></div>

		  <!-- ダイアログ本体 -->
		  <div id="message-dialog">
			<div class="dialog-body blink-text">
			  ⚠ 購入から8カ月経過した商品があります。<br>
			</div>
		    <div class="dialog-footer">
		      <button type="button" onclick="closeDialog()">OK</button>
		    </div>
		  </div>
		</c:if>

      <li><a href="Sin_stockList.action?rt_id=${relatives.rt_id}">備品管理</a></li>
      <li><a href="../ECsite/AllsinExecute.action">購入</a></li>
      <li><a href="${pageContext.request.contextPath}/scoremanager/relatives/Sin_conList.action">連絡帳</a></li>
      <li><a href="SinDisplayExecute.action?rt_id=${relatives.rt_id}">マイぺージ</a></li>
      <li><a href="./rtLogoutCon.jsp">ログアウト</a></li>
    </ul>
  </div>

</main>

<!-- ===== JavaScript ===== -->
<script>
function closeDialog() {
  document.getElementById("message-dialog").style.display = "none";
  document.getElementById("modal-overlay").style.display = "none";
}
</script>
