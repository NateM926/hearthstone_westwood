/*
 From Crockett:

I'm tired; going to bed.

I think everything I wrote works, but not totally sure; all totally untested. 
(ran a few little tests on the card constructor, but not even for most of the fields being parsed)

The Card() constructor takes in a string of JSON (a single card) and turns it into something a 
little easier to work with. 

I added two static methods to Search. getNextCardEnd() is just a helper function for getCardList(). 
getCardList now returns an ArrayList of cards, but we can change that later to give Chaw the data 
structures hardon he deserves. It just converts the HttpResponse straight into cards.

Features to be added: Right now, we can do a search, then convert that to a list of Cards. We still 
need to figure out everything on the deck side of things. We also need to do all the stuff taking 
these lists of cards, and displaying them on the screen somehow -- Nate's end of things.
Also, I need to add a few more values to the Card class and update the constructor to reflect 
the sorts of values that your code can search for.

Overall, I think it looks pretty good; it's been much easier than I thought it'd be. Good luck, man! <3 you!
 */

package hearthstone_project.hsp;

import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Search {
	public Search(String searchField) 
	{
		
	}
	
	//Returns all available Hearthstone cards including non collectible cards.
	public HttpResponse<JsonNode> SearchAll(
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale) 
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?";
		searchParams += "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns cards by partial name.
	public HttpResponse<JsonNode> SearchName(
			String name,
			String callback,
			int collectible,
			String locale)
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/";
		searchParams += name + "?"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}

	//Returns all cards in a set. Example values: Blackrock Mountain, Classic.
	public HttpResponse<JsonNode> SearchSet(
			String set,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/";
		searchParams += set + "?"
			+ "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a class. Example values: Mage, Paladin.
	public HttpResponse<JsonNode> SearchClass(
			String playerClass,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/";
		searchParams += playerClass + "?"
			+ "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	
	//Returns all the cards of a certain faction. Example values: Horde, Neutral.
	public HttpResponse<JsonNode> SearchFaction(
			String faction,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/factions/";
		searchParams += faction + "?"
			+ "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a certain quality. Example values: Legendary, Common.
	public HttpResponse<JsonNode> SearchQuality(
			String quality,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/";
		searchParams += quality + "?"
			+ "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a certain race. Example values: Mech, Murloc.
	public HttpResponse<JsonNode> SearchRace(
			String race,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/races/";
		searchParams += race + "?"
			+ "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a certain type. Example values: Spell, Weapon
	public HttpResponse<JsonNode> SearchType(
			String type,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/";
		searchParams += type + "?"
			+ "attack=" + Integer.toString(attack) + "&"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "cost=" + Integer.toString(cost) + "&"
			+ "durability=" + Integer.toString(durability) + "&"
			+ "health=" + Integer.toString(health) + "&"
			+ "locale=" + locale;
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns card by name or ID. This may return more then one card if they share the same name. 
	//Loatheb returns both the card and the boss.
	public HttpResponse<JsonNode> SearchCard(
			String name,
			String callback,
			int collectible,
			String locale)
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/";
		searchParams += name + "?"
			+ "callback=" + callback + "&"
			+ "collectible=" + Integer.toString(collectible) + "&"
			+ "locale=" + locale;
			
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.header("Accept", "application/json")
			.asJson();

		return response;
	}
	
	// UNTESTED
	// PRE: takes in HttpResponse from a search
	// POST: returns a list of Cards in the order they were received
	public static ArrayList<Card> getCardList(HttpResponse<JsonNode> response)
	{
		ArrayList<Card> cardList = new ArrayList<Card>();
		String rawJson = response.getBody().getObject().toString();
		rawJson = rawJson.substring(rawJson.indexOf('['));			// trims off leading '{'
		Card nextCard;
		int nextCardEndIndex = getNextCardEnd(rawJson);
		while (nextCardEndIndex != -1)
		{
			nextCard = new Card(rawJson.substring(0, nextCardEndIndex));
			cardList.add(nextCard);
			rawJson = rawJson.substring(nextCardEndIndex);
		}
		return cardList;
	}
	
	// UNTESTED
	// PRE: rawJson is of the form {<card object>}, {<card object>}, ... i.e., no leading braces.
	// POST: returns index after the end of the first card object, or -1 if there are no cards.
	public static int getNextCardEnd(String rawJson)
	{
		int bracesOpen = 0;
		int currentIndex = rawJson.indexOf("{") + 1;
		if (currentIndex == -1)
		{
			return -1;
		}
		char nextChar = rawJson.charAt(currentIndex);
		while (nextChar != '}' || bracesOpen > 0)		// skips over brace pairs interior to the card body
		{
			if (nextChar == '{')
			{
				bracesOpen ++;
			}
			if (nextChar == '}')
			{
				bracesOpen--;
			}
			currentIndex++;
			nextChar = rawJson.charAt(currentIndex);
		}
		return currentIndex + 1;						// return the index AFTER the end of the card
	}													//   so as not to include a spare '}'.
}
