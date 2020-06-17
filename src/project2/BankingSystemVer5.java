package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project2.ver05.MenuChoice;
import project2.ver05.PuzzleMethod;

public class BankingSystemVer5 implements MenuChoice
{
	static Connection con;
	static Statement stmt;
	static PreparedStatement psmt;
	static ResultSet rs;

	public static String account;
	public static String name;
	public static int money;

	public static void showMenu()
	{
		System.out.println("----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.퍼즐");
		System.out.println("6.프로그램종료");
		System.out.print("선택: ");
	}

	// 계좌개설을 위한 함수 (PreparedStatement 클래스 이용)
	public static void makeAccount()
	{

		try
		{
			String sql = "INSERT INTO banking_tb values( seq_banking.nextval,?, ?, ?)";
			psmt = con.prepareStatement(sql);

			Scanner scan = new Scanner(System.in);
			System.out.println("****신규계좌개설*****");
			System.out.print("계좌번호: ");
			account = scan.nextLine();
			System.out.print("고객이름: ");
			name = scan.nextLine();
			System.out.print("잔고: ");
			money = scan.nextInt();
			System.out.println("계좌개설이 완료되었습니다.");

			psmt.setString(1, account);
			psmt.setString(2, name);
			psmt.setInt(3, money);

			int accountnum = psmt.executeUpdate();
			System.out.println(accountnum + "행이 입력되었습니다.");

		} catch (SQLException e)
		{
			System.out.println("계좌개설예외");
			e.printStackTrace();
		}
	}

	// 전체계좌정보출력(Statement 클래스 이용)
	public static void showAccInfo()
	{
		try
		{
			stmt = con.createStatement();
			String sql = "SELECT * FROM banking_tb WHERE account like '%%'";
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				String account = rs.getString("account");
				String name = rs.getString("name");
				int money = rs.getInt("money");
				int idx = rs.getInt("sequen");
				System.out.printf("%s %s %s %s\n", idx, account, name, money);
			}
			System.out.println("전체계좌출력이 완료되었습니다.");
		} catch (Exception e)
		{
			System.out.println("전체출력예외발생");
			e.printStackTrace();
		}
	}

	// 입금 (PreparedStatement 클래스 이용)
	public static void depositMoney()
	{
		try
		{
			String sql = "UPDATE banking_tb SET money = money + ?  WHERE account = ?";
			psmt = con.prepareStatement(sql);

			System.out.println("****입금*****");
			System.out.println("계좌번호와 입금할 금액을 입력하세요");
			Scanner scan = new Scanner(System.in);
			System.out.print("계좌번호: ");
			String search = scan.nextLine();
			System.out.print("입금액: ");
			int inmoney = scan.nextInt();

			psmt.setInt(1, inmoney);
			psmt.setString(2, search);
			int addaccount = psmt.executeUpdate();
			System.out.println(addaccount + "계좌에 입금되었습니다.");
		} catch (Exception e)
		{
			System.out.println("update문예외발생");
			e.printStackTrace();
		}
	}

	// 출금 (PreparedStatement 클래스 이용)
	public static void withdrawMoney()
	{
		try
		{
			String sql = "UPDATE banking_tb SET money= money - ? WHERE account = ? ";
			psmt = con.prepareStatement(sql);

			System.out.println("***출   금***");
			System.out.println("계좌번호와 출금할 금액을 입력하세요");
			Scanner scan = new Scanner(System.in);
			System.out.print("계좌번호: ");
			String search = scan.nextLine();
			System.out.print("출금액: ");
			int outmoney = scan.nextInt();

			psmt.setInt(1, outmoney);
			psmt.setString(2, search);

			int myaccount = psmt.executeUpdate();
			System.out.println(myaccount + "계좌에 출금되었습니다.");
		} catch (Exception e)
		{
			System.out.println("출금예외발생");
			e.printStackTrace();
		}
	}

	// 오라클 연결
	public static void ConnectionOracle()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:orcl", "kosmo", "1234");
		} catch (Exception e)
		{
			System.out.println("DB연결오류");
		}
	}

	// close
	public static void close()
	{
		try
		{
			if (con != null)
			{
				con.close();
			}
			if (psmt != null)
			{
				psmt.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		} catch (Exception e)
		{
			System.out.println("close예외발생");
		}
	}

	// main함수
	public static void main(String[] args)
	{
		PuzzleMethod p = new PuzzleMethod();
		ConnectionOracle();
		while (true)
		{
			showMenu();
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			if (number == MAKE)
			{
				makeAccount();
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
				showAccInfo();
				continue;

			} else if (number == PUZZLE)
			{
				p.puzzleGame();
			} else if (number == EXIT)
			{
				close();
				System.out.println("프러그램을 종료합니다.");
				break;
			}
		}
	}

}
