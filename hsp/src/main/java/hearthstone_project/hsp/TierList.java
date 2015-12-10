package hearthstone_project.hsp;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class TierList {
	private HashMap<String, TierValues> tierMap;
	
	public TierList(HashMap<String, TierValues> map)
	{
		tierMap = map;
	}
	public TierList BuildTierList(){
		String druidTier = "druidTier.txt";			// text file names
		String hunterTier = "hunterTier.txt";
		String mageTier = "mageTier.txt";
		String paladinTier = "paladinTier.txt";
		String priestTier = "priestTier.txt";
		String rogueTier = "rogueTier.txt";
		String shamanTier = "shamanTier.txt";
		String warlockTier = "warlockTier.txt";
		String warriorTier = "warriorTier.txt";
		
		tierMap = new HashMap<String, TierValues>();			// keys are card names, 
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
				key = bufferedReader.readLine().trim();
				val = bufferedReader.readLine();
				while (key != null && val != null)
				{
					if (tierMap.containsKey(key))
					{
						newTierVal = tierMap.get(key);
					}
					else
					{
						newTierVal = new TierValues();
					}
					switch (i) 
					{
						case 0:
							newTierVal.setDruidVal(Integer.parseInt(val));
							break;
						case 1:
							newTierVal.setHunterVal(Integer.parseInt(val));
							break;
						case 2:
							newTierVal.setMageVal(Integer.parseInt(val));
							break;
						case 3:
							newTierVal.setPaladinVal(Integer.parseInt(val));
							break;
						case 4:
							newTierVal.setPriestVal(Integer.parseInt(val));
							break;
						case 5:
							newTierVal.setRogueVal(Integer.parseInt(val));
							break;
						case 6:
							newTierVal.setShamanVal(Integer.parseInt(val));
							break;
						case 7:
							newTierVal.setWarlockVal(Integer.parseInt(val));
							break;
						case 8:
							newTierVal.setWarriorVal(Integer.parseInt(val));
							break;
					}
				}
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
		return new TierList(tierMap);
	}

}
