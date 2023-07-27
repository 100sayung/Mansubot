package com.discord.mansubot.commands;

import com.discord.mansubot.models.CommandEntry;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    void execute(MessageReceivedEvent event, String[] parts);
    void help();
    void receiveMessage();
}
