package runmyprocess.specs

import geb.spock.GebReportingSpec
import runmyprocess.pages.HomePage
import runmyprocess.pages.SignInPage
import runmyprocess.pages.SignedOutPage

/**
 * Created by francois on 04/03/15.
 */
class ConnectSpec extends GebReportingSpec {

    def "successful login"() {
        given: "a user going to sign in page"
        to SignInPage

        expect: "sign it page to be properly displayed"
        at SignInPage

        when: "identifying as user/pwd"
        login '', ''

        then: "expect to be redirected to the home page"
        at HomePage

        when: "signing out"
        report "after login"
        logoutButton.click()

        then: "expect to be at the signed out page"
        at SignedOutPage
    }

}
