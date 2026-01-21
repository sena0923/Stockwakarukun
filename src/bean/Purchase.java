package bean;

import java.sql.Timestamp;
import java.util.List;

public class Purchase {

    private String purchaseId;                 // purchase_id（String）
    private Timestamp purchaseDate;            // 購入日時
    private List<PurchaseDetail> details;  // 購入詳細リスト

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<PurchaseDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PurchaseDetail> details) {
        this.details = details;
    }
}