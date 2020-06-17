package project2.ver05;

import java.util.Scanner;

public class PuzzleMethod
{

	// 퍼즐초가화
	public String[][] puzzleArrayInit()
	{
		String[][] pa = new String[3][3];
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

	// 퍼즐셔플(돌리기)
	public String[][] puzlSuffle(String[][] pa)
	{
		for (int i = 1; i <= 100; i++)
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

	// x를 움직이기
	public String[][] move(String[][] puzzleArr, String adws)
	{
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				if (puzzleArr[x][y].equals("X"))
				{
					String temp = null;

					if (adws.equals("w"))
					{
						if (x == 0 || x == 1)
						{
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

	// 문제를 풀었는지 확인하기
	public int puzzleMoveEnd(String[][] puzzleArr)
	{
		int dap = 0;
		if (puzzleArr[0][0].equals("1"))
		{
			if (puzzleArr[0][1].equals("2"))
			{
				if (puzzleArr[0][2].equals("3"))
				{
					if (puzzleArr[1][0].equals("4"))
					{
						if (puzzleArr[1][1].equals("5"))
						{
							if (puzzleArr[1][2].equals("6"))
							{
								if (puzzleArr[2][0].equals("7"))
								{
									if (puzzleArr[2][1].equals("8"))
									{
										if (puzzleArr[2][2].equals("X"))
										{
											Scanner sc = new Scanner(System.in);
											System.out.println("게임이 끝났습니다.");
											System.out.println("게임을 종료하실겁니까?");
											System.out.print("1. 재시작 2. 종료 : ");
											dap = sc.nextInt();

										}
									}
								}
							}
						}
					}
				}
			}
		}
		return dap;
	}

	// 퍼즐 보여주기
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

	// 메인같은존재
	public void puzzleGame()
	{
		String[][] realPuzzle = puzzleArrayInit();
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
				showpuzzle(realPuzzle);
			} else if (num == 2)
			{
				showpuzzle(realPuzzle);
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
			String moveKey = sc.next();
			if (moveKey.equals("x"))
			{
				break;
			}
			realPuzzle = move(realPuzzle, moveKey);
			showpuzzle(realPuzzle);
			int dap = puzzleMoveEnd(realPuzzle);
			if (dap == 1)
			{
				realPuzzle = puzlSuffle(realPuzzle);
				showpuzzle(realPuzzle);
				continue;
			} else if (dap == 2)
			{
				break;
			}
		}

	}
}
