package com.discord.mansubot.listener;

import java.time.Instant;
import java.util.List;

import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class MansuBotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; //봇이 쓴 메시지인지 확인
        Message message = event.getMessage();
        String content = message.getContentRaw(); //메시지 내용 = content
        Guild guild = event.getGuild();
        if(event.getAuthor().isBot()) return;
        if(!event.isFromGuild()) return;
        if(!event.getMessage().getContentRaw().startsWith("!")) return;
        
        MessageChannel msgChannel = event.getChannel();
        //!로 시작하면 !를 제외한 내용 출력
        //User 정보는 event.getAuthor 로 빼기 가능 (usersnowflake user)
        if (content.startsWith("!")) {
            Member member = event.getMember();
            User user = event.getAuthor();
            msgChannel.sendMessage("입력한 단어 : " + content.substring(1) + "\n사용자 : " + user.getName() +
                "(snowflake : " + user.getId() +")").queue();
        }

        List<Member> gMembers = guild.getMembers();
        
        for (Member member : gMembers) {
            System.out.println(member.getEffectiveName());
        }

        
       // List<VoiceChannel> channel = guild.getVoiceChannelsByName(content, true);
        List<VoiceChannel> vChannel = guild.getVoiceChannels();
        for (VoiceChannel voiceChannel : vChannel) {
            System.out.println(voiceChannel.getName());
        }

        AudioManager audioManager = guild.getAudioManager();
        audioManager.openAudioConnection(vChannel.get(1));
        msgChannel.sendMessage(vChannel.get(0).getName() + " 채널에 들어갑니다.").queue();
    }

}