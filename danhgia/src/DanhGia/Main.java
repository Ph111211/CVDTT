package DanhGia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static List<SinhVien> sinhViens = new ArrayList<>();
    private static DoanhNghiep doanhNghiep;
    private static Scanner scanner = new Scanner(System.in);
    private static DatabaseManager dbManager = new DatabaseManager();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ ĐÁNH GIÁ SINH VIÊN ===");
            System.out.println("1. Chọn cách đánh và lưu đánh giá");
            System.out.println("2. Xem đánh giá sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    chooseBuilderAndSave();
                    break;
                case 2:
                    viewDanhGiaForSinhVien();
                    break;
                case 3:
                    shutdown();
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }

    private static void chooseBuilderAndSave() {
        System.out.println("\nChọn đánh giá theo :");
        System.out.println("1.Kỹ năng");
        System.out.println("2.Thái độ");
        System.out.print("Nhập lựa chọn (1 hoặc 2): ");
        int builderChoice = scanner.nextInt();
        scanner.nextLine();

        DanhGiaBuilder builder;
        if (builderChoice == 1) {
            builder = new DanhGiaKyNangBuilder();
        } else if (builderChoice == 2) {
            builder = new DanhGiaThaiDoBuilder();
        } else {
            System.out.println("Lựa chọn không hợp lệ. Sử dụng DanhGiaKyNangBuilder mặc định.");
            builder = new DanhGiaKyNangBuilder();
        }

        doanhNghiep = new DoanhNghiep(builder);

        System.out.print("Nhập MSV để lưu đánh giá: ");
        int sinhVienId = scanner.nextInt();
        scanner.nextLine();

        doanhNghiep.danhGiaSinhVien(sinhVienId);
    }

    private static void viewDanhGiaForSinhVien() {
        Set<Integer> sinhVienIds = dbManager.getAllSinhVienIds();
        if (sinhVienIds.isEmpty()) {
            System.out.println("\nKhông có sinh viên nào trong cơ sở dữ liệu.");
            return;
        }

        System.out.println("\nDanh sách MSV có trong cơ sở dữ liệu:");
        for (Integer id : sinhVienIds) {
            System.out.println("ID: " + id);
        }
        System.out.print("Nhập MSV để xem đánh giá: ");
        int sinhVienId = scanner.nextInt();
        scanner.nextLine();

        if (sinhVienIds.contains(sinhVienId)) {
            DanhGia danhGia = dbManager.getLatestDanhGiaById(sinhVienId);
            if (danhGia != null) {
                System.out.println("\nĐánh giá cho sinh viên ID " + sinhVienId + ":\n" + danhGia);
            } else {
                System.out.println("Không có đánh giá nào cho sinh viên ID " + sinhVienId + ".");
            }
        } else {
            System.out.println("MSV " + sinhVienId + " không tồn tại trong cơ sở dữ liệu.");
        }
    }

    private static void shutdown() {
        for (SinhVien sv : sinhViens) {
            sv.shutdown();
        }
        if (doanhNghiep != null) {
            doanhNghiep.shutdown();
        }
        dbManager.close();
        scanner.close();
    }
}