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

	public static void main(String[] args)
	{
		Account a = new Account();
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if (number == MAKE)
		{
			a.makeAccount();
			for (accNum = 0; accNum < 50; accNum++)
			{
				SaveAccount[accNum] = new Account();
				SaveAccount[accNum].makeAccount();
			}

		} else if (number == DEPOSIT)
		{

		} else if (number == WITHDRAW)
		{

		} else if (number == INQUIRE)
		{

		} else if (number == EXIT)
		{

		}
	}

}
