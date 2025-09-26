package presentation.pages // Assuming you want it in the 'presentation' package

import kotlinx.browser.window
import react.*
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import web.cssom.ClassName // Keep this for ClassName
import web.location.location
import web.timers.clearInterval
import web.timers.setInterval
import web.url.URLSearchParams
import kotlin.time.Duration.Companion.seconds

val EmailVerificationPage = FC<Props> {
    var isVerified by useState(false)
    var userEmail by useState("john.doe@example.com")
    var isResendDisabled by useState(false)
    var countdown by useState(60)

    useEffectOnce {
        val params = URLSearchParams(location.search)
        userEmail = params.get("email") ?: "john.doe@example.com"
        if (params.get("verified") == "true") {
            isVerified = true
        }
    }

    useEffect(isResendDisabled) {
        if (!isResendDisabled) return@useEffect
        // Arguments are now in the correct order: (duration, handler)
        val timer = setInterval(1.seconds, { countdown-- })
        cleanup { clearInterval(timer) }
    }

    useEffect(countdown) {
        if (countdown <= 0) {
            isResendDisabled = false
            countdown = 60
        }
    }

    fun handleResendEmail() {
        isResendDisabled = true
        console.log("Verification email resent to:", userEmail)
    }

    fun handleGoBack() {
        window.alert("Going back to home page...")
        // In a real app: window.location.href = "/"
    }

    fun handleGoToDashboard() {
        window.alert("Redirecting to dashboard...")
        // In a real app: window.location.href = "/dashboard"
    }

    div { // Added a wrapper div for consistent body styling if needed
        className = ClassName("font-sans bg-gray-900 text-gray-300 leading-relaxed min-h-screen flex flex-col")

        header {
            className = ClassName("sticky top-0 z-50 flex h-[70px] items-center justify-between border-b border-b-[#3e3e42] bg-[#252526] px-4 md:px-8")

            div {
                className = ClassName("flex items-center gap-2 text-2xl font-bold text-[#007acc] before:text-[28px] before:content-['🤖']")
                +"Agentic AI Builder"
            }

            a {
                className = ClassName("flex items-center gap-2 text-[#969696] no-underline transition-colors duration-200 ease-in-out hover:text-[#007acc]")
                href = "#"
                onClick = { handleGoBack() }
                +"← Back to Home"
            }
        }

        main {
            className = ClassName("relative flex flex-1 items-center justify-center overflow-hidden bg-gradient-to-br from-[#1e1e1e] to-[#2d2d30] p-8 before:absolute before:inset-0 before:bg-[radial-gradient(circle_at_30%_70%,rgba(0,122,204,0.05)_0%,transparent_50%)]")

            div {
                className = ClassName("relative z-10 w-full max-w-[500px] rounded-2xl border border-[#3e3e42] bg-[#2d2d30] p-8 text-center shadow-2xl md:p-12")

                if (isVerified) {
                    // --- SUCCESS STATE ---
                    div {
                        className = ClassName("mx-auto mb-8 flex h-20 w-20 items-center justify-center rounded-xl bg-gradient-to-br from-[#28a745] to-[#34ce57] text-4xl before:content-['✅']")
                    }
                    h1 {
                        className = ClassName("mb-4 text-2xl font-bold text-white md:text-3xl")
                        +"Email Verified!"
                    }
                    p {
                        className = ClassName("mb-8 text-lg leading-relaxed text-[#b3b3b3]")
                        +"Your account has been successfully verified. You can now access all features of Agentic AI Builder."
                    }
                    a {
                        className = ClassName("inline-block cursor-pointer rounded-lg bg-gradient-to-br from-[#28a745] to-[#34ce57] px-8 py-3.5 text-base font-semibold text-white no-underline transition-all duration-300 hover:-translate-y-0.5 hover:shadow-xl hover:shadow-green-500/30")
                        href = "#"
                        onClick = { handleGoToDashboard() }
                        +"Continue to Dashboard"
                    }
                    div {
                        className = ClassName("mt-8 border-t border-t-[#3e3e42] pt-6 text-sm text-[#969696]")
                        +"Welcome to Agentic AI Builder! Ready to build your first AI agent?"
                    }

                } else {
                    // --- DEFAULT VERIFICATION STATE ---
                    div {
                        className = ClassName("relative mx-auto mb-8 flex h-20 w-20 items-center justify-center overflow-hidden rounded-xl bg-gradient-to-br from-[#007acc] to-[#0099ff] text-4xl before:content-['✉️'] after:absolute after:h-[200%] after:w-[200%] after:animate-shimmer after:bg-gradient-to-r after:from-transparent after:via-white/10 after:to-transparent")
                    }
                    h1 {
                        className = ClassName("mb-4 text-2xl font-bold text-white md:text-3xl")
                        +"Check Your Email"
                    }
                    p {
                        className = ClassName("mb-2 text-lg leading-relaxed text-[#b3b3b3]")
                        +"We've sent a verification link to"
                    }
                    div {
                        className = ClassName("my-2 mb-8 inline-block rounded-md bg-[#1e3a5f] px-3 py-1 font-semibold text-[#007acc]")
                        +userEmail
                    }
                    p {
                        className = ClassName("mb-10 text-[0.95rem] leading-snug text-[#969696]")
                        +"Please check your inbox and click the verification link to activate your account. The link will expire in 24 hours."
                    }
                    button {
                        // Note: The `after:animate-sweep` needs the `sweep` keyframe defined in `tailwind.config.js`
                        className = ClassName("relative mb-6 cursor-pointer overflow-hidden rounded-lg bg-gradient-to-br from-[#007acc] to-[#0099ff] px-8 py-3.5 text-base font-semibold text-white transition-all duration-300 hover:-translate-y-0.5 hover:shadow-xl hover:shadow-blue-500/30 disabled:cursor-not-allowed disabled:opacity-60 disabled:hover:translate-y-0 disabled:hover:shadow-none before:absolute before:top-0 before:h-full before:w-full before:animate-sweep before:bg-gradient-to-r before:from-transparent before:via-white/20 before:to-transparent")
                        disabled = isResendDisabled
                        onClick = { handleResendEmail() }
                        +if (isResendDisabled) "Email Sent!" else "Resend Verification Email"
                    }
                    if(isResendDisabled) {
                        div {
                            className = ClassName("mb-8 text-sm text-[#969696]")
                            +"You can request a new email in "
                            span { +countdown.toString() }
                            +" seconds"
                        }
                    }
                    div {
                        className = ClassName("mt-8 border-t border-t-[#3e3e42] pt-6 text-sm text-[#969696]")
                        +"Didn't receive the email? Check your spam folder or "
                        a {
                            className = ClassName("text-[#007acc] no-underline transition-colors duration-200 hover:text-[#0099ff] hover:underline")
                            href = "#"
                            +"contact support"
                        }
                        +" for assistance."
                    }
                }
            }
        }
    }
}