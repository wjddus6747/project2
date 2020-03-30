package project2.ver01;

import java.util.Scanner;

public class Account 
{
	
	public String account;
	public String name;
	public int money;

	
	
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
	
	
	
	//전체계좌정보출력
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("계좌번호 "+ account);
		System.out.println("고객이름 "+ name);
		System.out.println("잔고 "+ money);
		System.out.println("전체계좌정보출력이 완료되었습니다.");
	}
}
