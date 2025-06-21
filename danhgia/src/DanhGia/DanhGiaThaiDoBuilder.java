package DanhGia;

public class DanhGiaThaiDoBuilder implements DanhGiaBuilder {
    private DanhGia danhGia;

    public DanhGiaThaiDoBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        danhGia = new DanhGia();
    }

    @Override
    public void buildKyNang() {
        danhGia.kyNang = "Kỹ năng cơ bản";
    }

    @Override
    public void buildThaiDo() {
        danhGia.thaiDo = "Thái độ rất tốt, năng động";
    }

    @Override
    public void buildNoiDungKhac() {
        danhGia.noiDungKhac = "Có tinh thần học hỏi và cải thiện";
    }

    public DanhGia getResult() {
        return danhGia;
    }
}
