package project2.ver03;

import java.util.Scanner;

import project2.ver03.Account;

public class AccountManager implements CustomSpecialRate
{
	public Account[] SaveAccount = new Account[50];
	public int accNum = 0;
	public int num = 0;

	public void showMenu()
	{
		System.out.println("----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.print("선택: ");
	}

	// 계좌개설을 위한 함수
	public void makeAccount()
	{
		String account = null, name = null, level = null;
		int money = 0, interest = 0, maxinterest = 0;
		System.out.println("****신규계좌개설*****");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택: ");

		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		if (num == 1)
		{
			Scanner scan2 = new Scanner(System.in);
			System.out.print("계좌번호: ");
			account = scan2.nextLine();
			System.out.print("고객이름: ");
			name = scan2.nextLine();
			System.out.print("잔고: ");
			money = scan2.nextInt();
			System.out.print("기본이자%(정수형태로입력): ");
			interest = scan2.nextInt();
			// 객체배열로저장
			SaveAccount[accNum] = new NormalAccount(account, name, money, interest);
			accNum++;
			System.out.println("계좌개설이 완료되었습니다.");

		} else if (num == 2)
		{
			Scanner scan2 = new Scanner(System.in);
			System.out.print("계좌번호: ");
			account = scan2.nextLine();
			System.out.print("고객이름: ");
			name = scan2.nextLine();
			System.out.print("잔고: ");
			money = scan2.nextInt();
			System.out.print("기본이자%(정수형태로입력): ");
			maxinterest = scan2.nextInt();
			System.out.print("신용등급(A,B,C등급): ");
			level = scan2.next();

			// 저장
			SaveAccount[accNum] = new HighCreditAccount(account, name, money, maxinterest, level);
			accNum++;
			System.out.println("계좌개설이 완료되었습니다.");
		}

	}

	// 입금
	public void depositMoney()
	{
		int inmoney = 0;
		System.out.println("****입금*****");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String search = scan.next();
		for (int i = 0; i < accNum; i++)
		{
			if (search.equals(SaveAccount[i].account))
			{
				try
				{
					Scanner s3 = new Scanner(System.in);
					System.out.print("입금액: ");
					inmoney = s3.nextInt();
					try
					{
						if (inmoney < 0)
						{
							throw new Exception();
						}
					} catch (Exception e)
					{
						System.out.println("음수를 입금할 수 없습니다.");
						e.getMessage();
						continue;
					}
				} catch (Exception e)
				{
					System.out.println("문자를 입금할 수 없습니다.");
					e.getMessage();
					continue;
				}
				try
				{
					if (SaveAccount[i].getLevel().equals("A"))
					{
						SaveAccount[i].money = (int) (SaveAccount[i].money
								+ (SaveAccount[i].money * ((double) SaveAccount[i].getMaxinterest() / 100))
								+ ((double) SaveAccount[i].money * A) + inmoney);
						System.out.println("입금이 완료되었습니다.");
					} else if (SaveAccount[i].getLevel().equals("B"))
					{
						SaveAccount[i].money = (int) (SaveAccount[i].money
								+ (SaveAccount[i].money * ((double) SaveAccount[i].getMaxinterest() / 100))
								+ ((double) SaveAccount[i].money * B) + inmoney);
						System.out.println("입금이 완료되었습니다.");
					} else if (SaveAccount[i].getLevel().equals("C"))
					{
						SaveAccount[i].money = (int) (SaveAccount[i].money
								+ (SaveAccount[i].money * ((double) SaveAccount[i].getMaxinterest() / 100))
								+ ((double) SaveAccount[i].money * C) + inmoney);
						System.out.println("입금이 완료되었습니다.");
					}
				} catch (Exception e)
				{
					SaveAccount[i].money = (int) (SaveAccount[i].money
							+ (SaveAccount[i].money * ((double) SaveAccount[i].getInterest() / 100)) + inmoney);
					System.out.println("입금이 완료되었습니다.");
				}

			} else
			{
				System.out.println("개설된 계좌가 없습니다.");
			}
		}
	}

	// 출금
	public void withdrawMoney()
	{
		System.out.println("***출   금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String search = scan.nextLine();
		for (int i = 0; i < accNum; i++)
		{
			if (search.equals(SaveAccount[i].account))
			{
				Scanner sout = new Scanner(System.in);
				System.out.print("출금액: ");
				int outmoney = sout.nextInt();
				SaveAccount[i].money = SaveAccount[i].money - outmoney;
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}

}
