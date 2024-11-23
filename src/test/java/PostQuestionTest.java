import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PostQuestionTest {
    public static void main(String[] args) throws InterruptedException {
        // ตั้งค่า ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atiwa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // กำหนดตัวเลือกของ Chrome (ในกรณีที่ต้องการ)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        // สร้าง WebDriver เพื่อใช้ควบคุม Chrome
        WebDriver driver = new ChromeDriver(chromeOptions);


            // เปิดเว็บไซต์
            String baseUrl = "http://45.136.236.146:8081/";
            driver.get(baseUrl);

            // ค้นหาและคลิกปุ่ม "Log In"
            WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]/ancestor::button"));
            loginButton.click();
            Thread.sleep(2000); // รอให้หน้าโหลด

            // กรอก Username และ Password
            WebElement usernameField = driver.findElement(By.name("identification"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

            usernameField.sendKeys("u6587042");  // กรอกชื่อผู้ใช้งาน
            passwordField.sendKeys("Wat094926");  // กรอกรหัสผ่าน
            Thread.sleep(3000); // หน่วงเวลาให้เห็นการกรอก

            // คลิกปุ่ม "Log In"
            submitButton.click();
            Thread.sleep(5000); // รอให้ระบบล็อกอินสำเร็จ

            // ค้นหาและคลิกปุ่ม "Start a Discussion"
            WebElement discussionButton = driver.findElement(By.xpath("//button[contains(@class, 'Button--primary') and contains(@class, 'IndexPage-newDiscussion') and @type='button']"));
            discussionButton.click();
            Thread.sleep(3000);

            // ค้นหาและกรอกข้อความในช่อง "Discussion Title"
            WebElement discussionTitle = driver.findElement(By.xpath("//input[@class='FormControl' and @placeholder='Discussion Title']"));
            discussionTitle.sendKeys("Test");  // กรอกข้อความ "Test"
            Thread.sleep(3000);

            // ค้นหาและกรอกข้อความในช่อง <textarea>
            WebElement postContentArea = driver.findElement(By.xpath("//textarea[@class='FormControl Composer-flexible TextEditor-editor' and @placeholder='Write a Post...']"));
            postContentArea.sendKeys("Test Post");  // กรอกข้อความ "Test Post"
            Thread.sleep(3000);

            // คลิกปุ่ม "Choose Tages"
            WebElement ChooseTagesButton = driver.findElement(By.xpath("//span[@class='TagLabel untagged']"));
            ChooseTagesButton.click();
            Thread.sleep(3000);

            // เลือก Tag (ไอคอนที่มีคลาส "TagIcon")
            WebElement tagIcon = driver.findElement(By.xpath("//span[@class='icon TagIcon']"));
            tagIcon.click();
            Thread.sleep(3000);

            // หาปุ่ม Ok
            WebElement OKicon = driver.findElement(By.xpath("//button[@type='submit']"));
            OKicon.click();
            Thread.sleep(3000);

            // คลิกปุ่มโพสต์สุดท้าย
            WebElement finalPostButton = driver.findElement(By.xpath("//button[@class='Button Button--primary hasIcon' and @type='button']"));
            finalPostButton.click();
            Thread.sleep(5000); // รอให้โพสต์แสดงผลในหน้า

            // ตรวจสอบข้อความในโพสต์
            WebElement postBody = driver.findElement(By.xpath("//div[@class='Post-body']/p"));  // ค้นหาส่วนที่มีข้อความของโพสต์
            String postText = postBody.getText();  // ดึงข้อความจากโพสต์

            // ตรวจสอบว่าข้อความในโพสต์ตรงกับที่กรอกหรือไม่
            if ("Test Post".equals(postText)) {
                System.out.println("Test Pass!");  // หากข้อความตรง ให้พิมพ์ "Test Pass!"
            } else {
                System.out.println("Test Fail: Expected 'Test Post' but found '" + postText + "'");  // หากข้อความไม่ตรง แจ้งว่าไม่ผ่าน
            }

            //กดปุ่ม Dropdown <3
// ค้นหาและคลิกปุ่มที่ระบุ
        WebElement dropdownButton = driver.findElement(By.xpath("//button[contains(@class, 'Dropdown-toggle') and contains(@class, 'Button--icon') and contains(@class, 'Button--primary') and @aria-haspopup='menu']"));
        dropdownButton.click(); // คลิกปุ่ม
        Thread.sleep(3000); // รอ 3 วินาทีเพื่อให้การคลิกทำงาน


    }
}