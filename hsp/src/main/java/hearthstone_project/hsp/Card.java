package hearthstone_project.hsp;

public class Card {
	String cardID;
	String name;
	String type;
	String text;
	String imgGold;
	String img;
	String cardSet;
	int attack;
	int health;
	int cost;
	
	
	public Card(String JsonStuff)
	{
		int currentIndex = JsonStuff.indexOf("cardID");
		
		if (currentIndex != -1)
		{
			cardID = "some shit";
		}
		if (currentIndex != -1)
		{
			
		}
		if (currentIndex != -1)
		{
			
		}
		if (currentIndex != -1)
		{
			
		}
		if (currentIndex != -1)
			{}
		if (currentIndex != -1)
			{}
		if (currentIndex != -1)
			{}
		if (currentIndex != -1)
			{}
		if (currentIndex != -1)
			{}
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("I eat dick".indexOf("eat"));
	}
}
