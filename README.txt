Hearthstone Deckbuilder
Authors: Nathan Mathis, Crockett Lalor, Max Geffken
The project report is in COS226-TermProjectReport-NCM28.pdf in this directory

SEARCH LANGUAGE
	Flags
		
	-n <name>
		name of card - must be full name, and no other search parameters. (e.g. Wisp, p, a)
	-t <type>
		type of card (Minion, Weapon, Spell...)
	-a <attack>
		minion attack
	-h <health>
		minion health
	-s <set>
		card set
	-c <cost>
		card cost
	-d <durability>
		durability (if weapon)
	-x <card text>
		word in text of card
	-g <gold variation>
		displays gold version of searched cards.	
	-draft <drafting deck>
		draft an arena deck for a certain class.
		
	Classes:
		ma = mage
		hu = hunter
		wk = warlock
		wr = warrior
		pr = priest
		sh = shaman
		pa = paladin 
		ro = rogue
		dr = druid
		
	ex: -draft ma
		-draft hu
			
	Example Searches
		-n Wis : 
			Searches for cards with "Wis" in their name 
		-s basic -c 3 :
			Searches for basic set cards with a cost of 3
		
