package com.discord.mansubot.commands;

import com.discord.mansubot.models.CommandEntry;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand implements Command{
    
    @Override
    public void execute(MessageReceivedEvent event, String[] parts){
        MessageChannel msgChannel = event.getChannel();
        String msg = "";
        

        msg = "HELP";
        msgChannel.sendMessage(msg).queue();

    }

    @Override
    public String help() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'help'");
    }

    @Override
    public void receiveMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveMessage'");
    }

}
