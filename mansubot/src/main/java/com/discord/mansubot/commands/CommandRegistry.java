package com.discord.mansubot.commands;

import java.util.*;

public class CommandRegistry {
    
    private final Map<String, Command> commandMap;
    
    public CommandRegistry(){
        this.commandMap = new HashMap<>();
        commandMap.put("!play", new PlayCommand());
        commandMap.put("!ea", new EaCommand());
        commandMap.put("!dia", new DiaCommand());
        commandMap.put("!tft", new TftCommand());
        commandMap.put("!stone", new StoneCommand());
        commandMap.put("!other", new OtherCommand());
        commandMap.put("!help", new OtherCommand());
    }

    public Command getCommand(String commandName){
        return commandMap.get(commandName);
    }
}
