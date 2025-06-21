package DanhGia;

public class DanhGia {
    public String kyNang;
    public String thaiDo;
    public String noiDungKhac;

    @Override
    public String toString() {
        return "Đánh giá:\n- Kỹ năng: " + kyNang + "\n- Thái độ: " + thaiDo + "\n- Nội dung khác: " + noiDungKhac;
    }
}
