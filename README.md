# Đồ án nhóm: Xây dựng Framework kiểm thử tự động cho Website OrangeHRM
- Nhóm SVTH: Nguyễn Nhật Long - Trần Nguyễn Quốc Huy - Nguyễn Văn Trường
- GVHD: Nguyễn Trung Thuận

Dự án kiểm thử tự động (Automation Test) cho trang web quản lý nhân sự **OrangeHRM** (Phiên bản Open Source).
Dự án được xây dựng dựa trên ngôn ngữ **Java**, thư viện **Selenium WebDriver** và framework **TestNG**, áp dụng mô hình thiết kế **Page Object Model (POM)** để tối ưu hóa việc bảo trì và mở rộng code.

## 🚀 Công nghệ sử dụng

* **Ngôn ngữ:** Java
* **Core Library:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **IDE:** NetBeans
* **Browser:** Google Chrome

---

## 🏗️ Cấu trúc dự án

Dự án tuân thủ nghiêm ngặt mô hình **Page Object Model (POM)** kết hợp với **Modular Testing**:

* **`pages/`**: Chứa các Class đại diện cho từng trang (Page) của ứng dụng. Nơi lưu trữ **Locators** và các **Actions** (hành động) cụ thể.
* **`tests/`**: Chứa các Class kiểm thử (Test Cases). Chỉ chứa logic test, xác thực (Assert), không chứa code tìm kiếm phần tử trực tiếp.
* **`BaseTest`**: Class cha quản lý việc khởi tạo (`setup`) và đóng trình duyệt (`tearDown`).

### Cấu trúc thư mục:
    └── Test Packages
        ├── pages           # --- PAGE OBJECTS ---
        │   ├── LoginPage.java
        │   ├── DashboardPage.java
        │   ├── AdminPage.java
        │   ├── PIMPage.java
        │   ├── LeavePage.java
        │   ├── RecruitmentPage.java
        │   ├── MyInfoPage.java
        │   ├── MaintenancePage.java
        │   ├── DirectoryPage.java
        │   ├── TimePage.java
        │   ├── PerformancePage.java
        │   ├── ClaimPage.java
        │   ├── BuzzPage.java
        │   └── UserMenuPage.java
        │
        └── tests           # --- TEST CASES ---
            ├── BaseTest.java        <-- Cấu hình Driver & Wait
            ├── LoginTest.java
            ├── DashboardTest.java
            ├── AdminTest.java
            ├── PIMTest.java
            ├── LeaveTest.java
            ├── RecruitmentTest.java
            ├── MyInfoTest.java
            ├── FullMenuTest.java
            └── UserMenuTest.java
