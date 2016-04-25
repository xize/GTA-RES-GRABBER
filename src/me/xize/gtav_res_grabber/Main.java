package me.xize.gtav_res_grabber;

import javax.swing.SwingUtilities;

public class Main {
	
	private final static Gui screen = new GuiScreen("GTA V Resolution grabber v1.1 by Xize");
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				screen.initializeGui();
				screen.initializeListeners();
			}
			
		});
	}
	
	/**
	 * returns the Gui
	 * 
	 * @author xize
	 * @return Gui
	 */
	public static Gui getGui() {
		return screen;
	}
}
