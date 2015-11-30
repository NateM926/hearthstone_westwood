package hearthstone_project.hsp;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class App extends Frame implements WindowListener,ActionListener
{
	/**
	 * Java Swing GUI
	 */
	
	private static final long serialVersionUID = 1L;
	GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    JButton searchButton = new JButton("Search");

    public static void main( String[] args ) throws UnirestException
    {
    	App app = new App("Hearthstone Deck Builder");
        app.pack();
        app.setSize(650,300);
        app.setVisible(true);
    	testingResponse();
    }

	public App(String title) {		
        setLayout(gridbag);
        c.fill = GridBagConstraints.BOTH;
        addWindowListener(this);
        searchButton.addActionListener(this);

        c.gridx=0;c.gridy=0;
        add(searchButton,c);
	}
 
    public static void testingResponse() throws UnirestException{
    	HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
    	    	.header("X-Mashape-Key", "0Ft11iQGTcmshEqprMjGICRQ0q1bp1jLSLojsnF6HWVrpPhAzO")
    	    	.asJson();    	
    	System.out.println(response.toString());
        JSONObject myObj = response.getBody().getObject();
        System.out.println(myObj.toString()); 

    }
    
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
        dispose();
        System.exit(0);		
	}
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
