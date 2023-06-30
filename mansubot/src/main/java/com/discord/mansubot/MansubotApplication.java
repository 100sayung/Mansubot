package com.discord.mansubot;

import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.discord.mansubot.listener.MansuBotListener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

@SpringBootApplication
public class MansubotApplication {

	public static void main(String[] args) throws LoginException {
		SpringApplication.run(MansubotApplication.class, args);

        JDA jda = JDABuilder.createDefault("MTEyMzA3MDUzOTA0OTc0MjM0Nw.G0Ov6I.wH3RD5qqenH2myZueVn1D_68rdYcgPVrsZfO-8")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // enables explicit access to message.getContentDisplay()
                .addEventListeners(new MansuBotListener()) //Eventlistner 등록
                .setActivity(Activity.playing("Code TEST")) //~~ 하는중 표시
				.build();
	}
}
