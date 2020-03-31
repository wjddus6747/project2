package project2;

import java.util.Iterator;
import java.util.Scanner;

import project2.ver04.Account;
import project2.ver04.AccountManager;
import project2.ver04.MenuChoice;
import project2.ver04.MenuSelectException;

public class BankingSystemVer4 implements MenuChoice
{
	public static void main(String[] args)
	{
		AccountManager acm = new AccountManager();

		while (true)
		{
			acm.showMenu();
			int number=0;
			try {
			Scanner sc = new Scanner(System.in);
			number = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("문자가 아닌 정수를 입력하세요(1~5)");
				e.getMessage();
				continue;
			}
			if (number == MAKE)
			{
				acm.makeAccount();
				continue;
			} else if (number == DEPOSIT)
			{
				acm.depositMoney();
				continue;
			}

			else if (number == WITHDRAW)
			{
				acm.withdrawMoney();
				continue;
			} else if (number == INQUIRE)
			{
				acm.InAccount();
				acm.show();
				continue;
				
			} else if (number == EXIT)
			{
				acm.outAccount();
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			else if (number < 1 || number > 5)
			{
				MenuSelectException ex = new MenuSelectException();
				try
				{
					throw ex;
				} catch (MenuSelectException e)
				{
					System.out.println(e.getMessage());
					continue;
				}
			}

		}
	}

}
