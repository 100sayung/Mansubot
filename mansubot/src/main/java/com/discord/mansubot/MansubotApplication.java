package com.discord.mansubot;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.discord.mansubot.listener.MansuBotListener;
import com.discord.mansubot.utils.repository.CommandEntryService;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

@SpringBootApplication
public class MansubotApplication {

	public static void main(String[] args) throws LoginException {
		ApplicationContext context = SpringApplication.run(MansubotApplication.class, args);
        DiscordToken discordTokenEntity = context.getBean(DiscordToken.class);
        String discordToken = discordTokenEntity.getToken();

        CommandEntryService cEntryService = context.getBean(CommandEntryService.class);
        JDA jda = JDABuilder.createDefault(discordToken)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // enables explicit access to message.getContentDisplay()
                .addEventListeners(new MansuBotListener(cEntryService)) //Eventlistner 등록
                .setActivity(Activity.playing("Code TEST")) //~~ 하는중 표시
				.build();

   //    WebScraper.helltidesTest();

        // CommandTextEntry entry = new CommandTextEntry();
        // entry.setCommandTextType("Music");
        // entry.setCommandTextTypeDetail("Played Music Title");
        // System.out.println(entry.getCommandTextTypeDetail());

        // CommandTextEntryService cteService = context.getBean(CommandTextEntryService.class);
        // cteService.saveCommandTextEntry(entry);


        
	}

    @Component
    public class DiscordToken{
        @Value("${discord.token}")
        private String token;

        public String getToken(){
            return token;
        }
    }
}
