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

        HttpSession session = req.getSession();

        // 入居者本人 or 親族が選んだ入居者
        Resident resident = (Resident) session.getAttribute("resident");
        Resident selected = (Resident) session.getAttribute("selectedResident");

        // rd_id を String のまま扱う
        String residentId = null;

        if (selected != null) {
            residentId = selected.getRd_id();   // String のまま
        } else if (resident != null) {
            residentId = resident.getRd_id();   // String のまま
        }

        // DAO 呼び出し（String のまま渡す）
        PurchaseDao purchaseDao = new PurchaseDao();
        List<Purchase> purchaseList = purchaseDao.findByResident(residentId);

        // 購入詳細もセットする
        PurchaseDetailDao detailDao = new PurchaseDetailDao();
        for (Purchase p : purchaseList) {
            List<PurchaseDetail> details = detailDao.findByPurchaseId(p.getPurchaseId());
            p.setDetails(details);
        }

        req.setAttribute("purchaseList", purchaseList);

        req.getRequestDispatcher("../ecSite/PurchaseHistory.jsp").forward(req, res);
    }
}