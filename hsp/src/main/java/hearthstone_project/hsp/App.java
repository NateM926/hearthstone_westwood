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
import java.util.ArrayList;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * This is the GUI Application. Run this to use the program.
 *
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
    ArrayList<Card> deckArrayList = new ArrayList<Card>();
    //ArrayList<String> deckArrayList = new ArrayList<String>();
    //List deckListList = new ArrayList<Card>();
    
    /*
    String[] deckArray = {"asdf","asdfa","adfas","vdfav","few","vewac","cwewe","asdf","vewac","cwewe",
    		"asdf","vewac","cwewe","asdf","adfas","vdfav","few","vewac","cwewe","asdf","asdfa","adfas",
    		"vdfav","few","vewac","cwewe","asdf","asdfa","adfas","vdfav","few","vewac","cwewe"};
    String[] searchCardArray = {"asdf","asdfa","adfas","vdfav","few","vewac","cwewe","asdf","vewac","cwewe",
    		"asdf","vewac","cwewe","asdf","adfas","vdfav","few","vewac","cwewe","asdf","asdfa","adfas",
    		"vdfav","few","vewac","cwewe","asdf","asdfa","adfas","vdfav","few","vewac","cwewe"};
	*/
	
    //JList<String[]> cardList = new JList(deckArrayList.toArray());
    JList<Card[]> cardList = new JList(populatingList(searchCardArrayList));
    //JList<Card[]> deckList = new JList(deckArrayList.toArray());
    JList<Card[]> deckList = new JList(deckArrayList.toArray());
        
    JScrollPane cardListScroller = new JScrollPane(cardList);
    JScrollPane deckListScroller = new JScrollPane(deckList);
	JButton addCardButton = new JButton("Add Card");
	JButton removeCardButton = new JButton("Remove Card");

    //Pictures:
    String IMG_PATH = "src/test_pic.gif";
	BufferedImage img = ImageIO.read(new File(IMG_PATH));
	JLabel picLabel = new JLabel(new ImageIcon(img));

	//Card Information:
	JScrollPane cardPic = new JScrollPane(picLabel);
	JTextPane cardInfo = new JTextPane();

    
    public static void main( String[] args ) throws UnirestException, IOException
    {
    	App app = new App("Hearthstone Deck Builder");
        app.pack();
        app.setSize(750,800);
        app.setVisible(true);
    }

	public App(String title) throws IOException {			
        setLayout(gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.insets=padding;

        addWindowListener(this);
        searchButton.addActionListener(this);
        addCardButton.addActionListener(this);
        removeCardButton.addActionListener(this);
        
        Card testCard = new Card("id", "name", "type", "text", "imgGold", "img", "cardSet", 0, 0, 0, 0);
        //deckArrayList.add(testCard.name+", "+testCard.cost);
        //deckListList.add(testCard);
        //deckList.setCellRenderer(new DeckListRenderer());		//http://www.java2s.com/Code/Java/Swing-JFC/UseJListcomponenttodisplaycustomobjectswithListCellRenderer.htm
        
        c.gridx=0;c.gridy=0;c.gridwidth=4;c.gridheight=1;c.weightx=2;c.weighty=0;
        add(searchBar,c);
        
        c.gridx=4;c.gridy=0;c.gridwidth=1;c.gridheight=1;c.weightx=0.5;c.weighty=0;
        add(searchButton,c);
        
        c.gridx=0;c.gridy=1;c.gridwidth=1;c.gridheight=6;c.weightx=1;c.weighty=3;
        add(cardListScroller,c);

        c.gridx=4;c.gridy=1;c.gridwidth=1;c.gridheight=6;c.weightx=0.5;c.weighty=3;
        add(deckListScroller,c);

        c.gridx=1;c.gridy=1;c.gridwidth=3;c.gridheight=5;c.weightx=10;c.weighty=3;
        add(cardPic,c);

        c.gridx=1;c.gridy=6;c.gridwidth=3;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(cardInfo,c);
        cardInfo.setText("HEARTHSTONE TEST:\n\n\nasdfasdfas\n\n\ndfa\n\n\n\ns");		//temporary for testing
                
        c.gridx=0;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(addCardButton,c);
        
        c.gridx=4;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(removeCardButton,c);

        //deckArrayList.add("asdf,0");
	}
 
    public static void testingResponse() throws UnirestException{						//temporary for testing
    	HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
    	    	.header("X-Mashape-Key", "0Ft11iQGTcmshEqprMjGICRQ0q1bp1jLSLojsnF6HWVrpPhAzO")
    	    	.asJson();    	
        JSONObject json = response.getBody().getObject();
        System.out.println(json.toString());
    }
    
    public DefaultListModel<String> populatingList(ArrayList<Card> list){
    	DefaultListModel<String> newList = new DefaultListModel<String>();
    	for(Card c:list){
    	    newList.addElement(c.name+", "+c.cost);
    	}
    	System.out.println(newList);
    	return newList;
    }
    
    //FRAME LISTENERS
    public void actionPerformed(ActionEvent arg0) {
    	if (arg0.getSource()==searchButton){				//If the search button is clicked
    		String searchText = searchBar.getText();
    		cardInfo.setText(searchText);
    		
            //ArrayList Test								//temporary for testing
            Card testCard = new Card("id", "name", "type", "text", "imgGold", "img", "cardSet", 0, 0, 0, 0);
            //deckArrayList.add(testCard.name+", "+testCard.cost);
            deckArrayList.add(testCard);
            searchCardArrayList.add(testCard);
      
            
            System.out.println(deckArrayList.toString());          
            
    	}
    	else if (arg0.getSource()==addCardButton){			//If the add card button is clicked
    		String selectedAddCard = cardList.getSelectedValuesList().toString(); 
    		cardInfo.setText(selectedAddCard);
    	}
    	else if (arg0.getSource()==removeCardButton){		//If the remove card button is clicked
    		String selectedRemoveCard = deckList.getSelectedValuesList().toString();    		
    		cardInfo.setText(selectedRemoveCard);
    	}

    }
    public void windowClosing(WindowEvent arg0) {
        dispose();
        System.exit(0);		
	}
    public void windowClosed(WindowEvent arg0) {}
	public void windowActivated(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
	public void itemStateChanged(ItemEvent arg0) {}
}
