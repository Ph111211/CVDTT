package DanhGia;

import java.util.Scanner;

public class DanhGiaKyNangBuilder implements DanhGiaBuilder {
    private DanhGia danhGia;
    private Scanner scanner;

    public DanhGiaKyNangBuilder() {
        this.reset();
        scanner = new Scanner(System.in);
    }

    @Override
    public void reset() {
        danhGia = new DanhGia();
    }

    @Override
    public void buildKyNang() {
        System.out.print("Nhập đánh giá kỹ năng: ");
        danhGia.kyNang = scanner.nextLine();
    }

    @Override
    public void buildThaiDo() {
        danhGia.thaiDo = "Không có";
    }

    @Override
    public void buildNoiDungKhac() {
        System.out.print("Nhập nội dung đánh giá khác: ");
        danhGia.noiDungKhac = scanner.nextLine();
    }

    public DanhGia getResult() {
        return danhGia;
    }
}
