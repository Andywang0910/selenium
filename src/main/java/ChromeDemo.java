import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangchao
 * @create 2019/12/21 0021 11:59
 */
public class ChromeDemo {

    public static void main(String[] args) {
        // 设置基础参数
        String url = "http://www.baidu.com";
        String title = "百度一下，你就知道";
        String tiebaTitle = "百度贴吧——全球最大的中文社区";

        // 设置chrome驱动
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

        // 初始化chrome，设置超时时间、清除缓存、窗口最大化
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();

        // 打开网页，检查是否正常跳转
        try {
            webDriver.get(url);
            Thread.sleep(1000);
            if (title.equals(webDriver.getTitle())) {
                System.out.println("网页打开正确");
            } else {
                System.out.println("网页打开错误");
            }
        } catch (Exception e) {
            System.out.println("打开过程出现异常");
        }

        // 进入贴吧
        try {
            webDriver.findElement(By.xpath("//*[@href='http://tieba.baidu.com']")).click();
            Thread.sleep(1000);
            if (tiebaTitle.equals(webDriver.getTitle())) {
                System.out.println("进入贴吧成功");
            } else {
                System.out.println("进入贴吧失败");
            }
        } catch (Exception e) {
            System.out.println("点击过程中出现异常");
        }

        // 单击搜索框显示热门搜索
        try {
            WebElement searchEl = webDriver.findElement(By.xpath("//*[@id=\"wd1\"]"));
            searchEl.click();
            Thread.sleep(1000);
            searchEl.sendKeys("office");
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("//*[@id=\"tb_header_search_form\"]/span[1]")).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("热门搜索异常");
        }

        // 关闭chrome
        webDriver.quit();
    }
}
