package com.example.rpgame.action;

import com.example.rpgame.CommandParam;
import com.example.rpgame.dao.PlayerRepository;
import com.example.rpgame.entity.Player;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
public class CharacterActionHandler {
    private final PlayerRepository playerRepository;

    public CharacterActionHandler(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void signUp(CommandParam commandParam){
        Optional<Player> existingPlayer = playerRepository.findById(commandParam.getUserId());
        if (existingPlayer.isPresent()) {
            System.out.println("您已經註冊過了！");
            return;
        }

        Player player = new Player();
        player.setPlayerId(commandParam.getUserId());
        player.setPlayerName("玩家_" + commandParam.getUserId().substring(0, 4)); // 臨時命名
        player.setHp(100);
        player.setMaxHp(100);
        player.setStamina(50);
        player.setMaxStamina(50);
        player.setAtk(10);
        player.setDef(5);
        player.setGold(100);
        player.setLastStaminaUpdate(Instant.now().toString());

        playerRepository.save(player);
        System.out.println("角色創建成功！歡迎來到這個世界！");
    }

    public void showStatus(CommandParam commandParam){
        Optional<Player> playerOpt = playerRepository.findById(commandParam.getUserId());
        if (playerOpt.isEmpty()) {
            System.out.println("找不到您的角色資料，請先輸入 '註冊' 。");
            return;
        }

        Player player = playerOpt.get();
        StringBuilder sb = new StringBuilder();
        sb.append("--- 玩家狀態 ---\n");
        sb.append("名稱: ").append(player.getPlayerName()).append("\n");
        sb.append("HP: ").append(player.getHp()).append(" / ").append(player.getMaxHp()).append("\n");
        sb.append("體力: ").append(player.getStamina()).append(" / ").append(player.getMaxStamina()).append("\n");
        sb.append("攻擊力 (ATK): ").append(player.getAtk()).append("\n");
        sb.append("防禦力 (DEF): ").append(player.getDef()).append("\n");
        sb.append("金錢: ").append(player.getGold()).append(" 金\n");
        sb.append("----------------");

        System.out.println(sb.toString());
    }

    public void showBackpack(){
        System.out.println("show backpack");
    }

    public void useItem(CommandParam commandParam){
        System.out.println("use item" + commandParam.getItem());
    }

    public void equip(){
        System.out.println("equip");
    }

    public void unequipped(){
        System.out.println("unequipped");
    }

    public void manufacture(){
        System.out.println("manufacture");
    }

    public void missionCheck(){
        System.out.println("mission check");
    }

    public void showHelp(){
        System.out.println("show help");
    }
}
