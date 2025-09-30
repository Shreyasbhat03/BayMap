package presentation.pages

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.nav
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.section
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.footer
import react.dom.html.ReactHTML.form
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.span
import web.html.InputType
import web.cssom.ClassName
import org.w3c.dom.events.EventListener
import react.dom.events.FormEvent
// Import the global window object from the standard library
import kotlinx.browser.window // <-- ENSURE THIS IMPORT IS PRESENT
// Removed the unused import org.w3c.dom.Window

val IntroPage = FC<Props> {
    // State variables for the Modal logic
    var showModal by useState(false)
    var isLoginMode by useState(false)

    // Function to switch between Login and Signup forms
    fun toggleForm() {
        isLoginMode = !isLoginMode
    }

    // Function to handle form submission
    val handleSubmit: (FormEvent<*>) -> Unit = { e ->
        e.preventDefault()
        // In a real app, this is where you'd call your API
        println("Form submitted in ${if (isLoginMode) "Login" else "Sign Up"} mode.")
        showModal = false // Close modal on submission
    }

    // --- Component Structure ---

    // Header
    header {
        className = ClassName("bg-[#252526] border-b border-[#3e3e42] px-8 h-[70px] flex items-center justify-between sticky top-0 z-50 backdrop-blur")
        div {
            className = ClassName("text-2xl font-bold text-[#007acc] flex items-center gap-2 before:content-['🤖'] before:text-[28px]")
            +"BayMap"
        }
        nav {
            className = ClassName("hidden md:flex gap-8")
            a {
                href = "#features"
                className = ClassName("text-[#cccccc] no-underline px-4 py-2 rounded-md font-medium hover:bg-[#2d2d30] hover:text-[#007acc]")
                +"Features"
            }
            a {
                href = "#showcase"
                className = ClassName("text-[#cccccc] no-underline px-4 py-2 rounded-md font-medium hover:bg-[#2d2d30] hover:text-[#007acc]")
                +"Demo"
            }
            a {
                href = "#pricing"
                className = ClassName("text-[#cccccc] no-underline px-4 py-2 rounded-md font-medium hover:bg-[#2d2d30] hover:text-[#007acc]")
                +"Pricing"
            }
        }
        button {
            className = ClassName("bg-gradient-to-r from-[#007acc] to-[#0099ff] text-white px-6 py-3 rounded-lg font-semibold hover:-translate-y-0.5 hover:shadow-xl transition")
            onClick = { showModal = true }
            +"Get Started"
        }
    }

    // Hero Section
    section {
        className = ClassName("py-32 px-8 text-center bg-gradient-to-br from-[#1e1e1e] to-[#2d2d30] relative overflow-hidden")
        div {
            className = ClassName("max-w-4xl mx-auto relative z-10")
            h1 {
                className = ClassName("text-5xl md:text-6xl font-extrabold mb-6 text-transparent bg-clip-text bg-gradient-to-r from-white to-[#007acc]")
                +"Build Intelligent AI Agents"
            }
            p {
                className = ClassName("text-xl text-[#b3b3b3] mb-6")
                +"No-code platform for creating powerful autonomous agents"
            }
            p {
                className = ClassName("text-base text-[#969696] mb-12 max-w-xl mx-auto")
                +"Design, deploy, and manage intelligent agents at scale. Baymap makes it simple to build graph-aware, event-driven, distributed AI systems on top of Ray — from JVM to Python ecosystems."
            }
            button {
                className = ClassName("bg-gradient-to-r from-[#007acc] to-[#0099ff] text-white px-10 py-4 rounded-lg font-semibold text-lg hover:-translate-y-0.5 hover:shadow-xl transition mb-16")
                onClick = { showModal = true }
                +"Start Building with Baymap"
            }
            // Features Grid
            div {
                className = ClassName("grid grid-cols-1 md:grid-cols-3 gap-8 max-w-5xl mx-auto")
                listOf(
                    Triple("⚡", "Drag & Drop Builder", "Intuitive visual interface to create complex AI workflows without coding"),
                    Triple("🔗", "Smart Integrations", "Connect to 100+ tools and services with pre-built connectors"),
                    Triple("🚀", "One-Click Deploy", "Deploy your agents instantly to cloud or on-premises environments")
                ).forEach { (icon, title, desc) ->
                    div {
                        className = ClassName("bg-[#2d2d30] border border-[#3e3e42] rounded-xl p-8 text-left hover:border-[#007acc] hover:-translate-y-1 hover:shadow-xl transition")
                        div {
                            className = ClassName("w-14 h-14 flex items-center justify-center bg-gradient-to-r from-[#007acc] to-[#0099ff] rounded-xl text-2xl mb-4")
                            +icon
                        }
                        h3 {
                            className = ClassName("text-lg font-semibold text-white mb-2")
                            +title
                        }
                        p {
                            className = ClassName("text-sm text-[#969696]")
                            +desc
                        }
                    }
                }
            }
        }
    }

    // Product Showcase
    section {
        id = "showcase"
        className = ClassName("py-32 px-8 text-center bg-[#252526]")
        h2 {
            className = ClassName("text-3xl font-bold text-white mb-4")
            +"See It In Action"
        }
        p {
            className = ClassName("text-base text-[#969696] mb-16 max-w-xl mx-auto")
            +"Watch how easy it is to build and deploy intelligent agents"
        }
        div {
            className = ClassName("max-w-4xl mx-auto bg-gradient-to-br from-[#2d2d30] to-[#3e3e42] rounded-2xl border border-[#3e3e42] p-12 flex items-center justify-center min-h-[400px] relative overflow-hidden")
            p {
                className = ClassName("absolute bottom-8 left-1/2 -translate-x-1/2 text-[#969696] text-sm")
                +"Interactive Product Demo Coming Soon"
            }
            div { className = ClassName("text-6xl opacity-30") ; +"🖼" }
        }
    }

    // Footer
    footer {
        className = ClassName("bg-[#1a1a1a] border-t border-[#3e3e42] py-12 px-8 text-center")
        div {
            className = ClassName("flex justify-center gap-8 mb-8")
            listOf("About", "Contact", "Privacy", "Terms").forEach {
                a {
                    href = "#${it.lowercase()}"
                    className = ClassName("text-[#969696] hover:text-[#007acc] no-underline")
                    +it
                }
            }
        }
        p {
            className = ClassName("text-sm text-[#666666]")
            +"Copyright © 2025 BayMap. All rights reserved."
        }
    }

    // Modal (Conditional Rendering)
    if (showModal) {
        div {
            onClick = { e ->
                if (e.target.asDynamic().id == "authModal") showModal = false
            }
            id = "authModal"
            className = ClassName("fixed inset-0 bg-black/70 backdrop-blur-sm z-[1000] flex items-center justify-center")

            div {
                className = ClassName("bg-[#2d2d30] border border-[#3e3e42] rounded-2xl p-12 w-[90%] max-w-md relative transition-transform duration-300 transform scale-100")

                button {
                    className = ClassName("absolute top-4 right-4 text-[#969696] text-xl hover:text-white transition")
                    onClick = { showModal = false }
                    +"×"
                }

                h2 {
                    className = ClassName("text-xl font-semibold text-white text-center mb-8")
                    +(if (isLoginMode) "Welcome Back" else "Join Agentic AI Builder")
                }

                form {
                    onSubmit = handleSubmit
                    className = ClassName("space-y-6")

                    // Username Field (Only for Sign Up)
                    if (!isLoginMode) {
                        div {
                            className = ClassName("text-left")
                            label {
                                htmlFor = "username"
                                className = ClassName("block text-sm text-[#cccccc] font-medium mb-2")
                                +"Username"
                            }
                            input {
                                id = "username"
                                type = InputType.text
                                required = true
                                placeholder = "Enter username"
                                className = ClassName("w-full bg-[#1e1e1e] border border-[#3e3e42] rounded-lg p-3 text-[#cccccc] focus:outline-none focus:border-[#007acc]")
                            }
                        }
                    }

                    // Email Field
                    div {
                        className = ClassName("text-left")
                        label {
                            htmlFor = "email"
                            className = ClassName("block text-sm text-[#cccccc] font-medium mb-2")
                            +"Email"
                        }
                        input {
                            id = "email"
                            type = InputType.email
                            required = true
                            placeholder = "Enter your email"
                            className = ClassName("w-full bg-[#1e1e1e] border border-[#3e3e42] rounded-lg p-3 text-[#cccccc] focus:outline-none focus:border-[#007acc]")
                        }
                    }

                    // Password Field
                    div {
                        className = ClassName("text-left")
                        label {
                            htmlFor = "password"
                            className = ClassName("block text-sm text-[#cccccc] font-medium mb-2")
                            +"Password"
                        }
                        input {
                            id = "password"
                            type = InputType.password
                            required = true
                            placeholder = "Enter password"
                            className = ClassName("w-full bg-[#1e1e1e] border border-[#3e3e42] rounded-lg p-3 text-[#cccccc] focus:outline-none focus:border-[#007acc]")
                        }
                    }

                    button {
                        type = web.html.ButtonType.submit
                        className = ClassName("w-full bg-gradient-to-r from-[#007acc] to-[#0099ff] text-white py-3 rounded-lg font-semibold hover:-translate-y-0.5 hover:shadow-md transition")
                        +(if (isLoginMode) "Login" else "Sign Up")
                    }
                }

                // OR Divider
                div {
                    className = ClassName("text-center text-[#969696] my-6 relative")
                    span {
                        className = ClassName("bg-[#2d2d30] px-4 relative z-10")
                        +"OR"
                    }
                    div { className = ClassName("absolute top-1/2 left-0 right-0 h-px bg-[#3e3e42] -z-0") }
                }

                // Social Buttons
                div {
                    className = ClassName("flex gap-2")
                    listOf("🔍 Google", "🐙 GitHub").forEach {
                        button {
                            className = ClassName("flex-1 bg-[#1e1e1e] border border-[#3e3e42] rounded-lg py-3 text-[#cccccc] font-medium hover:border-[#007acc] hover:bg-[#252526] transition")
                            +it
                        }
                    }
                }

                // Toggle Link
                div {
                    className = ClassName("text-center mt-6 text-sm text-[#969696]")
                    span {
                        +(if (isLoginMode) "Don't have an account? " else "Already have an account? ")
                    }
                    a {
                        className = ClassName("text-[#007acc] cursor-pointer hover:underline")
                        onClick = { toggleForm() }
                        +(if (isLoginMode) "Sign Up" else "Login")
                    }
                }
            }
        }
    }

    // Keydown listener for ESC to close the modal (FIXED using kotlinx.browser.window)
    useEffect(showModal) {
        if (!showModal) return@useEffect

        // Define the handler as a proper DOM EventListener
        val handleEscape = EventListener { e ->
            if (e.asDynamic().key == "Escape") showModal = false
        }

        // FIX: Use the globally accessible 'window' object
        window.addEventListener("keydown", handleEscape)

        cleanup {
            window.removeEventListener("keydown", handleEscape)
        }
    }
}