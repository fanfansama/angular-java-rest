package runmyprocess.pages

import geb.Page

/**
 * Created by francois on 04/03/15.
 */
class SignInPage extends Page {

    static url = "https://live.runmyprocess.com/pub/112501398931842687/appli/154322";

    static at = { title == "Login Page" }

    static content = {

        username { $('#j_username') }
        password { $('#j_password') }

        loginButton { $("button", type: "button", class:"login-Button") }

    }

    boolean login(theUsername, thePassword) {
        username = theUsername
        password = thePassword
        loginButton.click()
    }


}
