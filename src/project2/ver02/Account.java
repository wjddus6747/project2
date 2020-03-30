package project2.ver02;

import java.util.Scanner;

public class Account
{
	public String account;
	public String name;
	public int money;

	public Account(String account, String name, int money)
	{
		this.account = account;
		this.name = name;
		this.money = money;
	}

	// 전체계좌정보출력
	public void showAccInfo()
	{
		System.out.println("***계좌정보출력***");
		System.out.println("계좌번호 " + account);
		System.out.println("고객이름 " + name);
		System.out.println("잔고 " + money);
	}
	
	
	public int getInterest()
	{
		return 0;
	}

	public void setInterest(int interest)
	{
	}
	
	public int getMaxinterest()
	{
		return 0;
	}

	public void setMaxinterest(int maxinterest)
	{
		
	}

	public String getLevel()
	{
		return null;
	}

	public void setLevel(String level)
	{
		
	}
}
