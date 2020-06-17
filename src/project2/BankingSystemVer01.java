package project2;

import java.util.Scanner;

import project2.ver01.Account;
import project2.ver01.MenuChoice;

public class BankingSystemVer01 implements MenuChoice
{

	static Account[] SaveAccount = new Account[50];
	static int accNum = 0;

	public static void showMenu()
	{
		System.out.println("----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.print("선택: ");
	}

	// 입금
	public static void depositMoney()
	{
		System.out.println("****입금*****");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String search = scan.nextLine();
		for (int i = 0; i < accNum; i++)
		{
			if (search.equals(SaveAccount[i].account))
			{
				Scanner Sinmoney = new Scanner(System.in);
				System.out.print("입금액: ");
				int inmoney = Sinmoney.nextInt();
				SaveAccount[i].money = SaveAccount[i].money + inmoney;
				System.out.println("입금이 완료되었습니다.");
			} else
			{
				System.out.println("개설된 계좌가 없습니다.");
			}
		}
	}

	// 출금
	public static void withdrawMoney()
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

	public static void main(String[] args)
	{
		while (true)
		{
			showMenu();
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			if (number == MAKE)
			{
				if (accNum <= 50)
				{
					SaveAccount[accNum] = new Account();
					SaveAccount[accNum].makeAccount();
					accNum++;
				}
				continue;
			} else if (number == DEPOSIT)
			{
				depositMoney();
				continue;
			}

			else if (number == WITHDRAW)
			{
				withdrawMoney();
				continue;
			} else if (number == INQUIRE)
			{
				for (int i = 0; i < accNum; i++)
				{
					SaveAccount[i].showAccInfo();
					continue;
				}
			} else if (number == EXIT)
			{
				break;
			}
		}
	}

}
