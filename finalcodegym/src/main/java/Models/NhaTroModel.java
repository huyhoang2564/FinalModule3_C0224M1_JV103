package Models;

import java.time.LocalDate;

public class NhaTroModel {
    private int MaPT ;
    private String NameThue ;
    private String Phone ;
    private String DateRent;
    private int HinhThucThanhToan ;
    private String GhiChu;

    public NhaTroModel() {
    }

    public NhaTroModel(int maPT, String nameThue, String phone, String dateRent, int hinhThucThanhToan, String ghiChu) {
        MaPT = maPT;
        NameThue = nameThue;
        Phone = phone;
        DateRent = dateRent;
        HinhThucThanhToan = hinhThucThanhToan;
        GhiChu = ghiChu;
    }

    public int getMaPT() {
        return MaPT;
    }

    public void setMaPT(int maPT) {
        MaPT = maPT;
    }

    public String getNameThue() {
        return NameThue;
    }

    public void setNameThue(String nameThue) {
        NameThue = nameThue;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDateRent() {
        return DateRent;
    }

    public void setDateRent(String dateRent) {
        DateRent = dateRent;
    }

    public int getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        HinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }
}
