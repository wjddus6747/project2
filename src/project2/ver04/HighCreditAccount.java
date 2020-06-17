package project2.ver04;

public class HighCreditAccount extends Account implements CustomSpecialRate
{
	public int maxinterest;
	public String level;
	public HighCreditAccount(String account, String name, int money, int maxinterest, String level) {
		super(account, name, money);
		
		this.maxinterest = maxinterest;
		this.level = level;
	}
	
	@Override
	public void showAccInfo()
	{
		super.showAccInfo();
		System.out.println("기본이자 "+ maxinterest);
		System.out.println("신용등급"+ level);
		System.out.println("전체계좌정보출력이 완료되었습니다.");
	}

	@Override
	public int getMaxinterest()
	{
		return maxinterest;
	}
	@Override
	public void setMaxinterest(int maxinterest)
	{
		this.maxinterest = maxinterest;
	}
	@Override
	public String getLevel()
	{
		return level;
	}
	@Override
	public void setLevel(String level)
	{
		this.level = level;
	}
}
