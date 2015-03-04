package jenkins.specs

import geb.spock.GebReportingSpec
import jenkins.pages.HomePage
import jenkins.pages.SocPage

/**
 * Created by francois on 03/03/15.
 */
class HomeSpec  extends GebReportingSpec {

    def setup(){
        given:
        to HomePage

        expect:
        at HomePage
    }

    def "init"() {

        report("initialisation OK")
    }

    def "verifier soc"() {

        given:
        to HomePage

        expect:
        soc().text() == "soc"

    }

    def "ouvrir l'onglet soc"() {

        given:
        soc().click();

        expect:
        at SocPage

    }

}
