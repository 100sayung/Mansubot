package com.discord.mansubot.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "CommandMusicTitle")
@Getter
@Setter
@Accessors(chain =  true)
@NoArgsConstructor
public class CommandMusicTitle {
    @Id
    @Column(name = "UserCommandId", length = 255, nullable = false)
    private String userCommandId;

    @Column(name = "UserId", length = 255, nullable = false)
    private String userId;

    @Column(name = "MusicTitle", length = 255, nullable = false)
    private String musicTitle;

    // Getters and setters, constructors, and other methods...
}
