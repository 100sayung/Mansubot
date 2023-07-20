package com.discord.mansubot.models;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "CommandEntry")
public class CommandEntry {
    @Id
    @Column(name = "UserCommandId", length = 255, nullable = false)
    private String userCommandId;

    @Column(name = "UserId", length = 255, nullable = false)
    private String userId;

    @Column(name = "CommandText", length = 255, nullable = false)
    private String commandText;

    @Column(name = "Timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "CommandTextType", length = 255, nullable = false)
    private String commandTextType;

    @Column(name = "ServerId", length = 255)
    private String serverId;

    @Column(name = "ChannelId", length = 255)
    private String channelId;

    // Getters and setters, constructors, and other methods...
}
