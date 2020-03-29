package project2.ver01;

import java.util.Scanner;

public class Account 
{
	
	String account;
	String name;
	int money;

	
	
	//계좌개설을 위한 함수
	public void makeAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("****신규계좌개설*****");
		System.out.print("계좌번호: ");
		account = scan.nextLine();
		System.out.print("고객이름: ");
		name = scan.nextLine();
		System.out.print("잔고: ");
		money = scan.nextInt();
		System.out.println("계좌개설이 완료되었습니다.");
		
	}
	
	//입금
	public void depositMoney() {
		
	}
	
	//출금
	public void withdrawMoney() {
		
	}
	
	public void showAccInfo() {
		
	}
}
