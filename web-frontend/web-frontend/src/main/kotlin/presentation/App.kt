package presentation

import react.FC
import react.dom.html.ReactHTML.div
import web.cssom.ClassName
import presentation.pages.EmailVerificationPage
import presentation.pages.HomePage

val App = FC {
    console.log("App component is rendering") // Debug line

    // Keep EmailVerificationPage
    EmailVerificationPage()

    // Add HomePage for testing UI
    HomePage()
}