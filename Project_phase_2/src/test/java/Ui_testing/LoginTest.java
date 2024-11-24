package Ui_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // กำหนดพาธของ ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\_\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // ตั้งค่า Chrome options (หากจำเป็น เช่น การจัดการกับการเชื่อมต่อที่ไม่ปลอดภัย)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        // สร้าง WebDriver (ChromeDriver)
        WebDriver driver = new ChromeDriver(chromeOptions);

        // เปิดเบราว์เซอร์แบบเต็มจอ
        driver.manage().window().maximize(); // เปิดเบราว์เซอร์ในโหมดเต็มจอ

        // URL ของเว็บไซต์ที่ต้องการทดสอบ
        String baseUrl = "http://45.136.236.146:8081/";

        // เปิดเบราว์เซอร์และไปที่หน้าเว็บ
        driver.get(baseUrl);

        // ค้นหาปุ่ม "Log In" และคลิก
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]/ancestor::button"));
        loginButton.click();

        // หน่วงเวลา 2 วินาทีเพื่อให้เห็นว่าป็อปอัพปรากฏ
        Thread.sleep(2000);

        // ค้นหาช่องกรอก Username และ Password ในป็อปอัพ
        WebElement usernameField = driver.findElement(By.name("identification"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // กำหนดค่า username ที่คาดหวัง และกรอกข้อมูลลงในฟอร์ม
        String expectedUsername = "u6587042";  // กำหนด username ที่คาดหวัง
        usernameField.sendKeys(expectedUsername);  // กรอก username
        passwordField.sendKeys("Wat094926");  // กรอก password

        // หน่วงเวลา 2 วินาทีเพื่อให้เห็นว่ามีการกรอกข้อมูล
        Thread.sleep(2000);

        // คลิกปุ่ม "Log In" ในป็อปอัพ
        submitButton.click();

        // หน่วงเวลา 3 วินาทีหลังจากการคลิก
        Thread.sleep(3000);

        // ค้นหาและดึงข้อมูล username ที่แสดงในหน้าเว็บ
        WebElement usernameDisplay = driver.findElement(By.xpath("//span[@class='username']"));
        String displayedUsername = usernameDisplay.getText();

        // ปิดเบราว์เซอร์หลังจากทดสอบเสร็จ
        driver.quit();

        // เปรียบเทียบ username ที่แสดงผลกับ username ที่กรอกไป
        if (displayedUsername.equals(expectedUsername)) {
            System.out.println("Login Test Passed! Username is correct: " + displayedUsername);
        } else {
            System.out.println("Login Test Failed! Expected username: " + expectedUsername + ", but found: " + displayedUsername);
        }
    }
}
