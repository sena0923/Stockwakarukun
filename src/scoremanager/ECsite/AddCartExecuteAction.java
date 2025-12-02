package scoremanager.ECsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CartDao;
import bean.Cart;
import tool.Action;

public class AddCartExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
            // H2への接続（メモリDB）
            conn = DriverManager.getConnection(
                "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");


			// DAO生成
	        CartDao cartDao = new CartDao(conn);

	        // Cartオブジェクト生成
	        Cart cart = new Cart();
	        cart.setCourse_id("C001");
	        cart.setRd_id("R001");
	        cart.setGoods_id("G001");
	        cart.setQuantity(2);
	        cart.setPrice(500);

	        // DB保存
	        cartDao.addItem(cart);

	        System.out.println("カートに商品を追加しました！");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	        }
	    }
	}
}


