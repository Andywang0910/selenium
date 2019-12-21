import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangchao
 * @create 2019/12/21 0021 10:27
 */
public class ChromeDriverTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        // 设置谷歌浏览器的驱动
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        // 启动谷歌浏览器
        driver = new ChromeDriver();
        // 设置默认超时时间
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        // 关闭谷歌浏览器
        driver.quit();
    }

    @Test
    public void test222() throws Exception {
        // 打开百度首页
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
    }

}
