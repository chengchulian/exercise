package day3;

import java.util.Scanner;

/**
 * author：WanAkiko
 * 指导老师：杨*宇
 */
public class GreedySnake {

    static Scanner sc = new Scanner(System.in);

    static int[][] map = new int[10][10];
    static int playerX = 1, playerY = 1; // 玩家坐标
    static int boxX = 8, boxY = 3; // 箱子坐标
    static int terminusX = 2, terminusY = 8; // 终点坐标

    public static void main(String[] args) {

        map[playerX][playerY] = 1; // 玩家坐标对应的值
        map[boxX][boxY] = 2; // 箱子坐标对应的值
        map[terminusX][terminusY] = 3; // 终点坐标对应的值
        boolean starFlag = false;

        while (true) {
            InitializationMap(); // 初始化地图

            try {
                TheInputPrompt(); // 玩家行动
            } catch (Exception e) {
                System.out.println("提示：您已越界，游戏失败！");
                return;
            }

            GoIntoAction(); // 坐标更迭

            // 星星奖励
            if (playerX == 2 && playerY == 8) {
                starFlag = true;
                TheStarAwards();
                System.out.println("(*^▽^*)画个星星祝福你！！！\n");
            }

            // 到达终点
            if (playerX == 8 && playerY == 3) {
                CongratulationsToPass();
                break;
            }
        }

    }

    /**
     * 恭喜过关
     */
    private static void CongratulationsToPass() {
        System.out.println("※※※※※※※※※※※※※※※");
        System.out.println("※■■■■■■■■■■■■■※");
        System.out.println("※■■■■恭喜过关！■■■■※");
        System.out.println("※■■■■■■■■■■■■■※");
        System.out.println("※※※※※※※※※※※※※※※");
        InitializationMap();
    }

    /**
     * 星星奖励
     * 源代码：https://blog.csdn.net/qq_44645104/article/details/89458986
     */
    private static void TheStarAwards() {
        int touHigh = 6;
        int jianHigh = 25;
        int kuang = 50;
        for (int i = 1; i <= touHigh + jianHigh; i++) {
            for (int j = 1; j <= kuang; j++) {
                // 上三角
                if (i <= touHigh) {
                    if (j >= (kuang / 2 + 1) + 1 - i && j <= (kuang / 2 + 1) - 1 + i) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                // 上半部分
                if (i > touHigh && i <= jianHigh) {
                    if (j >= (kuang / 2 + 1) + 2 - i && j <= kuang - 3 * (i - touHigh)) {
                        System.out.print("*");
                    } else if (j < (kuang / 2 + 1) - 3 + i && j >= 3 * (i - touHigh)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }

    /**
     * 开始行动
     */
    private static void GoIntoAction() {
        if ("w".equals(sc)) {
            if (map[playerX - 1][playerY] == map[boxX][boxY]) {
                boxX--;
                map[boxX][boxY] = 2;
            }
            map[playerX][playerY] = 0;
            playerX--;
            map[playerX][playerY] = 1;
        } else if ("s".equals(sc)) {
            if (map[playerX - 1][playerY] == map[boxX][boxY]) {
                boxX++;
                map[boxX][boxY] = 2;
            }
            map[playerX][playerY] = 0;
            playerX++;
            map[playerX][playerY] = 1;
        } else if ("a".equals(sc)) {
            if (map[playerX - 1][playerY] == map[boxX][boxY]) {
                boxY--;
                map[boxX][boxY] = 2;
            }
            map[playerX][playerY] = 0;
            playerY--;
            map[playerX][playerY] = 1;
        } else if ("d".equals(sc)) {
            if (map[playerX - 1][playerY] == map[boxX][boxY]) {
                boxY++;
                map[boxX][boxY] = 2;
            }
            map[playerX][playerY] = 0;
            playerY++;
            map[playerX][playerY] = 1;
        }
    }

    /**
     * 输入提示
     */
    private static void TheInputPrompt() {
        System.out.println("移动指示：上-w 下-s 左-a 右-d");
        System.out.print("请输入：");
        String move = sc.next();
        switch (move) {
            case "w":
                map[playerX][playerY] = 0;
                playerX--;
                map[playerX][playerY] = 1;
                break;
            case "s":
                map[playerX][playerY] = 0;
                playerX++;
                map[playerX][playerY] = 1;
                break;
            case "a":
                map[playerX][playerY] = 0;
                playerY--;
                map[playerX][playerY] = 1;
                break;
            case "d":
                map[playerX][playerY] = 0;
                playerY++;
                map[playerX][playerY] = 1;
                break;
            default:
                System.out.println("提示：输入有误，请重新输入！");
                break;
        }
    }

    /**
     * 初始化地图
     */
    private static void InitializationMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    System.out.print("人 ");
                } else if (map[i][j] == 2) {
                    System.out.print("■ ");
                } else if (map[i][j] == 3) {
                    System.out.print("★ ");
                } else {
                    System.out.print("□ ");
                }
            }
            System.out.println();
        }
    }

}
