package de.broccolidev.aopdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Account {

    private String name;
    private String level;

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

}
