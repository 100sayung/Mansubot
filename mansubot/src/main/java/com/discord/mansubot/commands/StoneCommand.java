package com.discord.mansubot.commands;

import com.discord.mansubot.models.CommandEntry;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class StoneCommand implements Command{
    
    @Override
    public void execute(MessageReceivedEvent event, String[] parts){
        String arguments = parts[1];
        MessageChannel msgChannel = event.getChannel();
        String msg = "";
        
        if("help".equals(arguments)){
            msg = help();
            msgChannel.sendMessage(msg).queue();
            return;
        }
        // String msgChannelName = msgChannel.getName();
        // String commandName = parts[0];
        Guild guild = event.getGuild();
        String userName = event.getAuthor().getName();
        

        msg = "HearthStone Command";
        msgChannel.sendMessage(msg).queue();

    }

    @Override
    public String help(){
        return "";
    }
    @Override
    public void receiveMessage(){

    }
}

