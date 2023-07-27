package com.discord.mansubot.utils.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discord.mansubot.models.CommandEntry;

@Service
public class CommandEntryService {
    @Autowired
    CommandEntryRepository commandEntryRepository;
    

     public void saveCommandEntry(CommandEntry commandEntry) {
         commandEntryRepository.save(commandEntry);
     }

}
