package com.example.rpgame;

import com.example.rpgame.action.CharacterActionHandler;
import com.example.rpgame.action.ExploreActionHandler;
import com.example.rpgame.action.MarketActionHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class CommandExecutor {
    private Map<String, Consumer<CommandParam>> commandMap = new HashMap<>();
    private final CharacterActionHandler characterActionHandler;
    private final MarketActionHandler marketActionHandler;
    private final ExploreActionHandler exploreActionHandler;

    CommandExecutor(CharacterActionHandler characterActionHandler, MarketActionHandler marketActionHandler, ExploreActionHandler exploreActionHandler){
        this.characterActionHandler = characterActionHandler;
        this.marketActionHandler = marketActionHandler;
        this.exploreActionHandler = exploreActionHandler;
        initializeCommand();
    }

    private void initializeCommand(){
        commandMap.put("註冊", args -> characterActionHandler.signUp(args));
        commandMap.put("狀態", args -> characterActionHandler.showStatus(args));
        commandMap.put("背包", args -> characterActionHandler.showBackpack());
        commandMap.put("使用", args -> characterActionHandler.useItem(args));
        commandMap.put("裝備", args -> characterActionHandler.equip());
        commandMap.put("卸下", args -> characterActionHandler.unequipped());
        commandMap.put("探索", args -> exploreActionHandler.explore(args));
        commandMap.put("戰鬥", args -> exploreActionHandler.fight());
        commandMap.put("逃跑", args -> exploreActionHandler.escape());
        commandMap.put("製作", args -> characterActionHandler.manufacture());
        commandMap.put("市場", args -> marketActionHandler.showMarket());
        commandMap.put("市場登記", args -> marketActionHandler.sellInMarket());
        commandMap.put("市場購買", args -> marketActionHandler.buyInMarket());
        commandMap.put("任務回報", args -> characterActionHandler.missionCheck());
        commandMap.put("幫助", args -> characterActionHandler.showHelp());
    }

    public void execute(CommandParam commandParam) throws Exception {
        Consumer<CommandParam> action = commandMap.get(commandParam.getCommand());
        if(action != null){
            action.accept(commandParam);
        }
        else {
            throw new Exception("unknown command");
        }
    }
}
