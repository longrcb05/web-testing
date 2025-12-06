/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
/**
 *
 * @author Nhật Long
 */
public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        // Tạo thư mục nếu chưa có
        String path = System.getProperty("user.dir") + "/test-output";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Đường dẫn file report
        String fileName = path + "/ExtentReport.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

        // Cấu hình giao diện
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Báo Cáo Kiểm Thử Tự Động OrangeHRM");
        htmlReporter.config().setReportName("Kết Quả Chạy Test Suite");
        htmlReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Thêm thông tin hệ thống
        extent.setSystemInfo("Người thực hiện", "Nhật Long");
        extent.setSystemInfo("Dự án", "OrangeHRM Automation");
        extent.setSystemInfo("Phương pháp Test", "Page Object Model (POM)");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }
}
