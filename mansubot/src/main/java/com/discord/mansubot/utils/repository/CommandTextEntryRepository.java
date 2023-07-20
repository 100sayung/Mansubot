package com.discord.mansubot.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandTextEntryRepository extends JpaRepository<CommandTextEntry, String> {
}
