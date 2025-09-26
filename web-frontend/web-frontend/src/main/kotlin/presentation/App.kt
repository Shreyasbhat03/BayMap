package presentation
import react.FC
import react.dom.html.ReactHTML.div
import web.cssom.ClassName
import presentation.pages.EmailVerificationPage


val App = FC {
    console.log("App component is rendering") // Debug line
<<<<<<< Updated upstream
//    div {
//        className = ClassName("bg-blue-900 text-green p-4 rounded")
//        +"Hello World with Kotlin React Wrap"
//    }
    EmailVerificationPage()
=======
    div {
        className = ClassName("bg-blue-900 text-green p-4 rounded")
        +"Hello World with Kotlin React Wrap Abhinav Shetty"
    }
    HomePage()
>>>>>>> Stashed changes
}
