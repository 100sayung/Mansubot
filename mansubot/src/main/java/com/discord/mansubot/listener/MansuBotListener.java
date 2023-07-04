package com.discord.mansubot.listener;

import java.time.Instant;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MansuBotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; //봇이 쓴 메시지인지 확인
        Message message = event.getMessage();
        String content = message.getContentRaw(); //메시지 내용 = content

        //!로 시작하면 !를 제외한 내용 출력
        //User 정보는 event.getAuthor 로 빼기 가능 (usersnowflake user)
        if (content.startsWith("!")) {
            MessageChannel channel = event.getChannel();
            User user = event.getAuthor();
            channel.sendMessage("입력한 단어 : " + content.substring(1) + "\n사용자 : " + user.getName() +
                "(snowflake : " + user.getId() + ")").queue();
        }


    }
}