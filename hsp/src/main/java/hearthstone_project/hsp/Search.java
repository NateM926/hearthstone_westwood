package hearthstone_project.hsp;

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
}
