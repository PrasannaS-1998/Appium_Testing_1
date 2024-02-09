package Appium_1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class basics {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        URL url = new URL("http://localhost:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","14");
        capabilities.setCapability("deviceName","OnePlus Nord CE3 5G");
        capabilities.setCapability("deviceID","192.168.5.215:5555");

        AndroidDriver driver = new AndroidDriver(url,capabilities);


        driver.unlockDevice();
        System.out.println("----> unlocking device");






        System.out.println("----> current package name       --->" + driver.getCurrentPackage() );

        System.out.println("----> current time on device     --->" + driver.getDeviceTime());

        System.out.println("----> current battery info       --->" + driver.getBatteryInfo());

        System.out.println("----> current battery percentage ---> " + driver.getBatteryInfo().getLevel());

        System.out.println("----> current battery state      ---> " + driver.getBatteryInfo().getState());

        System.out.println("----> current activity           --->"  + driver.currentActivity() );

        System.out.println("----> current status             ---> "  + driver.getStatus());

        System.out.println("----> current location           ---> " +driver.getLocation() );

        System.out.println("----> is wifi enable             ---> " + driver.getConnection().isWiFiEnabled());

        driver.openNotifications();
        System.out.println("-----> notification open");
        Thread.sleep(3000);

        driver.navigate().back();
        System.out.println("----> close the notification ( back one step )");
        Thread.sleep(3000);

        driver.activateApp("com.android.settings");
        System.out.println("----> enter into settings ");
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        System.out.println("----> screen back to home page ");
        Thread.sleep(3000);

        driver.activateApp("com.oneplus.filemanager");
        System.out.println("----> open my file application ");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.oneplus.filemanager:id/phone_storage_title']")).click();
        System.out.println(" ----> open phone storage" );

//        driver.activateApp("com.android.settings");
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"+
//                ".scrollIntoView(new UiSelector()"+ ".textMatches(\"Battery\").instance(0))"));

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"+
                ".scrollIntoView(new UiSelector()"+ ".textMatches(\"songs\").instance(0))"));
    }
}
