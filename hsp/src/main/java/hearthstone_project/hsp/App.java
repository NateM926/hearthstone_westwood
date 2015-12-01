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
    Insets padding = new Insets(5,5,5,5);	//object that pads the elements to space them out.

    JButton searchButton = new JButton("Search");
    JTextField searchBar = new JTextField("Search");
    
    
    String[] cards = {"asdf","asdfa","adfas","vdfav","few","vewac","cwewe","asdf","asdfa","adfas","vdfav","few","vewac","cwewe","asdf","asdfa","adfas","vdfav","few","vewac","cwewe"};
    JList<String[]> cardList = new JList(cards);
    JList<String[]> deckList = new JList(cards);
    JScrollPane cardListScroller = new JScrollPane(cardList);
    JScrollPane deckListScroller = new JScrollPane(deckList);

    JPanel cardInfo = new JPanel();
    
    //Currently not working: Pictures
    String IMG_PATH = "src/test_pic.gif";
	BufferedImage img = ImageIO.read(new File(IMG_PATH));
	JLabel picLabel = new JLabel(new ImageIcon(img));
	
	/*
	JButton addCardButton = new JButton("Add Card");
	JButton removeCardButton = new JButton("Remove Card");
	*/

    
    public static void main( String[] args ) throws UnirestException, IOException
    {
    	App app = new App("Hearthstone Deck Builder");
        app.pack();
        app.setSize(650,300);
        app.setVisible(true);
    }

	public App(String title) throws IOException {			
        setLayout(gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.insets=padding;

        addWindowListener(this);
        searchButton.addActionListener(this);
        //cardList.addItemListener(this);
        
        c.gridx=0;c.gridy=0;c.gridwidth=4;c.gridheight=1;c.weightx=2;c.weighty=0;
        add(searchBar,c);
        
        c.gridx=4;c.gridy=0;c.gridwidth=1;c.gridheight=1;c.weightx=0.5;c.weighty=0;
        add(searchButton,c);
        
        c.gridx=0;c.gridy=1;c.gridwidth=1;c.gridheight=5;c.weightx=1;c.weighty=3;
        add(cardListScroller,c);
        
        c.gridx=1;c.gridy=1;c.gridwidth=3;c.gridheight=5;c.weightx=10;c.weighty=3;
        add(cardInfo,c);
        
        c.gridx=4;c.gridy=1;c.gridwidth=1;c.gridheight=5;c.weightx=0.5;c.weighty=3;
        add(deckListScroller,c);
        
        c.gridx=6;c.gridy=2;
        add(picLabel,c);
        
        //Trying to place these underneath the scrollers!!
        /*
        c.gridx=0;c.gridy=2;c.gridwidth=1;c.gridheight=1;c.weightx=1;c.weighty=1;
        add(addCardButton);
        
        c.gridx=4;c.gridy=2;c.gridwidth=1;c.gridheight=1;c.weightx=1;c.weighty=1;
        add(removeCardButton);
		*/
        
        
	}
	
	//Not currently drawing anywhere
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(img, 0, 0, null); // see javadoc for more info on the parameters            
    }

 
    public static void testingResponse() throws UnirestException{
    	HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
    	    	.header("X-Mashape-Key", "0Ft11iQGTcmshEqprMjGICRQ0q1bp1jLSLojsnF6HWVrpPhAzO")
    	    	.asJson();    	
        JSONObject json = response.getBody().getObject();
        System.out.println(json.toString());
    }
    
    //FRAME LISTENERS
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
	public void actionPerformed(ActionEvent arg0) {}

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
