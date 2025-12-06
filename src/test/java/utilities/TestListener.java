/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener; 
import org.testng.ITestResult;
/**
 *
 * @author Nhật Long
 */
public class TestListener implements ITestListener {

    // Gọi Instance từ ExtentManager
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName())
                .assignCategory(result.getTestClass().getRealClass().getSimpleName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (test.get() != null) {
            String logText = "<b>" + result.getMethod().getMethodName() + " thành công (PASSED).</b>";
            test.get().log(Status.PASS, MarkupHelper.createLabel(logText, ExtentColor.GREEN));
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (test.get() != null) {
            String logText = "<b>" + result.getMethod().getMethodName() + " thất bại (FAILED).</b>";
            test.get().log(Status.FAIL, MarkupHelper.createLabel(logText, ExtentColor.RED));
            test.get().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (test.get() != null) {
            String logText = "<b>" + result.getMethod().getMethodName() + " bị bỏ qua (SKIPPED).</b>";
            test.get().log(Status.SKIP, MarkupHelper.createLabel(logText, ExtentColor.YELLOW));
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}