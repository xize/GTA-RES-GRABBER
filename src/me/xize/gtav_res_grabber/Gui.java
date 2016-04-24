package me.xize.gtav_res_grabber;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public interface Gui {
	
	/**
	 * initializes the gui
	 * 
	 * @author xize
	 */
	public void initializeGui();
	
	/**
	 * initializes the listeners
	 * 
	 * @author xize
	 */
	public void initializeListeners();

	public JButton getSteamButton();
	
	public JButton getWithoutSteamButton();
	
	public JTextArea getTextArea();
	
	public JScrollPane getScrollPane();
	
}
