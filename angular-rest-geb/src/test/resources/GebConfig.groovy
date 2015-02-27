import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver


/**
 * Created by francois on 27/02/15.
 */


def locale = "fr"
def browserSize = new Dimension(1280, 1024)

         /*
environments {
    'firefox' {
        driver = {
            def d = new FirefoxDriver()
            d.manage().window().setSize(browserSize)
            return d
        }
    }
}
           */


driver = {
    def d = new FirefoxDriver()
    d.manage().window().setSize(browserSize)
    return d
}

baseUrl = "http://gebish.org"
