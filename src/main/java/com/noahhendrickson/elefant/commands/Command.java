package com.noahhendrickson.elefant.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Noah Hendrickson on 4/8/2020
 */
public abstract class Command implements ICommand {

    protected Message sendMessage(Message message, MessageReceivedEvent event) {
        return event.isFromType(ChannelType.PRIVATE) ? event.getPrivateChannel()
                .sendMessage(message)
                .complete() : event.getTextChannel()
                .sendMessage(message)
                .complete();
    }

    protected Message sendMessage(String message, MessageReceivedEvent event) {
        return sendMessage(new MessageBuilder().append(message).build(), event);
    }

    protected Message sendMessage(EmbedBuilder message, MessageReceivedEvent event) {
        return sendMessage(new MessageBuilder(message.build()).append("`")
                .append(event.getAuthor().getAsTag()).append("`").build(), event);
    }

    @SafeVarargs
    protected final <T> List<T> asList(T... a) {
        return Arrays.asList(a);
    }
}
