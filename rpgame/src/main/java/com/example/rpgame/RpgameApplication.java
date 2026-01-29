package com.example.rpgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; // 導入 ApplicationContext

import java.util.Scanner;

@SpringBootApplication
public class RpgameApplication {
	public static void main(String[] args) throws Exception {
		// 啟動 Spring Boot 應用並獲取 ApplicationContext
		ApplicationContext context = SpringApplication.run(RpgameApplication.class, args);
		MainController mc = context.getBean(MainController.class);
		RpgCharacter rpgCharacter = context.getBean(RpgCharacter.class);

		Scanner sc = new Scanner(System.in);
		
		System.out.println("====== 遊戲命令輸入 ======");
		System.out.println("輸入 '註冊' 進行玩家登入");
		System.out.println("輸入 '狀態' 查詢玩家狀態");
		System.out.println("輸入 '攻擊 <目標>' 進行攻擊 (例如：攻擊 哥布林)");
		System.out.println("輸入 '使用物品 <物品名稱> <數量>' 使用物品 (例如：使用物品 紅藥水 3)");
		System.out.println("輸入 '-1' 結束遊戲");
		System.out.println("==========================");

		String input = "";
		while(!(input = sc.nextLine()).equals("-1")){
			mc.acceptCommand(input);
		}
		System.out.println("---end...");
		sc.close(); // 關閉 Scanner
	}

}
