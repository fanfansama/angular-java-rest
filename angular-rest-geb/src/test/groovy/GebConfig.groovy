import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * Created by francois on 27/02/15.
 */


def locale = "fr"
def browserSize = new Dimension(1280, 1024)


environments {
    'firefox' {
        driver = {
            def d = new FirefoxDriver()
            d.manage().window().setSize(browserSize)
            return d
        }
    }
}
