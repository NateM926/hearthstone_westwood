package hearthstone_project.hsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.io.*;

import com.mashape.unirest.http.exceptions.UnirestException;

public class TierList {
	public static String mage = "ma";
	public static String hunter = "hu";
	public static String warlock = "wk";
	public static String warrior = "wr";
	public static String priest = "pr";
	public static String shaman = "sh";
	public static String paladin = "pa";
	public static String rogue = "ro";
	public static String druid = "dr";
	
	private HashMap<String, TierValues> tierMap;
	
	public TierList(HashMap<String, TierValues> map)
	{	tierMap = map;}
	
	public static TierList BuildTierList(){
		String druidTier = "src/main/resources/file/druidTier.txt";			// text file names
		String hunterTier = "src/main/resources/file/hunterTier.txt";
		String mageTier = "src/main/resources/file/mageTier.txt";
		String paladinTier = "src/main/resources/file/paladinTier.txt";
		String priestTier = "src/main/resources/file/priestTier.txt";
		String rogueTier = "src/main/resources/file/rogueTier.txt";
		String shamanTier = "src/main/resources/file/shamanTier.txt";
		String warlockTier = "src/main/resources/file/warlockTier.txt";
		String warriorTier = "src/main/resources/file/warriorTier.txt";
		
		HashMap<String, TierValues> map = new HashMap<String, TierValues>();			// keys are card names, 
																// values are TierValue objects
		
		String[] tierFiles = {druidTier, hunterTier, mageTier, 	// array used to iterate over different
				paladinTier, priestTier, rogueTier, shamanTier, // text files easily
				warlockTier, warriorTier};
		BufferedReader bufferedReader;
		TierValues newTierVal;
		String key, val;
		
		for (int i = 0; i < 9; i++)
		{
			try {
				bufferedReader = new BufferedReader(new FileReader(tierFiles[i]));
				key = bufferedReader.readLine();
				val = bufferedReader.readLine();
				while (key != null && val != null)
				{
					key = key.trim();
					val = val.trim();
					if (map.containsKey(key))
					{
						newTierVal = map.get(key);
					}
					else
					{
						newTierVal = new TierValues();
						map.put(key, newTierVal);
					}
					switch (i) 
					{
						case 0:	// i == 0 means 0th index of array => reading from druid file
							newTierVal.setDruidVal(Integer.parseInt(val));
							break;
						case 1:	// i == 1 means 1st index of array => reading from hunter file
							newTierVal.setHunterVal(Integer.parseInt(val));
							break;
						case 2:	// i == 2 means 2nd index of array => reading from mage file
							newTierVal.setMageVal(Integer.parseInt(val));
							break;
						case 3:	// i == 3 means 3rd index of array => reading from paladin file
							newTierVal.setPaladinVal(Integer.parseInt(val));
							break;
						case 4:	// i == 4 means 4th index of array => reading from priest file
							newTierVal.setPriestVal(Integer.parseInt(val));
							break;
						case 5:	// i == 5 means 5th index of array => reading from rogue file
							newTierVal.setRogueVal(Integer.parseInt(val));
							break;
						case 6:	// i == 6 means 6th index of array => reading from shaman file
							newTierVal.setShamanVal(Integer.parseInt(val));
							break;
						case 7:	// i == 7 means 7th index of array => reading from warlock file
							newTierVal.setWarlockVal(Integer.parseInt(val));
							break;
						case 8:	// i == 8 means 8th index of array => reading from warrior file
							newTierVal.setWarriorVal(Integer.parseInt(val));
					}	// close switch statement
					key = bufferedReader.readLine();
					val = bufferedReader.readLine();
				}	// close while loop
				bufferedReader.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e.toString());
			}
			catch (IOException e)
			{
				System.out.println(e.toString());
			}
		}	// end of for loop
		return new TierList(map);
	}
	public int getValue(String playerClass, String cardName)
	{
		
		TierValues result = tierMap.get(cardName);
		if (playerClass.equals(druid)){
			return result.getDruidVal();}
		if (playerClass.equals(hunter)){
			return result.getHunterVal();}
		if (playerClass.equals(mage)){
			return result.getMageVal();}
		if (playerClass.equals(paladin)){
			return result.getPaladinVal();}
		if (playerClass.equals(priest)){
			return result.getPriestVal();}
		if (playerClass.equals(rogue)){
			return result.getRogueVal();}
		if (playerClass.equals(shaman)){
			return result.getShamanVal();}
		if (playerClass.equals(warlock)){
			return result.getWarlockVal();}
		if (playerClass.equals(warrior)){
			return result.getWarriorVal();}
		return -1;
	}
	
	public ArrayList<Card> draftDeck(String playerClass)
	{
		Random rand = new Random();
		Search searcher = new Search();
		ArrayList<Card> deck = new ArrayList<Card>();
		int index1, index2, index3;
		Card card1, card2, card3;
		Object[] cardNameObjs = this.tierMap.keySet().toArray();
		String[] cardNames = new String[cardNameObjs.length];
		for (int i = 0; i < cardNameObjs.length; i++)
		{
			if (cardNameObjs[i] instanceof String)
			{
				cardNames[i] = (String) cardNameObjs[i];
			}
		}
		for (int i = 0; i < 30; i++)			// adds 30 cards to the deck
		{
			index1 = rand.nextInt(cardNames.length);	// picks first card from 
			do {
				index2 = rand.nextInt(cardNames.length);
			} while (index2 == index1);
			
			do {
				index3 = rand.nextInt(cardNames.length);
			} while(index3 == index1 || index3 == index2);
			try {
				ArrayList<Card> search;
				search = Search.getCardListName(searcher.SearchName(cardNames[index1], 1));
				if (!search.isEmpty()){
					card1 = search.get(0);}
				else {
					System.out.println(cardNames[index1]);
					throw new Exception();
				}
				search = Search.getCardListName(searcher.SearchName(cardNames[index2], 1));
				if (!search.isEmpty()){
					card2 = search.get(0);}
				else {
					System.out.println(cardNames[index2]);
					throw new Exception();
				}
				search = Search.getCardListName(searcher.SearchName(cardNames[index3], 1));
				if (!search.isEmpty()){
					card3 = search.get(0);}
				else {
					System.out.println(cardNames[index3]);
					throw new Exception();
				}
				if (getValue(card1.name, playerClass) >= getValue(card2.name, playerClass) && getValue(card1.name, playerClass) >= getValue(card3.name, playerClass)){
					deck.add(card1);
				}
				else if (getValue(card2.name, playerClass) >= getValue(card3.name, playerClass)){
					deck.add(card2);
				}
				else{
					deck.add(card3);
				}
			}
			catch (UnirestException e)
			{
				System.out.println(e.toString());
			}
			catch (IndexOutOfBoundsException e){
				i--;
				System.out.println(e.toString());
			}
			catch (Exception e){
				i--;
			}
		}	// exit for loop (30 cards inserted into deck)
		return deck;
	}
	public static void main(String[] args){
		TierList myTierList = BuildTierList();
		System.out.print(myTierList.draftDeck("ma"));
	}
}

