package com.noahhendrickson.elefant.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Created by Noah Hendrickson on 4/8/2020
 */
public interface ICommand {

    void execute(String[] args, MessageReceivedEvent event);
    List<String> getAliases();
    String getDescription();
    String getName();
    List<String> getUsageInstructions();

}
