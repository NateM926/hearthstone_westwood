package hearthstone_project.hsp;

public class TierValues {
	private int druidVal;
	private int hunterVal;
	private int mageVal;
	private int paladinVal;
	private int priestVal;
	private int rogueVal;
	private int shamanVal;
	private int warlockVal;
	private int warriorVal;
	
	public TierValues(){
		druidVal = -1;
		hunterVal = -1;
		mageVal = -1;
		paladinVal = -1;
		priestVal = -1;
		rogueVal = -1;
		shamanVal = -1;
		warlockVal = -1;
		warriorVal = -1;
	}
	public String toString(){
		return "(" + druidVal + ", " + hunterVal + ", "
				+ mageVal + ", " + paladinVal + ", " 
				+ priestVal + ", " + rogueVal + ", " 
				+ shamanVal + ", " + warlockVal + ", " + warriorVal + ")";
	}
	public int getDruidVal() {
		return druidVal;
	}

	public void setDruidVal(int druidVal) {
		this.druidVal = druidVal;
	}

	public int getHunterVal() {
		return hunterVal;
	}

	public void setHunterVal(int hunterVal) {
		this.hunterVal = hunterVal;
	}

	public int getMageVal() {
		return mageVal;
	}

	public void setMageVal(int mageVal) {
		this.mageVal = mageVal;
	}

	public int getPaladinVal() {
		return paladinVal;
	}

	public void setPaladinVal(int paladinVal) {
		this.paladinVal = paladinVal;
	}

	public int getPriestVal() {
		return priestVal;
	}

	public void setPriestVal(int priestVal) {
		this.priestVal = priestVal;
	}

	public int getRogueVal() {
		return rogueVal;
	}

	public void setRogueVal(int rogueVal) {
		this.rogueVal = rogueVal;
	}

	public int getShamanVal() {
		return shamanVal;
	}

	public void setShamanVal(int shamanVal) {
		this.shamanVal = shamanVal;
	}

	public int getWarlockVal() {
		return warlockVal;
	}

	public void setWarlockVal(int warlockVal) {
		this.warlockVal = warlockVal;
	}

	public int getWarriorVal() {
		return warriorVal;
	}

	public void setWarriorVal(int warriorVal) {
		this.warriorVal = warriorVal;
	}
}
