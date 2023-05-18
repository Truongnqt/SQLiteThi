package com.example.sqlitethi;

public class ModelTaxi {
    int Id;
    String soxe;
    float quangduong;
    float dongia;
    float khuyenmai;

    public ModelTaxi(int Id,String soxe, float quangduong, float dongia, float khuyenmai) {
        this.Id=Id;
        this.soxe = soxe;
        this.quangduong = quangduong;
        this.dongia = dongia;
        this.khuyenmai = khuyenmai;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSoxe() {
        return soxe;
    }

    public void setSoxe(String soxe) {
        this.soxe = soxe;
    }

    public float getQuangduong() {
        return quangduong;
    }

    public void setQuangduong(float quangduong) {
        this.quangduong = quangduong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(float khuyenmai) {
        this.khuyenmai = khuyenmai;
    }
    public float getGia(){
        return quangduong*dongia*(100-khuyenmai)/100;
    }
}
