package project2;

import java.util.Scanner;

import project2.ver03.Account;
import project2.ver03.AccountManager;
import project2.ver03.MenuChoice;
import project2.ver03.MenuSelectException;

public class BankingSystemVer3 implements MenuChoice
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
				for (int i = 0; i < acm.accNum; i++)
				{
					acm.SaveAccount[i].showAccInfo();
					continue;
				}
			} else if (number == EXIT)
			{
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
