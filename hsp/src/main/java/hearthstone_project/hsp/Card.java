package hearthstone_project.hsp;

public class Card {
	String cardId;		// card ID, unique to every card
	String name;		// card name, not always unique
	String type;		// card type, (eg, Minion, Weapon, Spell...)
	String text;		// text on card
	String flavor;		// flavor text on card
	String imgGold;		// url of gold card image
	String img;			// url of regular card image
	String cardSet;		// set the card came from
	String playerClass;	// class permitted to play card; "neutral" if all
	String race;		// race, if applicable, "" otherwise
	int cost;			// mana cost of card
	int attack;			// attack of card (-1 if not well defined)
	int health;			// health of card (-1 if not well defined)
	int durability;		// durability of weapon (-1 if not well defined)
	
	
	public Card(String rawCardData)
	{
		cardId = name = type = text = race =
				imgGold = img = cardSet = playerClass = ""; 		// setting all to default values
		cost = attack = health = durability = -1;					// -1 is flag for no value
		
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
		
		// getting flavor text
		currentIndex = rawCardData.indexOf("\"flavor\"");	
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 10;
			endIndex = rawCardData.indexOf("\"", startIndex);
			flavor = rawCardData.substring(startIndex, endIndex);
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
		
		// finding class of card
		currentIndex = rawCardData.indexOf("\"playerClass\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 15;
			endIndex = rawCardData.indexOf("\"", startIndex);
			playerClass = rawCardData.substring(startIndex, endIndex);
		}
		
		// finding race of card
		currentIndex = rawCardData.indexOf("\"race\"");
		if (currentIndex != -1)
		{
			startIndex = currentIndex + 8;
			endIndex = rawCardData.indexOf("\"", startIndex);
			race = rawCardData.substring(startIndex, endIndex);
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
	
	public boolean isPlayable()
	{
		if (type.equals("Hero") || type.equals("Hero Power") || 
				cardSet.equals("Missions") || cardSet.equals("Tavern Brawl"))
		{	return false;}
		return true;
	}
	public static void main(String[] args)
	{
	}
	
	public String toString(){
		return "Name: "+name+"\nType: "+type+"\nClass: "+playerClass+"\nCard Set: "+cardSet+"\n\nText: "+text+"\n\nCost: "+cost+"\nAttack: "+attack+"\nHealth: "+health;
	}
}
