package com.discord.mansubot.models;

import javax.persistence.*;

@Entity
@Table(name = "CommandMusicList")
public class CommandMusicList {
    @Id
    @Column(name = "UserCommandId", length = 255, nullable = false)
    private String userCommandId;

    @Column(name = "UserId", length = 255, nullable = false)
    private String userId;

    @Column(name = "MusicTitle", length = 255, nullable = false)
    private String musicTitle;

    // Getters and setters, constructors, and other methods...
}
