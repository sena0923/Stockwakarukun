package scoremanager.ECsite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.PurchaseDao;
import Dao.PurchaseDetailDao;
import bean.Purchase;
import bean.PurchaseDetail;
import bean.Resident;
import tool.Action;

public class PurchaseHistoryAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

    	int e = 0;
    	System.out.println("debug:PurchaseHistoryAction:" + ++e);
        HttpSession session = req.getSession();

        // 入居者本人 or 親族が選んだ入居者
        Resident resident = (Resident) session.getAttribute("resident");
        Resident selected = (Resident) session.getAttribute("selectedResident");

        // rd_id は String のまま扱う
        String residentId = null;

        System.out.println("debug:PurchaseHistoryAction:" + ++e);

        if (selected != null) {
            residentId = selected.getRd_id();
        } else if (resident != null) {
            residentId = resident.getRd_id();
        }

    	System.out.println("debug:PurchaseHistoryAction:" + ++e);

        // rd_id が取れなければ履歴なし
        if (residentId == null) {
            req.setAttribute("purchaseList", null);
            req.getRequestDispatcher("../ecSite/PurchaseHistory.jsp").forward(req, res);
            return;
        }


    	System.out.println("debug:PurchaseHistoryAction:" + ++e);


        // 購入履歴を取得
        PurchaseDao purchaseDao = new PurchaseDao();
        List<Purchase> purchaseList = purchaseDao.findByResident(residentId);

    	System.out.println("debug:PurchaseHistoryAction:" + ++e);


        // 各購入に購入詳細をセット
        PurchaseDetailDao detailDao = new PurchaseDetailDao();
        for (Purchase p : purchaseList) {
            List<PurchaseDetail> details = detailDao.findByPurchaseId(p.getPurchaseId());
            p.setDetails(details);
        }

    	System.out.println("debug:PurchaseHistoryAction:" + ++e);



        // JSP に渡す
        req.setAttribute("purchaseList", purchaseList);

        req.getRequestDispatcher("../ecSite/PurchaseHistory.jsp").forward(req, res);
    }
}