package runmyprocess.pages

import geb.Page

/**
 * Created by francois on 04/03/15.
 */
class HomePage extends Page {

    static url = "https://live.runmyprocess.com/live/112501398931842687/appli/143094";

    static at = { title == "Homepage" }

    static content = {

        logoutButton { $("span", class:"action") }

    }

}
