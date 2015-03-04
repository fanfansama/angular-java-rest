package jenkins.pages

import geb.Page

/**
 * Created by francois on 03/03/15.
 */
class  HomePage extends Page {

    static url = "http://192.168.49.45:8080/jenkins/";

    static at = { title == "Tableau de bord [Jenkins]" }

    static content = {

        results { $("#projectstatus #job_soc td") }
        result { i -> results[i] }
        resultLink { i -> result(i).find("a.model-link") }
        socLink {
            resultLink(2).text == "soc"
            resultLink(2)
        }

        soc { $("#projectstatus #job_soc a.model-link") }

    }

}
