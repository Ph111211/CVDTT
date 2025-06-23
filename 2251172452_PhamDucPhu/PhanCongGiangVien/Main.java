import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<GiangVien> gvList = Arrays.asList(
            new GiangVien("GV01", "Thầy A"),
            new GiangVien("GV02", "Thầy B")
        );

        List<SinhVienDoAn> svList = Arrays.asList(
            new SinhVienDoAn("SV01", "Nam", "AI"),
            new SinhVienDoAn("SV02", "Ha", "Web"),
            new SinhVienDoAn("SV03", "Trang", "IoT"),
            new SinhVienDoAn("SV04", "Minh", "Blockchain"),
            new SinhVienDoAn("SV05", "Linh", "Mobile"),
            new SinhVienDoAn("SV06", "Tu", "Big Data"),
            new SinhVienDoAn("SV07", "Duc", "Cloud"),
            new SinhVienDoAn("SV08", "Phuc", "Game"),
            new SinhVienDoAn("SV09", "Nhi", "ML")
        );

        PhanCongContext context = new PhanCongContext();
        context.setStrategy(new PhanCongToiDa7Strategy());
        context.thucHienPhanCong(gvList, svList);
        // context.setStrategy(new PhanCongNgauNhienStrategy());
// context.setStrategy(new PhanCongVongTronStrategy());
// context.setStrategy(new PhanCongItNhatStrategy());

// context.thucHienPhanCong(gvList, svList);

        // In thông tin kết quả
        for (SinhVienDoAn sv : svList) {
            System.out.println(sv.getThongTin());
        }
    }
}
