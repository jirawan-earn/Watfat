import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // Set up the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atiwa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Set Chrome options (if needed, for example to handle insecure connections)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        // Initialize the WebDriver (ChromeDriver)
        WebDriver driver = new ChromeDriver(chromeOptions);

        // URL ของเว็บไซต์ที่ต้องการทดสอบ
        String baseUrl = "http://45.136.236.146:8081/";

        // เปิดเบราว์เซอร์และไปที่หน้าเว็บ
        driver.get(baseUrl);

        // ค้นหาปุ่ม "Log In" และคลิก
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]/ancestor::button"));
        loginButton.click();

        // หน่วงเวลา 2 วินาทีเพื่อให้คุณเห็นว่าป็อปอัพปรากฏ
        Thread.sleep(3000);

        // ค้นหาช่องกรอก Username และ Password ในป็อปอัพ
        WebElement usernameField = driver.findElement(By.name("identification"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // กรอกข้อมูลลงในฟอร์ม
        usernameField.sendKeys("u6587042");  // กรอก username
        passwordField.sendKeys("Wat094926");  // กรอก password

        // หน่วงเวลา 2 วินาทีเพื่อให้เห็นว่ามีการกรอกข้อมูล
        Thread.sleep(3000);

        // คลิกปุ่ม "Log In" ในป็อปอัพ
        submitButton.click();

        // หน่วงเวลา 2 วินาทีหลังจากการคลิก
        Thread.sleep(3000);

        // ตรวจสอบว่า username ที่แสดงในหน้าเว็บตรงกับที่กรอกไปหรือไม่
        WebElement usernameDisplay = driver.findElement(By.xpath("//span[@class='username']"));
        String displayedUsername = usernameDisplay.getText();

        if (displayedUsername.equals("u6587042")) {
            System.out.println("Login Test Passed! Username is correct: " + displayedUsername);
        } else {
            System.out.println("Login Test Failed! Expected username: u6587042, but found: " + displayedUsername);
        }

        // ปิดเบราว์เซอร์
        driver.quit();
    }
}
