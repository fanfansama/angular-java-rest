package jenkins.pages

import geb.Page

/**
 * Created by francois on 03/03/15.
 */
class SocPage extends Page{

    static url = "http://192.168.49.45:8080/jenkins/wiew/soc";

    static at = { title == "soc [Jenkins]" }

    static content = {

    }

}
