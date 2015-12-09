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

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    DefaultListModel<String> nameList = new DefaultListModel<String>();
    DefaultListModel<String> decknameList = new DefaultListModel<String>();
    JList<String[]> cardList = new JList(nameList);
    JList<String[]> deckList = new JList(decknameList);

    JScrollPane cardListScroller = new JScrollPane(cardList);
    JScrollPane deckListScroller = new JScrollPane(deckList);
	JButton addCardButton = new JButton("Add Card");
	JButton removeCardButton = new JButton("Remove Card");

    //Pictures:
    String IMG_PATH = "src/imp_gang_pic.png";
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

        //LISTENERS
        addWindowListener(this);
        searchButton.addActionListener(this);
        addCardButton.addActionListener(this);
        removeCardButton.addActionListener(this);
        deckList.addListSelectionListener(new ListSelectionListener() {		//Used for deckList listener.
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  cardInfo.setText(deckList.getSelectedValue()+"");
                }
            }
        });
        cardList.addListSelectionListener(new ListSelectionListener() {		//Used for cardList listener.
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  cardInfo.setText(cardList.getSelectedValue()+"");
                }
            }
        });

        
        
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
                
        c.gridx=0;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(addCardButton,c);
        
        c.gridx=4;c.gridy=7;c.gridwidth=1;c.gridheight=1;c.weightx=0;c.weighty=0;
        add(removeCardButton,c);
	}
 
    
    //FRAME LISTENERS
    public void actionPerformed(ActionEvent arg0) {
    	if (arg0.getSource()==searchButton){				//If the search button is clicked
    		Search searcher = new Search();
    		ArrayList<Card> searchResults = new ArrayList<Card>();
    		String searchText = searchBar.getText();
    		searchResults = searcher.DoSearch(searchText);
    		cardInfo.setText(searchText);
    		nameList.clear();
    		
    		for (Card c: searchResults)
    		{
    			String cardName = c.name;
    			nameList.addElement(cardName);
    		}     
    		
    	}
    	else if (arg0.getSource()==addCardButton){			//If the add card button is clicked
    		String selectedAddCard = cardList.getSelectedValuesList().toString(); 
    		cardInfo.setText(selectedAddCard);
    		decknameList.addElement(selectedAddCard);
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
