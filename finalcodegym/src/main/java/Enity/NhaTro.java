package Enity;

import java.time.LocalDate;

public class NhaTro {
    private int MaPT ;
   private String NameThue ;
   private String Phone ;
   private String DateRent;
    private String HinhThucThanhToan ;
   private String GhiChu;

    public NhaTro() {
    }

    public NhaTro(int maPT, String nameThue, String phone, String dateRent, String hinhThucThanhToan, String ghiChu) {
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

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        HinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public String getTenChuPhong() {
        return NameThue ;
    }
    public int getMaPhong() {return MaPT ;
    }

}
