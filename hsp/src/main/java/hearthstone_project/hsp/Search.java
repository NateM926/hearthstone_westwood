package hearthstone_project.hsp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.StringUtils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Search {
	public Search() 
	{
		
	}
	
	//Returns all available Hearthstone cards including non collectible cards.
	public HttpResponse<JsonNode> SearchAll(
			int attack,
			int collectible,
			int cost,
			int durability,
			int health) 
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?";
		searchParams += ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
		
		if (searchParams.charAt(searchParams.length()-1) == '&')
		{
			searchParams = searchParams.substring(0, searchParams.length()-1);
		}
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns cards by partial name.
	public HttpResponse<JsonNode> SearchName(
			String name,
			int collectible)
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/";
		searchParams += name + "?"
			//+ "callback=" + callback + "&"
			//+ "locale=" + locale + "&"
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible): "");
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}

	//Returns all cards in a set. Example values: Blackrock Mountain, Classic.
	public HttpResponse<JsonNode> SearchSet(
			String set,
			int attack,
			int collectible,
			int cost,
			int durability,
			int health)
	
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/";
		searchParams += ((set != null) ? set + "?" : "")
			+ ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a class. Example values: Mage, Paladin.
	public HttpResponse<JsonNode> SearchClass(
			String playerClass,
			int attack,
			int collectible,
			int cost,
			int durability,
			int health)
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/";
		searchParams += playerClass + "?"
			+ ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
			
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	
	//Returns all the cards of a certain faction. Example values: Horde, Neutral.
	public HttpResponse<JsonNode> SearchFaction(
			String faction,
			int attack,
			int collectible,
			int cost,
			int durability,
			int health)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/factions/";
		searchParams += faction + "?"
			+ ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a certain quality. Example values: Legendary, Common.
	public HttpResponse<JsonNode> SearchQuality(
			String quality,
			int attack,
			int collectible,
			int cost,
			int durability,
			int health)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/";
		searchParams += quality + "?"
			+ ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a certain race. Example values: Mech, Murloc.
	public HttpResponse<JsonNode> SearchRace(
			String race,
			int attack,
			int collectible,
			int cost,
			int durability,
			int health)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/races/";
		searchParams += race + "?"
			+ ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns all the cards of a certain type. Example values: Spell, Weapon
	public HttpResponse<JsonNode> SearchType(
			String type,
			int attack,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
					
	throws UnirestException {		
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/";
		searchParams += type + "?"
			+ ((attack != -1) ? "attack=" + Integer.toString(attack) + "&" : "")
			+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible) + "&" : "")
			+ ((cost != -1) ?  "cost=" + Integer.toString(cost)  + "&" : "")
			+ ((durability != -1) ? "durability=" + Integer.toString(durability) + "&" : "")
			+ ((health != -1) ? "health=" + Integer.toString(health) : "");
		
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.asJson();
		
		return response;
	}
	
	//Returns card by name or ID. This may return more then one card if they share the same name. 
	//Loatheb returns both the card and the boss.
	public HttpResponse<JsonNode> SearchCard(
			String name,
			int collectible)
	
	throws UnirestException {
		String searchParams = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/";
		searchParams += name + "?"
				+ ((collectible != -1) ?  "collectible=" + Integer.toString(collectible): "");
			
		HttpResponse<JsonNode> response = Unirest.get(searchParams)
			.header("X-Mashape-Key", "Hxzas1SwQimshDHBtoNCh9GvANOdp1I4eaejsnMXA6Zq0vAjDk")
			.header("Accept", "application/json")
			.asJson();

		return response;
	}
	
	// PRE: takes in HttpResponse from a search
	// POST: returns a list of Cards in the order they were received
	public static ArrayList<Card> getCardList(HttpResponse<JsonNode> response)
	{
		ArrayList<Card> cardList = new ArrayList<Card>();
		String rawJson = response.getBody().getObject().toString();
		rawJson = rawJson.substring(rawJson.indexOf('{') + 1);			// trims off leading '{'
		int nextCardEndIndex = getNextCardEnd(rawJson);
		Card nextCard;
		while (nextCardEndIndex != -1)
		{
			nextCard = new Card(rawJson.substring(nextCardEndIndex));
			if (nextCard.isPlayable())
			{	cardList.add(nextCard);}
			rawJson = rawJson.substring(nextCardEndIndex);
			nextCardEndIndex = getNextCardEnd(rawJson);
		}
		return cardList;
	}
	
	// PRE: rawJson is of the form {<card object>}, {<card object>}, ... i.e., no leading braces.
	// POST: returns index after the end of the first card object, or -1 if there are no cards.
	public static int getNextCardEnd(String rawJson)
	{
		int bracesOpen = 1;
		int currentIndex = rawJson.indexOf('{');
		if (currentIndex == -1)
		{
			return -1;
		}
		currentIndex++;
		while (bracesOpen > 0)
		{
			if (currentIndex >= rawJson.length())
			{
				return -1;
			}
			if (rawJson.charAt(currentIndex) == '{')
			{
				bracesOpen++;
			}
			if (rawJson.charAt(currentIndex) == '}')
			{
				bracesOpen--;
			}
			currentIndex++;
		}
		return currentIndex + 1;
	}
	
	//This method parses the input string for search parameters and performs a request based on those parameters
	public ArrayList<Card> DoSearch(String searchString)
	{
		//Scanner s = new Scanner(searchString);
		String name = null;
		String type = null;
		int attack = -1;
		int health = -1;
		String set = null;
		int cost = -1;
		int durability = -1;
		String text = null;
		
		StringTokenizer st = new StringTokenizer(searchString);
		while (st.hasMoreTokens()) {
			String nextToken = st.nextToken();
			if (nextToken.startsWith("-n"))
			{
				name = st.nextToken();
			} 
			else if (nextToken.startsWith("-t"))
			{
				type = st.nextToken();
			} 
			else if (nextToken.startsWith("-a"))
			{
				attack = Integer.valueOf(st.nextToken());
			} 
			else if (nextToken.startsWith("-h"))
			{
				health = Integer.valueOf(st.nextToken());
			} 
			else if (nextToken.startsWith("-s"))
			{
				set = st.nextToken();
			} 
			else if (nextToken.startsWith("-c"))
			{
				cost = Integer.valueOf(st.nextToken());
			} 
			else if (nextToken.startsWith("-d"))
			{
				durability = Integer.valueOf(st.nextToken());
			}
			else if (nextToken.startsWith("-x"))
			{
				text = st.nextToken();
			}
	         
	     }
		HttpResponse<JsonNode> response = null;
		try {
			response = SearchAll(attack, 1, cost, durability, health);
		} catch (UnirestException e) {
			//handle exception
		}
		ArrayList<Card> cardList = getCardList(response);
		//System.out.println(cardList.toString());
		return cardList;
	}
}
