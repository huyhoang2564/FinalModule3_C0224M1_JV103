package Models;

public class PhuongThucThanhToanModel {
    private int id;
    private String phuongThucThanhToan;

    public PhuongThucThanhToanModel() {
    }

    public PhuongThucThanhToanModel(int id, String phuongThucThanhToan) {
        this.id = id;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
}
