package com.example.rpgame;

import com.example.rpgame.dao.PlayerRepository;
import com.example.rpgame.entity.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RpgCharacter {
    private PlayerRepository playerRepository;

    RpgCharacter(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void signUp(){
        System.out.println("sign up");
        UUID uuid = UUID.randomUUID();
        Player player = new Player();
        player.setId(uuid.toString());
        player.setPlayerName("隨機名字");
        player.setHp(100);
        player.setMaxHp(100);
        player.setStamina(50);
        player.setMaxStamina(50);
        player.setAtk(10);
        player.setDef(5);
        player.setWeaponId(0);
        player.setArmorId(0);
        player.setDailyTaskId(0);
        player.setDailyTaskStatus(0);

        playerRepository.save(player);
    }

    static void showStatus(){
        System.out.println("status");
    }
}
