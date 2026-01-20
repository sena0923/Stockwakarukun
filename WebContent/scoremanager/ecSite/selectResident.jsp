<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>入居者選択</title>
    <style>
        body { font-family: sans-serif; }
        .box {
            width: 400px;
            margin: 40px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        .resident {
            padding: 10px;
            margin-bottom: 10px;
            border-bottom: 1px solid #ddd;
        }
        .select-btn {
            background-color: #4CAF50;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .select-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>

<div class="box">
    <h2>入居者を選択してください</h2>

    <c:if test="${empty residentList}">
        <p>紐づく入居者が登録されていません。</p>
    </c:if>

    <c:forEach var="r" items="${residentList}">
        <div class="resident">
            <p><strong>${r.name}</strong>（ID: ${r.rd_id}）</p>

            <!-- SelectResidentAction に rd_id を渡す -->
            <form action="SelectResident.action" method="post">
                <input type="hidden" name="rd_id" value="${r.rd_id}">
                <button type="submit" class="select-btn">この入居者を選択</button>
            </form>
        </div>
    </c:forEach>

</div>

</body>
</html>