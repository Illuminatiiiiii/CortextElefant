package com.noahhendrickson.elefant;

import com.noahhendrickson.elefant.commands.CommandManager;
import com.noahhendrickson.elefant.listeners.SuggestionsListener;
import com.noahhendrickson.elefant.utils.color.ColorThief;
import com.noahhendrickson.util.FileUtilKt;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import javax.security.auth.login.LoginException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Noah Hendrickson on 4/8/2020
 */
public class Elefant {

    private final List<String> loginDetails;

    public static void main(String[] args) {
        new Elefant();
    }

    public Elefant() {
        loginDetails = FileUtilKt.readFileLines("LoginDetails");

        try {
            JDABuilder.createDefault(loginDetails.get(0))
                    .addEventListeners(new CommandManager(this))
                    .addEventListeners(new SuggestionsListener())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static Color getColor(String url, Color color) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            int[] colors = ColorThief.getColor(image);
            return colors != null ? new Color(colors[0], colors[1], colors[2]) : color;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return color;
    }

    public List<String> getLoginDetails() {
        return loginDetails;
    }
}
