package com.noahhendrickson.commands

import com.noahhendrickson.elefant.commands.Command
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

class KotlinCommand : Command() {

    override fun execute(args: Array<out String>?, event: MessageReceivedEvent?) {
        super.sendMessage("Check Out Kotlin! <https://kotlinlang.org/>\n\n" +
                "```kotlin\n" + "fun main() {\n" + "    println(\"Hello World\")\n" + "}\n" + "```", event)
    }

    override fun getAliases(): MutableList<String> {
        return mutableListOf("!kotlin")
    }

    override fun getName(): String {
        return "Kotlin"
    }

    override fun getDescription(): String {
        return "A simple command advertising kotlin."
    }

    override fun getUsageInstructions(): MutableList<String> {
        return mutableListOf("")
    }
}