package com.discord.mansubot.commands;


import com.discord.mansubot.models.CommandEntry;
import com.discord.mansubot.utils.repository.CommandEntryService;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandProcessor {
    private final CommandRegistry commandRegistry;
    private final CommandEntryService cEntryService;

    @Autowired
    public CommandProcessor(
        CommandEntryService cEntryService
    ) {
        this.commandRegistry = new CommandRegistry();
        this.cEntryService = cEntryService;
    }



    public void processCommand(MessageReceivedEvent event){

        Message message = event.getMessage();
        String content = message.getContentRaw(); //메시지 내용 = content
        Guild guild = event.getGuild();
        MessageChannel msgChannel = event.getChannel();
        User user = event.getAuthor();
        //!로 시작하면 !를 제외한 내용 출력
        //User 정보는 event.getAuthor 로 빼기 가능 (usersnowflake user)


        String[] parts = content.trim().split("\\s+", 2);
        String commandName = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";
        Command command = commandRegistry.getCommand(commandName);

        if(command != null){
            command.execute(event, parts);
            
            CommandEntry cEntry = new CommandEntry();
            cEntry.setUserId(user.getName())
                  .setCommandName(commandName)
                  .setCommandArg(arguments)
                  .setGuildId(guild.getName())
                  .setChannelId(msgChannel.getName());
            
            cEntryService.saveCommandEntry(cEntry);
            if("!play".equals(commandName)){
                
            }
        }else{
            System.out.println("Invalid command : " + content);
        }
    }

    public void saveCommandMusicTitle(){

    }


}
