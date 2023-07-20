package com.discord.mansubot.models;

import javax.persistence.*;

@Entity
@Table(name = "CommandTextEntry")
public class CommandTextEntry {
    @Id
    @Column(name = "CommandTextType", length = 255, nullable = false)
    private String commandTextType;

    @Column(name = "CommandTextTypeDetail", length = 255)
    private String commandTextTypeDetail;

    // Getters and setters, constructors, and other methods...
}
