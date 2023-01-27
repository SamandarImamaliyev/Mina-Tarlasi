package minaTarlasi;

import java.util.Random;
import java.util.Scanner;

//Secdiyim yerin etrafinda hec bir mina yoxdursa onda secdiyimiz yerde -2 qeyd olunacaq,
//yox eger secdiyimiz yerin etrafinda mina var ise, hemin xanada hemin minalarin sayi qeder reqem  yazilacaq
//mina olan yerleri ise -1 ile bildiririk

public class MinaTarlasi {
	private int rowCount;
	private int columnCount;
	private int size;
	private int success = 0;
	private boolean game = true;
	private int[][] mapMayin;// mayin tarlasinin arxa plandaki uzu
	private int[][] boardMayin;// mayin tarlasinin usere gosterilen uzu

	private Random random = new Random();
	private Scanner sc = new Scanner(System.in);

	public MinaTarlasi(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.mapMayin = new int[rowCount][columnCount];
		this.boardMayin = new int[rowCount][columnCount];
		this.size = rowCount * columnCount;

	}

	public void run() {
		createMap();
//		print(mapMayin);
		System.out.println("Oyun Basladi!");
		while (game) {
			int row;
			int column;

			print(boardMayin);
			System.out.print("Sirani sec: ");
			row = sc.nextInt();
			System.out.print("Sutunu sec: ");
			column = sc.nextInt();

			if (row < 0 || row > rowCount) {
				System.out.println("Ugursuz kordinat, tekrar yoxlayin!");
				continue;
			}

			if (column < 0 || column > columnCount) {
				System.out.println("Ugursuz kordinat, tekrar yoxlayin!");
				continue;
			}
			if (mapMayin[row][column] != -1) {
				if (boardMayin[row][column] == 0) {
					check(row, column);
					success++;
//					System.out.println("succes=" + success);
//					System.out.println("size= " + (size - (size / 4)));
					if (success == size - (size / 4)) {
						System.out.println("Bacardiniz, hec bir minaya toxunmadiniz!");
						print(boardMayin);
						System.out.println("Minalarin xeritesi: ");
						print(mapMayin);
						break;
					}
				} else {
					System.out.println("Bu kordinatlari artiq istifade etmisiniz!");
				}

			} else {
				game = false;
				System.out.println("Game Over!");
			}
		}
	}

	private void check(int r, int c) {
		if (boardMayin[r][c] == 0) {
			if ((c < columnCount - 1) && (mapMayin[r][c + 1] == -1)) {
				boardMayin[r][c]++;
			}
			if ((c > 0) && (mapMayin[r][c - 1] == -1)) {
				boardMayin[r][c]++;
			}
			if ((r < rowCount - 1) && (mapMayin[r + 1][c] == -1)) {
				boardMayin[r][c]++;
			}
			if ((r > 0) && (mapMayin[r - 1][c] == -1)) {
				boardMayin[r][c]++;
			}

			if (boardMayin[r][c] == 0) {// yuxardakilarin hec biri dogru deyilse demeli etrafinda hec bir mina yoxdur ve
										// hemin xana sifira beraber olur, buzaman burdaki sert odenir ve hemin xanaya
										// -2 qeyd olunur
				boardMayin[r][c] = -2;
			}
		}
	}

	private void createMap() {
		int randomRow;
		int randomColumn;
		int count = 0;

		while (count != (size / 4)) {
			randomRow = random.nextInt(rowCount);
			randomColumn = random.nextInt(columnCount);
			if (mapMayin[randomRow][randomColumn] != -1) {
				mapMayin[randomRow][randomColumn] = -1;
				count++;
			}
		}

	}

	private void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();
		}
	}
}
