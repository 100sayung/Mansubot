package com.discord.mansubot.models;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.Date;
import javax.persistence.*;


import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "CommandEntry")
@Getter
@Setter
@Accessors(chain =  true)
@NoArgsConstructor
public class CommandEntry {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UserCommandId", columnDefinition = "VARCHAR(36)", nullable = false, updatable = false)
    private UUID userCommandId;

    @Column(name = "UserId", length = 255, nullable = false)
    private String userId;

    @Column(name = "CommandName", length = 255, nullable = false)
    private String commandName;

    @Column(name = "CommandArg", length = 255, nullable = false)
    private String commandArg;

    @Column(name = "Timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "GuildId", length = 255)
    private String GuildId;

    @Column(name = "ChannelId", length = 255)
    private String channelId;

    @PrePersist
    protected void onCreate(){
        timestamp = new Date();
    }
}
