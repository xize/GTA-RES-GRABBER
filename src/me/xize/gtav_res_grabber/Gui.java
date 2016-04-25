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

	/**
	 * returns the steam open button
	 * 
	 * @author xize
	 * @return JButton
	 */
	public JButton getSteamButton();
	
	/**
	 * returns the without steam open button
	 * 
	 * @author xize
	 * @return JButton
	 */
	public JButton getWithoutSteamButton();
	
	/**
	 * returns the textarea
	 * 
	 * @author xize
	 * @return JTextArea
	 */
	public JTextArea getTextArea();
	
	/**
	 * returns the scollpane
	 * 
	 * @author xize
	 * @return JScrollPane
	 */
	public JScrollPane getScrollPane();
	
}
