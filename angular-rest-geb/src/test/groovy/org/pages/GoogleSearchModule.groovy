package org.pages

import geb.Module

/**
 * Created by francois on 27/02/15.
 */
// modules are reusable fragments that can be used across org.pages that can be parameterised
// here we are using a module to model the search function on the home and results org.pages
class GoogleSearchModule extends Module {

    // a parameterised value set when the module is included
    def buttonValue

    // the content DSL
    static content = {

        // name the search input control “field”, defining it with the jQuery like navigator
        field { $("input", name: "q") }

        // the search button declares that it takes us to the results page, and uses the
        // parameterised buttonValue to define itself
        button(to: GoogleResultsPage) {
            $("input", value: buttonValue)
        }
    }
}
