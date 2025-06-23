import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Report {
    private String studentId;
    private String fileName;
    private long fileSize; // bytes
    private String fileType;

    public Report(String studentId, String fileName, long fileSize, String fileType) {
        this.studentId = studentId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public String getStudentId() { return studentId; }
    public String getFileName() { return fileName; }
    public long getFileSize() { return fileSize; }
    public String getFileType() { return fileType; }
}

interface ReportStrategy {
    boolean validate(Report report);
    String getErrorMessage();
}

class FormatStrategy implements ReportStrategy {
    private String error = "";

    @Override
    public boolean validate(Report report) {
        String type = report.getFileType().toLowerCase();
        if (!type.equals("pdf") && !type.equals("docx")) {
            error = "Sai định dạng file. Chỉ chấp nhận PDF hoặc DOCX.";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return error;
    }
}

class SizeStrategy implements ReportStrategy {
    private static final long MAX_SIZE = 5 * 1024 * 1024; // 5MB
    private String error = "";

    @Override
    public boolean validate(Report report) {
        if (report.getFileSize() > MAX_SIZE) {
            error = "Dung lượng vượt quá giới hạn cho phép (5MB).";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return error;
    }
}


 class ReportService {
    private List<ReportStrategy> strategies;

    public ReportService(List<ReportStrategy> strategies) {
        this.strategies = strategies;
    }

    public boolean submitReport(Report report) {
        System.out.println("Bắt đầu kiểm tra báo cáo cho sinh viên: " + report.getStudentId());

        for (ReportStrategy strategy : strategies) {
            if (!strategy.validate(report)) {
                System.out.println("❌ Nộp báo cáo thất bại: " + strategy.getErrorMessage());
                return false;
            }
        }

        System.out.println("✅ Báo cáo '" + report.getFileName() + "' đã được nộp thành công.");
        System.out.println("📩 Hệ thống đã thông báo cho giảng viên hướng dẫn.");
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        Report report = new Report("SV001", "BaoCaoThucTap.pdf", 3 * 1024 * 1024, "pdf");

        ReportStrategy formatCheck = new FormatStrategy();
        ReportStrategy sizeCheck = new SizeStrategy();

        ReportService service = new ReportService(Arrays.asList(formatCheck, sizeCheck));
        service.submitReport(report); // <-- Client gọi hành vi của Context
    }
}
