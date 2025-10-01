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


val LoginPage = FC<Props> {
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
                        +"Welcome Back"
                    }
                    p {
                        className = ClassName("text-gray-400")
                        +"Sign in to your account to continue building"
                    }
                }

                // Form
                form {
                    className = ClassName("space-y-4")

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
                            placeholder = "Enter your password"
                            className = ClassName("w-full bg-gray-900 border border-gray-700 rounded-lg px-3 py-2 text-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-500/30")
                        }
                    }

                    // Options
                    div {
                        className = ClassName("flex justify-between items-center text-sm")
                        label {
                            className = ClassName("flex items-center gap-2")
                            input {
                                type = InputType.checkbox
                                className = ClassName("w-4 h-4 border-gray-600 bg-gray-900 rounded")
                            }
                            +"Remember me"
                        }
                        a {
                            className = ClassName("text-blue-500 hover:underline")
                            +"Forgot password?"
                        }
                    }

                    // Button
                    button {
                        type = ButtonType.submit
                        className = ClassName("w-full bg-gradient-to-r from-blue-600 to-blue-400 text-white py-2 rounded-lg font-semibold hover:shadow-lg transition")
                        +"Sign In"
                    }
                }

                // Divider
                div {
                    className = ClassName("text-center text-gray-500 my-6 relative")
                    span {
                        className = ClassName("px-2 bg-gray-800 relative z-10")
                        +"OR"
                    }
                    div {
                        className = ClassName("absolute inset-x-0 top-1/2 border-t border-gray-700")
                    }
                }

                // Social buttons
                div {
                    className = ClassName("flex gap-3 mb-6")
                    button {
                        className = ClassName("flex-1 bg-gray-900 border border-gray-700 py-2 rounded-lg hover:border-blue-500 transition")
                        +"🔍 Google"
                    }
                    button {
                        className = ClassName("flex-1 bg-gray-900 border border-gray-700 py-2 rounded-lg hover:border-blue-500 transition")
                        +"🐙 GitHub"
                    }
                }

                // Signup link
                div {
                    className = ClassName("text-center text-gray-400 text-sm")
                    +"Don't have an account? "
                    a {
                        className = ClassName("text-blue-500 hover:underline")
                        +"Sign up"
                    }
                }
            }
        }
    }
}
