package hearthstone_project.hsp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * GUI Application
 * 
 * BUGS (all that are left are very minor):
 * 	Words don't wrap correctly and the whole app resizes if the text gets too long on a line.
 * 	Cards in your deck list have brackets around the name.
 *  Small bug where if you remove twice without changing the deck list current card it will return an array index out of bounds.
 */

public class App extends Frame implements WindowListener,ActionListener,ItemListener
{	
	private static final long serialVersionUID = 1L;
	GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    Insets padding = new Insets(5,5,5,5);				//object that pads the elements to space them out.
    private Search searcher;
    
    //Search Bar:
    JButton searchButton = new JButton("Search");
    JTextField searchBar = new JTextField("Search");
    
    //Card Lists:
    ArrayList<Card> searchCardArrayList = new ArrayList<Card>();
    ArrayList<Card> deckCardArrayList = new ArrayList<Card>();
    
    DefaultListModel<String> nameList = new DefaultListModel<String>();
    DefaultListModel<String> decknameList = new DefaultListModel<String>();
    JList<String[]> cardList = new JList(nameList);
    JList<String[]> deckList = new JList(decknameList);

    JScrollPane cardListScroller = new JScrollPane(cardList);
    JScrollPane deckListScroller = new JScrollPane(deckList);
	JButton addCardButton = new JButton("Add Card");
	JButton removeCardButton = new JButton("Remove Card");

    //Pictures:
    String IMG_PATH = "http://wow.zamimg.com/images/hearthstone/cardbacks/original/Card_Back_TeSPA.png?8314"; //Empty Card
    URL url = new URL(IMG_PATH);
    BufferedImage img = ImageIO.read(url);
	JLabel picLabel = new JLabel(new ImageIcon(img));

	//Card Information:
	JScrollPane cardPic = new JScrollPane(picLabel);
	JTextPane cardInfo = new JTextPane();

    
    public static void main( String[] args ) throws UnirestException, IOException
    {
    	App app = new App("Hearthstone Deck Builder");
        app.pack();
        app.setSize(1200,800);
        app.setVisible(true);
    }
    

	public App(String title) throws IOException {	
		
        setLayout(gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.insets = padding;
        picLabel.setOpaque(true);
        picLabel.setBackground(Color.BLACK);
        
        
        //Adding listeners
        addWindowListener(this);
        searchButton.addActionListener(this);
        addCardButton.addActionListener(this);
        removeCardButton.addActionListener(this);
        deckList.addListSelectionListener(new ListSelectionListener() {		//Used for deckList listener.
        	public void valueChanged(ListSelectionEvent arg0) {				//What happens when a new deck card is highlighted.										
            	if (!arg0.getValueIsAdjusting()) {	
	                if (deckList.getSelectedIndex()==-1){					//For when the selected value is lost during clear() functions.
	                	return;
	                }
			        cardInfo.setText(deckCardArrayList.get(deckList.getSelectedIndex()).toString());			
			            
		        	//Card pic updating:
		        	try {
		        		URL url = new URL(deckCardArrayList.get(deckList.getSelectedIndex()).img);
		        		img.flush();
		        		img = ImageIO.read(url);
		        		picLabel.setIcon(new ImageIcon(img));
		        	} 
		        	catch (IOException e) {
		        		System.out.println("can't get the pic url.");
		        	}
                }
            }
        });
        
        cardList.addListSelectionListener(new ListSelectionListener() {		//Used for cardList listener.
        	public void valueChanged(ListSelectionEvent arg0) {				//What happens when a new search card is highlighted.	
        		if (!arg0.getValueIsAdjusting()) {
	                if (cardList.getSelectedIndex()==-1){					//For when the selected value is lost during clear() functions.
	                	return;
	                }
        			cardInfo.setText(searchCardArrayList.get(cardList.getSelectedIndex()).toString());

	                //Card pic updating:                  
	                try {
	                	URL url = new URL(searchCardArrayList.get(cardList.getSelectedIndex()).img);
	                	img.flush();
	                	img = ImageIO.read(url);
	                	picLabel.setIcon(new ImageIcon(img));
	                  	} 
	                catch (IOException e) {
	                	System.out.println("can't get the pic url.");
	                }
	                
                }
            }
            
        });

        //adding GUI elements to grid.
        c.gridx=0;c.gridy=0;c.gridwidth=4;c.gridheight=1;c.weightx=3;c.weighty=0;
        add(searchBar,c);
        
        c.gridx=4;c.gridy=0;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(searchButton,c);
        
        c.gridx=0;c.gridy=1;c.gridwidth=1;c.gridheight=6;c.weightx=0;c.weighty=3;
        add(cardListScroller,c);

        c.gridx=4;c.gridy=1;c.gridwidth=1;c.gridheight=6;c.weightx=0;c.weighty=3;
        add(deckListScroller,c);

        c.gridx=1;c.gridy=1;c.gridwidth=3;c.gridheight=5;c.weightx=5;c.weighty=3;
        add(cardPic,c);

        c.gridx=1;c.gridy=6;c.gridwidth=3;c.gridheight=1;c.weightx=0;c.weighty=1;
        cardInfo.setEditable(false);
        cardInfo.setText("Welcome to Nate, Crockett and Max's Hearthstone deckbuilder!");
        add(cardInfo,c);
                
        c.gridx=0;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(addCardButton,c);
        
        c.gridx=4;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(removeCardButton,c);
	}
 
    
    //Frame Listeners:
    public void actionPerformed(ActionEvent arg0) {
    	if (arg0.getSource()==searchButton){					//If the search button is clicked
    		nameList.clear();									
    		searchCardArrayList.clear();

    		Search searcher = new Search();
    		ArrayList<Card> searchResults = new ArrayList<Card>();
    		String searchText = searchBar.getText();
    		
    		nameList.clear();									//empty out list we're going to be inserting into.
    		searchCardArrayList.clear();						//empty out list we're going to be inserting into.
    		
    		searchResults = searcher.DoSearch(searchText);
    		boolean gold_img_display = searcher.gold_version;	//if user typed -g in search.
    		    		
    		if (searcher.draft==true){							//specifically for arena card drafting.
    			decknameList.clear();							//empty out list we're going to be inserting into.
    			deckCardArrayList.clear();						//empty out list we're going to be inserting into.
    			for (Card c:searchResults){
        			String cardName = c.name;
        			decknameList.addElement(cardName);   			
        			if (gold_img_display == true){				//make img the gold version
        				c.img=c.imgGold;						//if search requested it.
        			}
        			deckCardArrayList.add(c);
    			}
    			return;											//escapes so it doesn't go on to the search cards.
    		}
    		
    		for (Card c: searchResults)
    		{
    			String cardName = c.name;
    			nameList.addElement(cardName);   			
    			if (gold_img_display == true){					//make img the gold version
    				c.img=c.imgGold;							//if search requested it.
    			}
    			searchCardArrayList.add(c);
    		}     
    		
    	}
    	else if (arg0.getSource()==addCardButton){				//If the add card button is clicked
    		String selectedAddCard = cardList.getSelectedValuesList().toString(); 			//gets name from selected card.
    		decknameList.addElement(selectedAddCard);										//adds name to name list
    		deckCardArrayList.add(searchCardArrayList.get(cardList.getSelectedIndex()));	//adds card to card array list.
    		
    	}
    	
    	else if (arg0.getSource()==removeCardButton){			//If the remove card button is clicked
    		int cardIndex = deckList.getSelectedIndex();
    		decknameList.removeElementAt(cardIndex);			//remove from name list
    		deckCardArrayList.remove(cardIndex);				//remove from deck array list.
    	}
    }
    
    
    public void windowClosing(WindowEvent arg0) {
        dispose();
        System.exit(0);		
	}
    
    //Unused listeners:
    public void windowClosed(WindowEvent arg0) {}
	public void windowActivated(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
	public void itemStateChanged(ItemEvent arg0) {}
}
