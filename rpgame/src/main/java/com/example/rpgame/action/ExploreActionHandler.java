package com.example.rpgame.action;

import com.example.rpgame.CommandParam;
import com.example.rpgame.dao.ListEventRepository;
import com.example.rpgame.dao.PlayerRepository;
import com.example.rpgame.entity.ListEvent;
import com.example.rpgame.entity.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class ExploreActionHandler {

    private final PlayerRepository playerRepository;
    private final ListEventRepository listEventRepository;
    private final Random random = new Random();

    public ExploreActionHandler(PlayerRepository playerRepository, ListEventRepository listEventRepository) {
        this.playerRepository = playerRepository;
        this.listEventRepository = listEventRepository;
    }

    public void explore(CommandParam commandParam) {
        Optional<Player> playerOpt = playerRepository.findById(commandParam.getUserId());
        if (playerOpt.isEmpty()) {
            System.out.println("找不到您的角色資料，請先輸入 '註冊' 。");
            return;
        }

        Player player = playerOpt.get();
        int staminaCost = 10;
        if (player.getStamina() < staminaCost) {
            System.out.println("體力不足，無法探索。");
            return;
        }

        player.setStamina(player.getStamina() - staminaCost);

        // 觸發隨機事件
        triggerRandomEvent(player);

        playerRepository.save(player);
    }

    private void triggerRandomEvent(Player player) {
        List<ListEvent> events = listEventRepository.findAll();
        if (events.isEmpty()) {
            System.out.println("你仔細搜索了這片區域，但什麼也沒找到。");
            return;
        }

        double totalWeight = events.stream().mapToDouble(ListEvent::getBaseProbability).sum();
        double randomValue = random.nextDouble() * totalWeight;

        ListEvent selectedEvent = null;
        for (ListEvent event : events) {
            randomValue -= event.getBaseProbability();
            if (randomValue <= 0) {
                selectedEvent = event;
                break;
            }
        }

        if (selectedEvent == null) {
            selectedEvent = events.get(events.size() - 1);
        }

        // 根據事件類型處理
        handleEvent(player, selectedEvent);
    }

    private void handleEvent(Player player, ListEvent event) {
        System.out.println("觸發事件: " + event.getEventType()); // 用於測試

        switch (event.getEventType()) {
            case "寶箱/金錢":
                int goldGained = 50; // 範例，應從 event 或另一張表取得
                player.setGold(player.getGold() + goldGained);
                System.out.println(event.getDescriptionTemplate().replace("50", String.valueOf(goldGained)));
                break;
            case "增益事件":
                int staminaGained = 20; // 範例
                player.setStamina(Math.min(player.getMaxStamina(), player.getStamina() + staminaGained));
                 System.out.println(event.getDescriptionTemplate().replace("20", String.valueOf(staminaGained)));
                break;
            case "減益事件":
                int hpLost = 10; // 範例
                player.setHp(Math.max(0, player.getHp() - hpLost));
                 System.out.println(event.getDescriptionTemplate().replace("10", String.valueOf(hpLost)));
                break;
            case "空手而歸":
                System.out.println(event.getDescriptionTemplate());
                break;
            case "資源發現":
                // TODO: 實作資源發現邏輯
                System.out.println("你發現了資源！（待實作）");
                System.out.println(event.getDescriptionTemplate());
                break;
            case "遭遇怪物":
                // TODO: 實作遭遇怪物邏輯
                System.out.println("遭遇了怪物！（待實作）");
                System.out.println(event.getDescriptionTemplate());
                break;
            default:
                System.out.println("未知的事件類型。");
                break;
        }
    }


    public void fight() {
        System.out.println("fight (待實作)");
    }

    public void escape() {
        System.out.println("escape (待實作)");
    }
}
