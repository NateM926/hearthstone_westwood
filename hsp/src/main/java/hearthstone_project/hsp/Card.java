package hearthstone_project.hsp;

public class Card {
	String cardId;		// card ID, unique to every card
	String name;		// card name, not always unique
	String type;		// card type, (eg, Minion, Weapon, Spell...)
	String text;		// text on card
	String imgGold;		// url of gold card image
	String img;			// url of regular card image
	String cardSet;		// set the card came from
	int cost;			// mana cost of card
	int attack;			// attack of card (-1 if not well defined)
	int health;			// health of card (-1 if not well defined)
	int durability;		// durability of weapon (-1 if not well defined)
	
	
	public Card(String rawCardData)
	{
		cardId = name = type = text = imgGold = img = cardSet = ""; // setting all to default values
		cost = attack = health = durability = -1;					// these are not always well defined. -1 is the flag for this.
		
		int startIndex;
		int endIndex;
		
		// finding cardId
		int currentIndex = rawCardData.indexOf("\"cardId\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 10;
			endIndex = rawCardData.indexOf("\"", startIndex);
			cardId = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding name of card
		currentIndex = rawCardData.indexOf("\"name\"");
		if (currentIndex != -1)							
		{
			startIndex = currentIndex + 8;
			endIndex = rawCardData.indexOf("\"", startIndex);
			name = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding card type
		currentIndex = rawCardData.indexOf("\"type\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 8;
			endIndex = rawCardData.indexOf("\"", startIndex);
			type = rawCardData.substring(startIndex, endIndex);
		}
		
		//finding text of card
		currentIndex = rawCardData.indexOf("\"text\"");	
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 8;
			endIndex = rawCardData.indexOf("\"", startIndex);
			text = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding gold image url
		currentIndex = rawCardData.indexOf("\"imgGold\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 11;
			endIndex = rawCardData.indexOf("\"", startIndex);
			imgGold = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding image url
		currentIndex = rawCardData.indexOf("\"img\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 7;
			endIndex = rawCardData.indexOf("\"", startIndex);
			img = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding the set the card belongs to
		currentIndex = rawCardData.indexOf("\"cardSet\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 11;
			endIndex = rawCardData.indexOf("\"", startIndex);
			cardSet = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding mana cost of card
		currentIndex = rawCardData.indexOf("\"cost\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 7;
			endIndex = startIndex;
			while (Character.isDigit(rawCardData.charAt(endIndex)))
			{
				endIndex++;
			}
			cost = Integer.parseInt(rawCardData.substring(startIndex, endIndex));
		}
		
		// finding attack of card
		currentIndex = rawCardData.indexOf("\"attack\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 9;
			endIndex = startIndex + 1;
			while (Character.isDigit(rawCardData.charAt(endIndex)))
			{
				endIndex++;
			}
			attack = Integer.parseInt(rawCardData.substring(startIndex, endIndex));
		}
		
		// finding health of card
		currentIndex = rawCardData.indexOf("\"health\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 9;
			endIndex = startIndex + 1;
			while (Character.isDigit(rawCardData.charAt(endIndex)))
			{
				endIndex++;
			}
			health = Integer.parseInt(rawCardData.substring(startIndex, endIndex));
		}
		
		// finding durability of a weapon
		currentIndex = rawCardData.indexOf("\"durability\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 13;
			endIndex = startIndex;
			while (Character.isDigit(rawCardData.charAt(endIndex)))
			{
				endIndex++;
			}
			durability = Integer.parseInt(rawCardData.substring(startIndex, endIndex));
		}
		
	}

	// Test purposes only, in non-applicable string fields, pass "", in non-applicable int fields, pass -1
	public Card(String Id, String name, String type, String text, String imgGold, String img, String cardSet, int cost, int attack, int health, int durability)
	{
		cardId = Id;
		this.name = name;
		this.type = type;
		this.text = text;
		this.imgGold = imgGold;
		this.cardSet = cardSet;
		this.cost = cost;
		this.attack = attack;
		this.health = health;
		this.durability = durability;
	}
	
	public static void main(String[] args)
	{
	}
	
	public String toString(){
		return ""+name+type+text+cardSet+cost+attack+health;
	}
}
