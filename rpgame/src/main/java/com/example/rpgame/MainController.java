package com.example.rpgame;

import com.example.rpgame.dao.CommandRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;


@Component
public class MainController {
    private CommandRepository commandRepository;
    private RpgCharacter rpgCharacter;

    MainController(CommandRepository commandRepository, RpgCharacter rpgCharacter){
        this.commandRepository = commandRepository;
        this.rpgCharacter = rpgCharacter;
    }

    public void acceptCommand(String userInput) throws Exception {
        System.out.println("接收到的命令: " + userInput);
        CommandParam commandParam = checkCommand(userInput);
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.execute(commandParam);
    }

    public CommandParam checkCommand(String userInput) throws Exception {
        String[] commands = userInput.split("\\s+");
        String command = commands[0];
        int count = 1;
        if("使用".equals(command) && commands.length == 1) throw new Exception("缺少必要參數");
        if("裝備".equals(command) && commands.length == 1) throw new Exception("缺少必要參數");
        if("卸下".equals(command) && commands.length == 1) throw new Exception("缺少必要參數");
        if("探索".equals(command) && commands.length == 1) throw new Exception("缺少必要參數");
        if("製作".equals(command)){
            if (commands.length == 1) throw new Exception("缺少必要參數");
            if (commands.length > 2) count = Integer.valueOf(commands[2]);
        }
        if("市場登記".equals(command)){
            if(commands.length == 1) throw new Exception("缺少必要參數");
            if(commands.length > 2) count = Integer.valueOf(commands[2]);
        }
        if("市場購買".equals(command)){
            if(commands.length == 1) throw new Exception("缺少必要參數");
            if(commands.length > 2) count = Integer.valueOf(commands[2]);
        }

        return new CommandParam(command, commands[1], count);
    }

}
