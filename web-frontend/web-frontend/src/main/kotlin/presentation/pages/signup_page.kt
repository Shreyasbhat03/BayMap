package presentation.pages

import react.FC
import react.Props
import web.cssom.ClassName
import web.html.InputType
import web.html.ButtonType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.form
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.span


val SignupPage = FC<Props> {
    div {
        className = ClassName("min-h-screen flex flex-col bg-gray-900 text-gray-300")

        // Header
        header {
            className = ClassName("bg-gray-800 border-b border-gray-700 p-4 flex justify-between items-center")
            a {
                className = ClassName("text-2xl font-bold text-blue-500 flex items-center gap-2 no-underline")
                +"🤖 Baymap Systems"
            }
            a {
                className = ClassName("text-gray-400 hover:text-blue-400 font-medium no-underline")
                +"← Back to Home"
            }
        }

        // Main Content
        main {
            className = ClassName("flex-1 flex justify-center items-center p-6 bg-gradient-to-br from-gray-900 to-gray-800")
            div {
                className = ClassName("bg-gray-800 border border-gray-700 rounded-2xl p-8 max-w-md w-full shadow-xl")

                // Header Text
                div {
                    className = ClassName("text-center mb-8")
                    h1 {
                        className = ClassName("text-3xl font-bold text-white bg-clip-text text-transparent bg-gradient-to-r from-white to-blue-500")
                        +"Create Account"
                    }
                    p {
                        className = ClassName("text-gray-400")
                        +"Join us to start building amazing apps"
                    }
                }

                // Form
                form {
                    className = ClassName("space-y-4")

                    // Name
                    div {
                        label {
                            className = ClassName("block text-sm font-medium mb-1")
                            htmlFor = "name"
                            +"Full Name"
                        }
                        input {
                            id = "name"
                            type = InputType.text
                            placeholder = "Enter your full name"
                            className = ClassName("w-full bg-gray-900 border border-gray-700 rounded-lg px-3 py-2 text-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-500/30")
                        }
                    }

                    // Email
                    div {
                        label {
                            className = ClassName("block text-sm font-medium mb-1")
                            htmlFor = "email"
                            +"Email"
                        }
                        input {
                            id = "email"
                            type = InputType.email
                            placeholder = "Enter your email"
                            className = ClassName("w-full bg-gray-900 border border-gray-700 rounded-lg px-3 py-2 text-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-500/30")
                        }
                    }

                    // Password
                    div {
                        label {
                            className = ClassName("block text-sm font-medium mb-1")
                            htmlFor = "password"
                            +"Password"
                        }
                        input {
                            id = "password"
                            type = InputType.password
                            placeholder = "Create a password"
                            className = ClassName("w-full bg-gray-900 border border-gray-700 rounded-lg px-3 py-2 text-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-500/30")
                        }
                    }

                    // Confirm Password
                    div {
                        label {
                            className = ClassName("block text-sm font-medium mb-1")
                            htmlFor = "confirmPassword"
                            +"Confirm Password"
                        }
                        input {
                            id = "confirmPassword"
                            type = InputType.password
                            placeholder = "Confirm your password"
                            className = ClassName("w-full bg-gray-900 border border-gray-700 rounded-lg px-3 py-2 text-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-500/30")
                        }
                    }

                    // Signup Button
                    button {
                        type = ButtonType.submit
                        className = ClassName("w-full bg-gradient-to-r from-blue-600 to-blue-400 text-white py-2 rounded-lg font-semibold hover:shadow-lg transition")
                        +"Sign Up"
                    }
                }

                // Already have account
                div {
                    className = ClassName("text-center text-gray-400 text-sm mt-6")
                    +"Already have an account? "
                    a {
                        className = ClassName("text-blue-500 hover:underline")
                        +"Sign in"
                    }
                }
            }
        }
    }
}
