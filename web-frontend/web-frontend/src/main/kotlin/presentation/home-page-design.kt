package presentation

import react.FC
import react.Props
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.main
import react.dom.html.ReactHTML.nav
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.section
import web.cssom.ClassName

// Data class to hold information for the quick action cards
private data class ActionCardInfo(
    val icon: String,
    val title: String,
    val description: String
)

// Data class to hold information for the recent activity items
private data class ActivityItemInfo(
    val text: String,
    val time: String
)

val HomePage = FC<Props> {
    val quickActions = listOf(
        ActionCardInfo("+", "Start New Project", "Create a new project from scratch with our guided setup"),
        ActionCardInfo("📁", "Open Recent Project", "Continue working on your most recently accessed projects"),
        ActionCardInfo("📄", "Browse Documents", "Access and manage all your project documents and files"),
        ActionCardInfo("🔗", "Manage Connections", "Set up and configure external service integrations")
    )

    val recentActivities = listOf(
        ActivityItemInfo("Created new validation report for Project Alpha", "2 hours ago"),
        ActivityItemInfo("Updated connection settings for GitHub integration", "5 hours ago"),
        ActivityItemInfo("Exported PDF bundle for client review", "1 day ago"),
        ActivityItemInfo("Started new project: Mobile App Redesign", "2 days ago")
    )

    div {
        className = ClassName("font-sans bg-gray-900 text-gray-300 leading-relaxed")

        header {
            className = ClassName("bg-gray-800 border-b border-gray-700 px-4 md:px-8 h-[60px] flex items-center justify-between sticky top-0 z-50")
            div {
                className = ClassName("text-xl font-semibold text-blue-500")
                +"ProjectHub"
            }
            nav {
                className = ClassName("flex gap-4 md:gap-8")
                val navLinkClasses = "text-gray-300 no-underline px-4 py-2 rounded-md transition-all duration-200 hover:bg-gray-700 hover:text-blue-500"
                val activeNavLinkClasses = "bg-blue-900/50 text-blue-500"

                a { className = ClassName("$navLinkClasses $activeNavLinkClasses"); href = "#"; +"Home" }
                a { className = ClassName(navLinkClasses); href = "#"; +"Projects" }
                a { className = ClassName(navLinkClasses); href = "#"; +"Documents" }
                a { className = ClassName(navLinkClasses); href = "#"; +"Connect" }
            }
            div {
                className = ClassName("flex items-center gap-2")
                div {
                    className = ClassName("w-8 h-8 rounded-full bg-blue-500 flex items-center justify-center font-semibold text-sm")
                    +"JS"
                }
            }
        }

        main {
            className = ClassName("max-w-6xl mx-auto px-4 sm:px-8 py-12")
            section {
                className = ClassName("text-center mb-12")
                h1 {
                    className = ClassName("text-3xl md:text-4xl font-light mb-2 text-white")
                    +"Welcome back, John!"
                }
                p {
                    className = ClassName("text-base text-gray-500")
                    +"Ready to continue your work? Here's what you can do."
                }
            }

            section {
                className = ClassName("grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 mb-12")
                quickActions.forEach { action ->
                    div {
                        className = ClassName("bg-gray-800 border border-gray-700 rounded-lg p-8 text-center cursor-pointer transition-all duration-300 hover:border-blue-500 hover:-translate-y-0.5 hover:shadow-xl hover:shadow-blue-500/10")
                        div {
                            className = ClassName("w-12 h-12 bg-blue-500 rounded-lg mx-auto mb-4 flex items-center justify-center text-xl")
                            +action.icon
                        }
                        h3 {
                            className = ClassName("text-lg font-medium mb-2 text-white")
                            +action.title
                        }
                        p {
                            className = ClassName("text-sm text-gray-500")
                            +action.description
                        }
                    }
                }
            }

            section {
                className = ClassName("bg-gray-800/50 border border-gray-700 rounded-lg p-6")
                h2 {
                    className = ClassName("text-xl font-medium mb-4 text-white")
                    +"Recent Activity"
                }
                div {
                    recentActivities.forEach { activity ->
                        div {
                            className = ClassName("flex items-center py-3 border-b border-gray-700 last:border-none")
                            div {
                                className = ClassName("w-2 h-2 bg-blue-500 rounded-full mr-4 flex-shrink-0")
                            }
                            div {
                                className = ClassName("flex-1")
                                div {
                                    className = ClassName("text-sm mb-1")
                                    +activity.text
                                }
                                div {
                                    className = ClassName("text-xs text-gray-500")
                                    +activity.time
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}