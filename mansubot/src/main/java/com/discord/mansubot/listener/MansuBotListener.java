package com.discord.mansubot.listener;

import java.util.List;


import com.discord.mansubot.commands.CommandProcessor;
import com.discord.mansubot.utils.repository.CommandEntryService;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

@RequiredArgsConstructor
public class MansuBotListener extends ListenerAdapter {


    private final CommandEntryService cEntryService;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; //봇이 쓴 메시지인지 확인
        Message message = event.getMessage();
        String content = message.getContentRaw(); //메시지 내용 = content
        if(!event.isFromGuild()) return;
        if(!event.getMessage().getContentRaw().startsWith("!")) return;
        
        //!로 시작하면 !를 제외한 내용 출력
        //User 정보는 event.getAuthor 로 빼기 가능 (usersnowflake user)
        if (content.startsWith("!")) {
            CommandProcessor cProcessor = new CommandProcessor(cEntryService);
            cProcessor.processCommand(event);
        }

       //PlayCommand 로 이후 이동
        Guild guild = event.getGuild();
        MessageChannel msgChannel = event.getChannel();
    }

}