package DanhGia;

import java.util.Scanner;

public class DanhGiaThaiDoBuilder implements DanhGiaBuilder {
    private DanhGia danhGia;
    private Scanner scanner;

    public DanhGiaThaiDoBuilder() {
        this.reset();
        scanner = new Scanner(System.in);
    }

    @Override
    public void reset() {
        danhGia = new DanhGia();
    }

    @Override
    public void buildKyNang() {
        danhGia.kyNang = "Chưa đánh giá";
    }

    @Override
    public void buildThaiDo() {
        System.out.print("Nhập đánh giá thái độ: ");
        danhGia.thaiDo = scanner.nextLine();    }

    @Override
    public void buildNoiDungKhac() {
        System.out.print("Nhập nội dung đánh giá khác: ");
        danhGia.noiDungKhac = scanner.nextLine();    }

    public DanhGia getResult() {
        return danhGia;
    }
}
