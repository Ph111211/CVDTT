import java.util.List;
public class PhanCongContext {
    private PhanCongStrategy strategy;

    public void setStrategy(PhanCongStrategy strategy) {
        this.strategy = strategy;
    }

    public void thucHienPhanCong(List<GiangVien> giangViens, List<SinhVienDoAn> sinhViens) {
        if (strategy != null) {
            strategy.phanCong(giangViens, sinhViens);
        } else {
            System.out.println("Chưa thiết lập chiến lược phân công!");
        }
    }
}
