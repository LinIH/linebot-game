package com.example.rpgame;

import com.example.rpgame.dao.CommandRepository;
import org.springframework.stereotype.Component;

@Component
public class MainController {
    private final CommandRepository commandRepository;
    private final RpgCharacter rpgCharacter;
    private final CommandExecutor commandExecutor;

    MainController(CommandRepository commandRepository, RpgCharacter rpgCharacter, CommandExecutor commandExecutor){
        this.commandRepository = commandRepository;
        this.rpgCharacter = rpgCharacter;
        this.commandExecutor = commandExecutor;
    }

    public void acceptCommand(String userId, String userInput) throws Exception {
        System.out.println("接收到的命令: " + userInput);
        CommandParam commandParam = checkCommand(userId, userInput);
        commandExecutor.execute(commandParam);
    }

    public CommandParam checkCommand(String userId, String userInput) throws Exception {
        String[] commands = userInput.split("\\s+");
        String command0 = commands[0];
        String command1 = commands.length > 1 ? commands[1] : "";
        int count = 1;
        if("".equals(command0)) throw new Exception("缺少必要參數");
        if("使用".equals(command0) && commands.length == 1) throw new Exception("缺少必要參數");
        if("裝備".equals(command0) && commands.length == 1) throw new Exception("缺少必要參數");
        if("卸下".equals(command0) && commands.length == 1) throw new Exception("缺少必要參數");
        if("探索".equals(command0) && commands.length == 1) throw new Exception("缺少必要參數");
        if("製作".equals(command0)){
            if (commands.length == 1) throw new Exception("缺少必要參數");
            if (commands.length > 2) count = Integer.valueOf(commands[2]);
        }
        if("市場登記".equals(command0)){
            if(commands.length == 1) throw new Exception("缺少必要參數");
            if(commands.length > 2) count = Integer.valueOf(commands[2]);
        }
        if("市場購買".equals(command0)){
            if(commands.length == 1) throw new Exception("缺少必要參數");
            if(commands.length > 2) count = Integer.valueOf(commands[2]);
        }


        return new CommandParam(userId, command0, command1, count);
    }

}
