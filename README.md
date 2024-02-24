# game-manager
## ユースケース図
![usecase](https://github.com/renangton/game-manager/assets/97335620/bf52a2ac-94bd-4419-a4d5-2a7f6ed6dcd3)

## ドメインモデル図
![domainmodel](https://github.com/renangton/game-manager/assets/97335620/a96d6887-9a0f-4520-add4-f68433e71895)

## データベース定義
### ゲームテーブル
| 論理名         | 物理名    | 型       | 桁数 | Nullable | その他          |
|--------------|---------|---------|-----|---------|----------------|
| ゲームID     | id      | char    | 26  | NO      | PK 採番はULID   |
| ゲーム名     | game_name | VARCHAR | 20  | NO      |                |
| 対応ジャンルID | genre_id | char    | 26  | NO      | FK             |
| 価格         | price   | int     | 10  | NO      |                |
### ジャンルテーブル
| 論理名     | 物理名     | 型       | 桁数 | Nullable | その他          |
|----------|----------|---------|-----|---------|----------------|
| ジャンルID | id       | char    | 26  | NO      | PK 採番はULID   |
| ジャンル名 | genre_name | VARCHAR | 20  | NO      |                |
### プラットフォームテーブル
| 論理名         | 物理名         | 型       | 桁数 | Nullable | その他          |
|--------------|--------------|---------|-----|---------|----------------|
| プラットフォームID | id           | char    | 26  | NO      | PK 採番はULID   |
| プラットフォーム名 | platform_name | VARCHAR | 20  | NO      |                |
### ゲームプラットフォームテーブル
| 論理名             | 物理名       | 型       | 桁数 | Nullable | その他                   |
|------------------|------------|---------|-----|---------|------------------------|
| ゲームプラットフォームID | id       | int     | -   | NO      | PK 採番はAUTO_INCREMENT |
| ゲームID           | game_id    | char    | 26  | NO      | FK                      |
| プラットフォームID   | platform_id | char    | 26  | NO      | FK                      |
