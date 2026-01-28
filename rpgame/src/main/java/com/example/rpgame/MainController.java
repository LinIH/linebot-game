package com.example.rpgame;

import com.example.rpgame.dao.CommandRepository;
import org.springframework.stereotype.Component;


@Component
public class MainController {
    private CommandRepository commandRepository;
    private RpgCharacter rpgCharacter;

    MainController(CommandRepository commandRepository, RpgCharacter rpgCharacter){
        this.commandRepository = commandRepository;
        this.rpgCharacter = rpgCharacter;
    }

    public void acceptCommand(String userInput) {
        System.out.println("接收到的命令: " + userInput);
        String[] commands = userInput.split("\\s+");
        String command = commands[0];
        String subcmd1 = "";
        if (commands.length > 1){
            subcmd1 = commands[1];
        }
        String method = commandRepository.findByCommandAndSubcmd1(command, subcmd1).getMethod();
        System.out.println("method = " + method);
        switch (method){
            case "signup":
                rpgCharacter.signUp();
                break;
        }
    }

}
