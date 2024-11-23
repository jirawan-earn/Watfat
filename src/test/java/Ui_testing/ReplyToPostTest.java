package Ui_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ReplyToPostTest {
    public static void main(String[] args) throws InterruptedException {
        // กำหนดตำแหน่งของไฟล์ ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\_\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // ตั้งค่า ChromeOptions (เช่น ใช้สำหรับการจัดการการเชื่อมต่อที่ไม่ปลอดภัย)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        // เริ่มต้น WebDriver (ChromeDriver)
        WebDriver driver = new ChromeDriver(chromeOptions);

        // ขยายหน้าต่างเบราว์เซอร์ให้เต็มจอ
        driver.manage().window().maximize(); // เปิดเบราว์เซอร์แบบเต็มจอ

        // กำหนด URL ของเว็บไซต์ที่ต้องการทดสอบ
        String baseUrl = "http://45.136.236.146:8081/";

        // เปิดเบราว์เซอร์และไปที่หน้าเว็บ
        driver.get(baseUrl);

        // ค้นหาปุ่ม "Log In" และคลิก
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]/ancestor::button"));
        loginButton.click();

        // หน่วงเวลา 2 วินาทีเพื่อให้คุณเห็นว่าป็อปอัพปรากฏ
        Thread.sleep(2000);

        // ค้นหาช่องกรอก Username และ Password ในป็อปอัพ
        WebElement usernameField = driver.findElement(By.name("identification"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // กรอกข้อมูลลงในฟอร์ม
        String expectedUsername = "u6587101";  // กำหนด username ที่คาดหวัง
        usernameField.sendKeys(expectedUsername);  // กรอก username
        passwordField.sendKeys("Sirilukpus24");  // กรอก password

        // หน่วงเวลา 2 วินาทีเพื่อให้เห็นว่ามีการกรอกข้อมูล
        Thread.sleep(2000);

        // คลิกปุ่ม "Log In" ในป็อปอัพ
        submitButton.click();

        // หน่วงเวลา 3 วินาทีหลังจากการคลิกเพื่อรอให้เข้าสู่ระบบ
        Thread.sleep(3000);

        // -------------------------------------------------------------------------------------------------------------

        // ค้นหาโพสต์ล่าสุดและคลิกที่มัน
        WebElement latestPost = driver.findElement(By.xpath("//a[contains(@class, 'DiscussionListItem-main')][1]"));
        latestPost.click();
        Thread.sleep(2000); // รอให้หน้าโพสต์โหลดเสร็จ

        // ค้นหาและคลิกปุ่ม "Reply" (ตอบกลับ)
        WebElement replyButton = driver.findElement(By.xpath("//button[contains(@class, ' SplitDropdown-button Button Button--primary hasIcon') and .//span[text()='Reply']]"));
        replyButton.click();
        Thread.sleep(2000); // รอให้ฟอร์มตอบกลับแสดงขึ้นมา

        // ค้นหาช่องข้อความสำหรับการตอบกลับ
        WebElement replyContentArea = driver.findElement(By.xpath("//textarea[@class='FormControl Composer-flexible TextEditor-editor' and @placeholder='Write a Reply...']"));
        replyContentArea.sendKeys("This is a reply test."); // กรอกข้อความตอบกลับ
        Thread.sleep(2000);

        // ค้นหาปุ่ม "Post Reply" และคลิก
        WebElement postReplyButton = driver.findElement(By.xpath("//button[contains(@class, 'Button--primary') and contains(@class, 'hasIcon') and @type='button' and .//span[text()='Post Reply']]"));
        postReplyButton.click();
        Thread.sleep(5000); // รอให้โพสต์ตอบกลับแสดงในหน้า

        // ตรวจสอบข้อความในโพสต์ตอบกลับ
        WebElement replyBody = driver.findElement(By.xpath("//div[@class='Post-body']/p"));  // ค้นหาส่วนที่มีข้อความของโพสต์ตอบกลับ
        String replyText = replyBody.getText();  // ดึงข้อความจากโพสต์ตอบกลับ

        // ปิดเบราว์เซอร์
        driver.quit();

        // ตรวจสอบว่าโพสต์ตอบกลับมีข้อความหรือไม่
        if (replyText != null && !replyText.trim().isEmpty()) {
            System.out.println("Reply Test Pass!!!!!");  // หากมีข้อความในโพสต์ตอบกลับแสดงว่าเทสต์ผ่าน
        } else {
            System.out.println("Reply Test Fail: No reply text found!");  // หากไม่มีข้อความในโพสต์ตอบกลับแสดงว่าเทสต์ล้มเหลว
        }
    }
}
