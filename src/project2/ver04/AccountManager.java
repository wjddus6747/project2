package project2.ver04;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import project2.ver04.Account;

public class AccountManager implements CustomSpecialRate
{
	public HashSet<Account> saveaccount = new HashSet<Account>();
	// public Account[] SaveAccount = new Account[50];
	// public int accNum = 0;
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
			if (saveaccount.add(new NormalAccount(account, name, money, interest)) == true)
			{
				saveaccount.add(new NormalAccount(account, name, money, interest));
				System.out.println("계좌개설이 완료되었습니다.");
			} else if (saveaccount.add(new NormalAccount(account, name, money, interest)) == false)
			{
				System.out.println("중복되었습니다. 덮어쓸겁니까?(1.예, 2.아니오)");
				Scanner s = new Scanner(System.in);
				int num = s.nextInt();
				if (num == 1)
				{
					saveaccount.remove(new NormalAccount(account, name, money, interest));
					saveaccount.add(new NormalAccount(account, name, money, interest));
					System.out.println("덮어졌습니다.");
				} else if (num == 2)
				{

				}
			}
			// saveaccount.add(new NormalAccount(account, name, money, interest));

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
			if (saveaccount.add(new HighCreditAccount(account, name, money, maxinterest, level)) == true)
			{
				saveaccount.add(new HighCreditAccount(account, name, money, maxinterest, level));
				System.out.println("계좌개설이 완료되었습니다.");
			} else if (saveaccount.add(new HighCreditAccount(account, name, money, maxinterest, level)) == false)
			{
				System.out.println("중복되었습니다.덮어쓰시겠니?(1.예, 2.아니오)");
				Scanner s = new Scanner(System.in);
				int num = s.nextInt();
				if (num == 1)
				{
					saveaccount.remove(new HighCreditAccount(account, name, money, maxinterest, level));
					saveaccount.add(new HighCreditAccount(account, name, money, maxinterest, level));
					System.out.println("덮어졌습니다.");
				} else if (num == 2)
				{

				}
			}
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
		System.out.print("입금액");
		inmoney = scan.nextInt();
		Iterator<Account> itr = saveaccount.iterator();
		while (itr.hasNext())
		{
			Account ac = itr.next();
			if (search.equals(ac.account) && ac.getLevel().equals("A"))
			{
				ac.money = (int) (ac.money + (ac.money * ((double) ac.getMaxinterest() / 100)) + ((double) ac.money * A)
						+ inmoney);
				System.out.println("입금이 완료되었습니다.");
			} else if (search.equals(ac.account) && ac.getLevel().equals("B"))
			{
				ac.money = (int) (ac.money + (ac.money * ((double) ac.getMaxinterest() / 100)) + ((double) ac.money * B)
						+ inmoney);
				System.out.println("입금이 완료되었습니다.");
			} else if (search.equals(ac.account) && ac.getLevel().equals("C"))
			{
				ac.money = (int) (ac.money + (ac.money * ((double) ac.getMaxinterest() / 100)) + ((double) ac.money * C)
						+ inmoney);
				System.out.println("입금이 완료되었습니다.");
			} else if (search.equals(ac.account))
			{
				ac.money = (int) (ac.money + (ac.money * ((double) ac.getInterest() / 100)) + inmoney);
				System.out.println("입금이 완료되었습니다.");
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
		System.out.print("출금액: ");
		int outmoney = scan.nextInt();
		Iterator<Account> itr = saveaccount.iterator();
		while (itr.hasNext())
		{
			Account ac = itr.next();
			if (search.equals(ac.account))
			{
				ac.money = ac.money - outmoney;
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}

	// 전체출력
	public void show()
	{
		Iterator<Account> itr = saveaccount.iterator();
		while (itr.hasNext())
		{
			Account ac = itr.next();
			ac.showAccInfo();
		}
	}
	
	//저장
	public void outAccount() {
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/project2/ver04/Bank.obj"));
			
			output.writeObject(saveaccount);
			output.close();
		} catch (Exception e)
		{
			System.out.println("예외발생");
			e.printStackTrace();
		} 
	}
	
	//출력
	public void InAccount() {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/project2/ver04/Bank.obj"));
			
			HashSet<Account> saveaccount = (HashSet<Account>) input.readObject();
			Iterator<Account> itr = saveaccount.iterator();
			while(itr.hasNext()) {
				Account ac = itr.next();
				ac.showAccInfo();
			}
			input.close();
		}
		catch (Exception e) {
			System.out.println("저장된객체파일없음");
		}
	}

}
