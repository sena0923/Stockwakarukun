<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    // フォームからの入力値を取得
    String loginId = request.getParameter("login-id");
    String password = request.getParameter("password");

    if(loginId == null || password == null || loginId.isEmpty() || password.isEmpty()) {
        request.setAttribute("errorMessage", "ログインIDとパスワードを入力してください。");
        request.getRequestDispatcher("親族ログイン.jsp").forward(request, response);
        return;
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // H2 JDBCドライバ読み込み
        Class.forName("org.h2.Driver");

        // データベース接続 (DBファイルの場所に応じて変更)
        conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        // SQLでログイン情報をチェック
        String sql = "SELECT * FROM relatives WHERE login_id = ? AND password = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, loginId);
        ps.setString(2, password);

        rs = ps.executeQuery();

        if(rs.next()) {
            // ログイン成功
            session.setAttribute("loginId", loginId); // セッションにユーザーIDを保存
            response.sendRedirect("親族ホーム.jsp"); // ホームページへ遷移
        } else {
            // ログイン失敗
            request.setAttribute("errorMessage", "ログインIDまたはパスワードが正しくありません。");
            request.getRequestDispatcher("親族ログイン.jsp").forward(request, response);
        }

    } catch(Exception e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", "システムエラーが発生しました。");
        request.getRequestDispatcher("親族ログイン.jsp").forward(request, response);
    } finally {
        try { if(rs != null) rs.close(); } catch(Exception e) {}
        try { if(ps != null) ps.close(); } catch(Exception e) {}
        try { if(conn != null) conn.close(); } catch(Exception e) {}
    }
%>
