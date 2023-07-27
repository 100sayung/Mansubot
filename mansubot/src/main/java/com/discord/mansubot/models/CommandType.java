package com.discord.mansubot.models;

import javax.persistence.*;

import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CommandTextEntry")
@Getter
@Setter
@NoArgsConstructor
public class CommandType {
    @Id
    @Column(name = "CommandTextType", length = 255, nullable = false)
    private String commandTextType;

    @Column(name = "CommandTextTypeDetail", length = 255)
    private String commandTextTypeDetail;

    // Getters and setters, constructors, and other methods...

    public CommandType(CommandType CommandType){
        BeanUtils.copyProperties(CommandType, this);
    }

}
