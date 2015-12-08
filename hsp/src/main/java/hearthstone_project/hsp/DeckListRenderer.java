package hearthstone_project.hsp;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class DeckListRenderer extends JLabel implements ListCellRenderer {	
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public DeckListRenderer() {
	    setOpaque(true);
	    setIconTextGap(12);
	}

	public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		
	    Card card = (Card) value;
	    setText(card.name);
	    //setIcon(entry.getImage());
	    if (isSelected) {
	      setBackground(HIGHLIGHT_COLOR);
	      setForeground(Color.white);
	    } else {
	      setBackground(Color.white);
	      setForeground(Color.black);
	    }
	    return this;
	}

}
