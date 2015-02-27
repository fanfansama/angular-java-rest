package org.specs

import geb.spock.GebReportingSpec
import org.pages.GoogleHomePage
import org.pages.GoogleResultsPage
import org.pages.WikipediaPage

/**
 * Created by francois on 27/02/15.
 */
class GoogleWikipediaSpec extends GebReportingSpec {

    def "first result for wikipedia search should be wikipedia"() {
        given:
        to GoogleHomePage

        expect:
        at GoogleHomePage

        when:
        search.field.value("wikipedia")

        then:
        waitFor { at GoogleResultsPage }

        and:
        firstResultLink.text() == "Wikipedia"

        when:
        firstResultLink.click()

        then:
        waitFor { at WikipediaPage }
    }

}
