package hearthstone_project.hsp;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Search {

	public Search() 
	{
		System.out.println("");
	}
	
	public HttpResponse<JsonNode> SearchAll(
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchBack(
			String callback, 
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchName(
			String name,
			String callback,
			int collectible,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchSet(
			String set,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchClass(
			String playerClass,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchFaction(
			String faction,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchQuality(
			String quality,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchRace(
			String race,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchType(
			String type,
			int attack,
			String callback,
			int collectible,
			int cost,
			int durability,
			int health,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchInfo(
			String callback,
			String locale)
	{
		return null;
	}
	
	public HttpResponse<JsonNode> SearchCard(
			String name,
			String callback,
			int collectible,
			String locale)
	{
		return null;
	}
	
}
