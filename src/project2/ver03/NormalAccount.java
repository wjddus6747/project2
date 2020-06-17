package project2.ver03;

public class NormalAccount extends Account
{
	public int interest;

	public NormalAccount(String account, String name, int money, int interest)
	{
		super(account, name, money);

		this.interest = interest;
	}

	@Override
	public void showAccInfo()
	{
		super.showAccInfo();
		System.out.println("기본이자" + interest);
		System.out.println("전체계좌정보출력이 완료되었습니다.");
	}

	@Override
	public int getInterest()
	{
		return interest;
	}

	@Override
	public void setInterest(int interest)
	{
		this.interest = interest;
	}

}
