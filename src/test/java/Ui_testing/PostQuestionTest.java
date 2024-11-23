package Ui_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PostQuestionTest {
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

        // กรอกข้อมูลลงในฟอร์ม
        String expectedUsername = "u6587042";  // กำหนด username ที่คาดหวัง
        usernameField.sendKeys(expectedUsername);  // กรอก username
        passwordField.sendKeys("Wat094926");  // กรอก password

        // หน่วงเวลา 2 วินาทีเพื่อให้เห็นว่ามีการกรอกข้อมูล
        Thread.sleep(2000);

        // คลิกปุ่ม "Log In" ในป็อปอัพ
        submitButton.click();

        // หน่วงเวลา 3 วินาทีหลังจากการคลิก
        Thread.sleep(3000);

        // -------------------------------------------------------------------------------------------------------------

        // ค้นหาและคลิกปุ่ม "Start a Discussion"
        WebElement discussionButton = driver.findElement(By.xpath("//button[contains(@class, 'Button--primary') and contains(@class, 'IndexPage-newDiscussion') and @type='button']"));
        discussionButton.click();
        Thread.sleep(2000);

        // ค้นหาและกรอกข้อความในช่อง "Discussion Title"
        WebElement discussionTitle = driver.findElement(By.xpath("//input[@class='FormControl' and @placeholder='Discussion Title']"));
        String postTitle = "Test Post";  // กำหนดข้อความที่กรอกในชื่อโพสต์
        discussionTitle.sendKeys(postTitle);  // กรอกข้อความ "Test Post"
        Thread.sleep(2000);

        // ค้นหาและกรอกข้อความในช่อง <textarea>
        WebElement postContentArea = driver.findElement(By.xpath("//textarea[@class='FormControl Composer-flexible TextEditor-editor' and @placeholder='Write a Post...']"));
        String postContent = "Test Post";  // กำหนดข้อความที่กรอกในเนื้อหาโพสต์
        postContentArea.sendKeys(postContent);  // กรอกข้อความ "Test Post"
        Thread.sleep(2000);

        // คลิกปุ่ม "Choose Tags"
        WebElement chooseTagsButton = driver.findElement(By.xpath("//span[@class='TagLabel untagged']"));
        chooseTagsButton.click();
        Thread.sleep(2000);

        // เลือก Tag (ไอคอนที่มีคลาส "TagIcon")
        WebElement tagIcon = driver.findElement(By.xpath("//span[@class='icon TagIcon']"));
        tagIcon.click();
        Thread.sleep(2000);

        // หาปุ่ม Ok
        WebElement okButton = driver.findElement(By.xpath("//button[@type='submit']"));
        okButton.click();
        Thread.sleep(2000);

        // คลิกปุ่มโพสต์สุดท้าย
        WebElement finalPostButton = driver.findElement(By.xpath("//button[@class='Button Button--primary hasIcon' and @type='button']"));
        finalPostButton.click();
        Thread.sleep(4000); // รอให้โพสต์แสดงผลในหน้า

        // ตรวจสอบข้อความในโพสต์
        WebElement postBody = driver.findElement(By.xpath("//div[@class='Post-body']/p"));  // ค้นหาส่วนที่มีข้อความของโพสต์
        String postText = postBody.getText();  // ดึงข้อความจากโพสต์

        // ปิดเบราว์เซอร์
        driver.quit();

        // ตรวจสอบว่าข้อความในโพสต์ตรงกับที่กรอกหรือไม่
        if (postTitle.equals(postText) && postContent.equals(postText)) {
            System.out.println("Post Test Pass!!!!!");  // หากข้อความตรง ให้พิมพ์ "Test Pass!"
        } else {
            System.out.println("Post Test Fail: Expected '" + postTitle + " - " + postContent + "' but found '" + postText + "'");  // หากข้อความไม่ตรง แจ้งว่าไม่ผ่าน
        }
    }
}
