package com.discord.mansubot.commands;

import java.util.List;

import org.springframework.stereotype.Component;

import com.discord.mansubot.models.CommandEntry;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

@Component
public class PlayCommand implements Command{

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
        
        musicPlay(guild);

        msg = userName + " 님의 " + arguments + " 재생합니다.";
        msgChannel.sendMessage(msg).queue();
        

    }
    @Override
    public String help(){      
        return "!play 노래제목 을 입력해보세요.";
    }

    @Override
    public void receiveMessage(){

    }


    //노래 재생 기능
    public void musicPlay(Guild guild){
        //보이스채널 입장
        List<VoiceChannel> vChannel = guild.getVoiceChannels();
        AudioManager audioManager = guild.getAudioManager();
        audioManager.openAudioConnection(vChannel.get(0));


    }

}
