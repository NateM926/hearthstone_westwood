package hearthstone_project.hsp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
 * BUGS:
 * 	When removing a card from decklist it crashes.
 * 	Words don't wrap correctly and the whole app resizes if the text gets too long on a line. Will prob ignore this bug.
 * 	Cards in your deck list have brackets around the name.
 * 	Can't do more than 1 search.
 * 	(Both multiple searches and removing a card give an arraylist index out of bounds exception, so I would look into that.)
 * 
 * TODO:
 * 	Get player search parameter working.
 * 	Get drafting working.
 * 	Eventually make this search bar better. Grey search text, when you click it overwrites all. When you press enter it searches. (LOW PRIORITY)
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
                  cardInfo.setText(deckCardArrayList.get(deckList.getSelectedIndex()).toString());			
                    
                  //Card pic updating:
                  try {
                	  url = new URL(deckCardArrayList.get(deckList.getSelectedIndex()).img);
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
                  cardInfo.setText(searchCardArrayList.get(cardList.getSelectedIndex()).toString());
                  
                  //Card pic updating:                  
                  try {
                	  url = new URL(searchCardArrayList.get(cardList.getSelectedIndex()).img);
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
        cardInfo.setText("Welcome to Nate, Crockett and Max's Hearthstone deckbuilder!\nMaybe put some tutorial type of thing here!\nOr the search flags.");
        add(cardInfo,c);
                
        c.gridx=0;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(addCardButton,c);
        
        c.gridx=4;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(removeCardButton,c);
	}
 
    
    //Frame Listeners:
    public void actionPerformed(ActionEvent arg0) {
    	if (arg0.getSource()==searchButton){				//If the search button is clicked
    		Search searcher = new Search();
    		ArrayList<Card> searchResults = new ArrayList<Card>();
    		String searchText = searchBar.getText();
    		searchResults = searcher.DoSearch(searchText);
    		cardInfo.setText(searchText);
    		boolean gold_img_display = searcher.gold_version;	//if user typed -g in search.
    		
    		//Trying to get second search to work:
    		nameList.clear();
    		searchCardArrayList.clear();
    		
    		for (Card c: searchResults)
    		{
    			String cardName = c.name;
    			nameList.addElement(cardName);   			
    			if (gold_img_display == true){				//make img the gold version
    				c.img=c.imgGold;						//if search requested it.
    			}
    			searchCardArrayList.add(c);
    		}     
    		
    	}
    	else if (arg0.getSource()==addCardButton){			//If the add card button is clicked
    		String selectedAddCard = cardList.getSelectedValuesList().toString(); 			//gets name from selected card.
    		decknameList.addElement(selectedAddCard);										//adds name to name list
    		deckCardArrayList.add(searchCardArrayList.get(cardList.getSelectedIndex()));	//adds card to card array list.
    		
    	}
    	
    	else if (arg0.getSource()==removeCardButton){		//If the remove card button is clicked
    		//currently not working.
    		decknameList.removeElementAt(deckList.getSelectedIndex());						//remove from name list
    		deckCardArrayList.remove(deckList.getSelectedIndex());							//remove from deck array list.
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
