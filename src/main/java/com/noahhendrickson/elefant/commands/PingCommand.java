package com.noahhendrickson.elefant.commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Created by Noah Hendrickson on 4/9/2020
 */
public class PingCommand extends Command {

    @Override
    public void execute(String[] args, MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        super.sendMessage("**Pong!** Gateway: `" + jda.getGatewayPing() +
                "` Rest: `" + jda.getRestPing().complete() + "`", event);
    }

    @Override
    public List<String> getAliases() {
        return super.asList("!ping", "!pang", "!peng", "!pong", "!pung");
    }

    @Override
    public String getDescription() {
        return "Check the bot's latency.";
    }

    @Override
    public String getName() {
        return "Ping";
    }

    @Override
    public List<String> getUsageInstructions() {
        return super.asList("");
    }
}
