# 資料庫定義

---

## 1. ListItem

定義所有物品。

```sql
CREATE TABLE ListItem (
    item_id INTEGER PRIMARY KEY AUTOINCREMENT,
    item_name TEXT NOT NULL UNIQUE,
    item_type TEXT NOT NULL CHECK(item_type IN ('消耗品', '材料', '工具', '武器', '身體', '頭部', '腿部', '飾品')),
    description TEXT,
    -- 效果相關
    effect_type TEXT, -- 例如: 'HP', 'ATK', 'DEF'
    effect_value INTEGER,
    -- 工具屬性
    durability INTEGER,
    -- 裝備屬性
    atk_bonus INTEGER,
    def_bonus INTEGER
);
```

## 2. ListMonster

定義所有怪物。

```sql
CREATE TABLE ListMonster (
    monster_id INTEGER PRIMARY KEY AUTOINCREMENT,
    monster_name TEXT NOT NULL UNIQUE,
    hp INTEGER NOT NULL,
    atk INTEGER NOT NULL,
    def INTEGER NOT NULL,
    gold_drop INTEGER NOT NULL
);
```

## 3. MonsterDrops

定義怪物的掉落物 (多對多關係)。

```sql
CREATE TABLE MonsterDrops (
    monster_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    drop_chance REAL NOT NULL, -- 掉落機率 (0.0 to 1.0)
    PRIMARY KEY (monster_id, item_id),
    FOREIGN KEY (monster_id) REFERENCES ListMonster(monster_id),
    FOREIGN KEY (item_id) REFERENCES ListItem(item_id)
);
```

## 4. ListEvent

定義探索時可能發生的事件。

```sql
CREATE TABLE ListEvent (
    event_id INTEGER PRIMARY KEY AUTOINCREMENT,
    event_type TEXT NOT NULL CHECK(event_type IN ('資源發現', '遭遇怪物', '寶箱/金錢', '增益事件', '減益事件', '空手而歸')),
    description_template TEXT NOT NULL, -- 例如: '你在草叢中找到了一些 [藥草]。'
    base_probability REAL NOT NULL
);
```

## 5. ListFormula

定義製作配方。

```sql
CREATE TABLE ListFormula (
    formula_id INTEGER PRIMARY KEY AUTOINCREMENT,
    output_item_id INTEGER NOT NULL,
    output_quantity INTEGER NOT NULL DEFAULT 1,
    stamina_cost INTEGER NOT NULL,
    FOREIGN KEY (output_item_id) REFERENCES ListItem(item_id)
);
```

## 6. FormulaRequirements

定義配方所需的材料 (多對多關係)。

```sql
CREATE TABLE FormulaRequirements (
    formula_id INTEGER NOT NULL,
    required_item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (formula_id, required_item_id),
    FOREIGN KEY (formula_id) REFERENCES ListFormula(formula_id),
    FOREIGN KEY (required_item_id) REFERENCES ListItem(item_id)
);
```

## 7. ListTask

定義所有每日任務。

```sql
CREATE TABLE ListTask (
    task_id INTEGER PRIMARY KEY AUTOINCREMENT,
    task_type TEXT NOT NULL CHECK(task_type IN ('討伐', '收集')),
    title TEXT NOT NULL,
    description TEXT NOT NULL,
    target_id INTEGER, -- 可以是 monster_id 或 item_id
    required_count INTEGER NOT NULL,
    reward_gold INTEGER
    -- 如果有物品獎勵,可以再加一個 reward_item_id
);
```

## 8. Players

紀錄玩家屬性、裝備、每日任務狀態。

```sql
CREATE TABLE Players (
    player_id TEXT PRIMARY KEY, -- 使用 LINE User ID
    player_name TEXT NOT NULL,
    hp INTEGER NOT NULL,
    max_hp INTEGER NOT NULL,
    stamina INTEGER NOT NULL,
    max_stamina INTEGER NOT NULL,
    atk INTEGER NOT NULL,
    def INTEGER NOT NULL,
    gold INTEGER NOT NULL,
    last_stamina_update TEXT NOT NULL, -- ISO 8601 格式
    -- 裝備
    weapon_id INTEGER,
    head_id INTEGER,
    body_id INTEGER,
    legs_id INTEGER,
    accessory_id INTEGER,
    -- 每日任務
    daily_task_id INTEGER,
    daily_task_progress INTEGER,
    daily_task_completed BOOLEAN,
    FOREIGN KEY (weapon_id) REFERENCES ListItem(item_id),
    FOREIGN KEY (head_id) REFERENCES ListItem(item_id),
    FOREIGN KEY (body_id) REFERENCES ListItem(item_id),
    FOREIGN KEY (legs_id) REFERENCES ListItem(item_id),
    FOREIGN KEY (accessory_id) REFERENCES ListItem(item_id),
    FOREIGN KEY (daily_task_id) REFERENCES ListTask(task_id)
);
```

## 9. PlayersBackpack

紀錄玩家背包內物品。

```sql
CREATE TABLE PlayersBackpack (
    player_id TEXT NOT NULL,
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (player_id, item_id),
    FOREIGN KEY (player_id) REFERENCES Players(player_id),
    FOREIGN KEY (item_id) REFERENCES ListItem(item_id)
);
```

## 10. Market

紀錄市場上架的商品。

```sql
CREATE TABLE Market (
    listing_id INTEGER PRIMARY KEY AUTOINCREMENT,
    seller_id TEXT NOT NULL,
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    price_per_unit INTEGER NOT NULL,
    created_at TEXT NOT NULL, -- ISO 8601 格式
    FOREIGN KEY (seller_id) REFERENCES Players(player_id),
    FOREIGN KEY (item_id) REFERENCES ListItem(item_id)
);
```

## 11. Command

定義所有指令

``` sql
drop table rpgame.command;
CREATE TABLE rpgame.Command (
    id INTEGER
    command TEXT,
    subcmd1 TEXT,
    method TEXT
);
```