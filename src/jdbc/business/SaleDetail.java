package jdbc.business;

public class SaleDetail {
    private long saleId;
    private long videoGameId;
    private int quantity;

    public SaleDetail(long saleId, long videoGameId, int quantity) {
        this.saleId = saleId;
        this.videoGameId = videoGameId;
        this.quantity = quantity;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public long getVideoGameId() {
        return videoGameId;
    }

    public void setVideoGameId(long videoGameId) {
        this.videoGameId = videoGameId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleDetail{" +
                "saleId=" + saleId +
                ", videoGameId=" + videoGameId +
                ", quantity=" + quantity +
                '}';
    }
}
