package com.noahhendrickson.elefant.commands;

import com.noahhendrickson.elefant.Elefant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Created by Noah Hendrickson on 4/8/2020
 */
public class BotCommand extends Command {

    @Override
    public void execute(String[] args, MessageReceivedEvent event) {
        SelfUser user = event.getJDA().getSelfUser();
        String avatar = user.getEffectiveAvatarUrl();

        super.sendMessage(new EmbedBuilder()
                .setColor(Elefant.getColor(event.getAuthor().getEffectiveAvatarUrl(),
                        event.getGuild().getSelfMember().getColor()))
                .setAuthor(user.getAsTag(), null, avatar)
                .setThumbnail(avatar)
                .addField("Name", user.getName(), false)
                .addField("ID:", user.getId(), false)
                .addField("Owner", "Noah Hendrickson", false)
                .addField("Github", "Comming Soon...", false)
                .setFooter("Copyright \u00a9 2020"), event);
    }

    @Override
    public List<String> getAliases() {
        return super.asList("!bot");
    }

    @Override
    public String getDescription() {
        return "Provides information on the bot.";
    }

    @Override
    public String getName() {
        return "Bot Information";
    }

    @Override
    public List<String> getUsageInstructions() {
        return super.asList("");
    }
}
