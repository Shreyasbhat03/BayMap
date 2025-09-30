import react.FC
import react.dom.html.ReactHTML.div
import web.cssom.ClassName

import presentation.IntroPage

val App = FC {
    console.log("App component is rendering") // Debug line
    IntroPage()
}
