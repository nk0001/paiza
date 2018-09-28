package paiza;

import java.util.Scanner;

public class Banmen {

	public static void main(String[] args) {
		int[][] stage = new int[8][8]; //白(0),黒(1),空き(-1)

		// 初期化
		for(int i = 0; i < stage.length; i++) {
			for(int j = 0; j < stage[0].length; j++) {
				stage[i][j] = -1;
			}
		}
		stage[3][3] = 0;
		stage[4][4] = 0;
		stage[3][4] = 1;
		stage[4][3] = 1;

		Scanner sc = new Scanner(System.in);
        int term = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < term; i++) {
        	String[] log = sc.nextLine().split(" ");
        	String player = log[0];
        	int posX = Integer.parseInt(log[1]) - 1;
        	int posY = Integer.parseInt(log[2]) - 1;

        	set(stage, player, posX, posY);

        	for(int j = 1; j <= 9; j++) {
        		reverse(0, j, stage, player, posX, posY);
        	}
        }

        String won;
        int[] result = jadge(stage);
        if(result[0] == 0) {
        	won = "The white won!";
        }else if(result[0] == 1) {
        	won = "The black won!";
        }else {
        	won = "Draw!";
        }
        System.out.printf("%02d-%02d %s\n", result[1], result[2], won);



        sc.close();
	}

	private static void set(int[][] stage, String player, int posX, int posY) {
		int nplayer;
		if("W".equals(player)) {
			nplayer = 0;
		}else {
			nplayer = 1;
		}
		stage[posX][posY] = nplayer;
	}

	private static int reverse(int status, int direction, int[][] stage, String player, int posX, int posY) {
		int myColoer;
		int enemyColor;

		if("W".equals(player)) {
			myColoer = 0;
			enemyColor = 1;
		}else {
			myColoer = 1;
			enemyColor = 0;
		}

		int x = 0;
		int y = 0;
		switch(direction) {
			case 1: x=posX + -1; y=posY + -1; break;
			case 2: x=posX + 0;  y=posY + -1; break;
			case 3: x=posX + 1;  y=posY + -1; break;
			case 4: x=posX + -1; y=posY + 0;  break;
			case 5: return 0;
			case 6: x=posX + 1;  y=posY + 0;  break;
			case 7: x=posX + -1; y=posY + 1;  break;
			case 8: x=posX + 0;  y=posY + 1;  break;
			case 9: x=posX + 1;  y=posY + 1;  break;
		}

		// 端
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return -1;
		}

		// 探索2回目以上
		if(status >= 1) {
			if(stage[x][y] == myColoer) {
				return 1;
			}
		}

		if(stage[x][y] == enemyColor) {
			int result = reverse(++status, direction, stage, player, x, y);
			if(result == 1) {
				stage[x][y] = myColoer;
				return 1;
			}
		}
		return -1;

	}

	private static int[] jadge(int[][] stage) {
		int my = 0;
		int enemy = 0;

		for(int i = 0; i < stage.length; i++) {
			for(int j = 0; j < stage[0].length; j++) {
				if(stage[i][j] == 0) {
					my++;
				}else if(stage[i][j] == 1) {
					enemy++;
				}
			}
		}
		if(my > enemy) {
			int[] result = {0, enemy, my};
			return result;
		}else if (my < enemy) {
			int[] result = {1, enemy, my};
			return result;
		}else {
			int[] result = {-1, enemy, my};
			return result;
		}

	}

}
