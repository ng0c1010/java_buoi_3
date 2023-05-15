package baii2;

public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }
    public abstract String tinhMucDoBanBuon();

    @Override
    public String toString() {
        return "Mã hàng: " + maHang + ", Tên hàng: " + tenHang + ", Số lượng tồn: " + soLuongTon + ", Đơn giá: " + donGia;
    }
}

