package project2;

import java.util.Scanner;

import project2.ver02.Account;
import project2.ver02.AccountManager;
import project2.ver02.MenuChoice;

public class BankingSystemVer2 implements MenuChoice
{
	public static void main(String[] args)
	{
		AccountManager acm = new AccountManager();
		while (true)
		{
			acm.showMenu();
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
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
		}
	}

}
