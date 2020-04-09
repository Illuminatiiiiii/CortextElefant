package com.noahhendrickson.elefant.listeners;

import com.noahhendrickson.elefant.Elefant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Noah Hendrickson on 4/9/2020
 */
public class SuggestionsListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.getAuthor().isFake()) return;

        List<Long> channels = Collections.singletonList(507387919779233816L);
        long idLong = event.getChannel().getIdLong();

        if (channels.contains(idLong)) {
            JDA jda = event.getJDA();
            TextChannel channel = jda.getTextChannelById(idLong);
            Emote success = jda.getEmoteById(697249279458279485L);
            Emote undefined = jda.getEmoteById(697249477135827055L);
            Emote error = jda.getEmoteById(697249583427747900L);

            if (success == null || undefined == null || error == null) {
                event.getChannel().sendMessage("Error with getting the emotes!")
                        .queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                return;
            }

            String contentRaw = event.getMessage().getContentRaw();

            if (contentRaw.split(" ").length <= 3) {
                event.getChannel().sendMessage(error.getAsMention() + " Your suggestion must be longer than three words!")
                        .queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                return;
            }

            if (channel != null) {
                User author = event.getAuthor();
                String effectiveAvatarUrl = author.getEffectiveAvatarUrl();

                channel.sendMessage(new EmbedBuilder()
                        .setColor(Elefant.getColor(effectiveAvatarUrl, event.getGuild().getSelfMember().getColor()))
                        .setAuthor(author.getAsTag(), effectiveAvatarUrl)
                        .setDescription(contentRaw)
                        .setFooter("Please react if you would like to see this!").build()).queue(message -> {
                    message.addReaction(success).queue();
                    message.addReaction(undefined).queue();
                    message.addReaction(error).queue();
                });
            }
        }
    }
}
