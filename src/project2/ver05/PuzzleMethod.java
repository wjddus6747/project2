package project2.ver05;

import java.util.Scanner;

public class PuzzleMethod
{

	public String[][] puzzleArrayInit()
	{
		String[][] pa = new String[3][3];
		String adws;
		int num = 1;
		System.out.println("퍼즐 초기화");
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				pa[i][j] = Integer.toString(num);
				num++;

				if (i == 2 && j == 2)
				{
					pa[i][j] = "X";
				}
				System.out.print(pa[i][j] + " ");
			}
			System.out.println("\n");
		}
		return pa;
	}

	public String[][] puzlSuffle(String[][] pa)
	{
		for (int i = 1; i <= 3; i++)
		{
			int random = (int) (Math.random() * 4);
			String wasd = null;
			switch (random)
			{
			case 0:
				wasd = "w";
				pa = move(pa, wasd);
				break;

			case 1:
				wasd = "a";
				pa = move(pa, wasd);
				break;

			case 2:
				wasd = "s";
				pa = move(pa, wasd);
				break;

			case 3:
				wasd = "d";
				pa = move(pa, wasd);
				break;
			}
		}
		return pa;
	}

	public String[][] move(String[][] puzzleArr, String adws)
	{
		System.out.println("바보");
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				if (puzzleArr[x][y].equals("X"))
				{
					String temp = null;
					System.out.print(x + " ");
					System.out.println(y);

					if (adws.equals("w"))
					{
						if (x == 0 || x == 1)
						{
							System.out.println("w입력");
							temp = puzzleArr[x + 1][y];
							puzzleArr[x][y] = null;
							puzzleArr[x][y] = temp;
							puzzleArr[x + 1][y] = null;
							puzzleArr[x + 1][y] = "X";
							x = 3;
							break;
						}

					}

					if (adws.equals("s"))
					{
						if (x == 1 || x == 2)
						{
							System.out.println("s입력");
							temp = puzzleArr[x - 1][y];
							puzzleArr[x][y] = null;
							puzzleArr[x - 1][y] = null;
							puzzleArr[x][y] = temp;
							puzzleArr[x - 1][y] = "X";
							break;
						}
					}

					if (adws.equals("a"))
					{
						if (y == 0 || y == 1)
						{
							System.out.println("a입력");
							temp = puzzleArr[x][y + 1];
							puzzleArr[x][y] = null;
							puzzleArr[x][y] = temp;
							puzzleArr[x][y + 1] = null;
							puzzleArr[x][y + 1] = "X";
							break;
						}
					}

					if (adws.equals("d"))
					{
						if (y == 1 || y == 2)
						{
							System.out.println("d입력");
							temp = puzzleArr[x][y - 1];
							puzzleArr[x][y] = null;
							puzzleArr[x][y - 1] = null;
							puzzleArr[x][y] = temp;
							puzzleArr[x][y - 1] = "X";
							break;
						}
					}

				}
			}
		}

		return puzzleArr;
	}

	public void puzzleMove()
	{

	}

	public String[][] xPos(String[][] strArr)
	{
		String[][] xPos = null;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (strArr[i][j].equals("X"))
				{
					xPos = strArr;
				}
			}
		}
		return xPos;
	}

	public void showpuzzle(String[][] puzlArr)
	{
		for (int m = 0; m < 3; m++)
		{
			for (int n = 0; n < 3; n++)
			{
				System.out.print(puzlArr[m][n] + " ");
			}
			System.out.println("\n");
		}
	}

	public void puzzleGame()
	{
		String[][] realPuzzle = puzzleArrayInit();
		String a = "s";
		while (true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("퍼즐게임");
			System.out.println("1. 퍼즐 섞기");
			System.out.println("2. 퍼즐 시작");
			System.out.println("3. 퍼즐 종료");
			int num = scanner.nextInt();
			if (num == 1)
			{
				realPuzzle = puzlSuffle(realPuzzle);
			} else if (num == 2)
			{
				System.out.println("게임을 시작합니다.");
				break;
			} else if (num == 3)
			{
				System.out.println("종료합니다.");
				System.exit(0);
			}

		}
		while (true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("[ 이동 ] a:Left d:Right w:Up s:Down");
			System.out.println("[ 종료 ] x:Exit");
			System.out.print("키를 입력해주세요 : ");
			String moveKey;
			moveKey = sc.next();
			realPuzzle = move(realPuzzle, moveKey);
			showpuzzle(realPuzzle);

		}

	}
}
