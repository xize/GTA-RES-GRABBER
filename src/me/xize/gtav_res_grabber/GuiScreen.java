package me.xize.gtav_res_grabber;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import me.xize.gtav_res_grabber.listeners.NoSteamButtonListener;
import me.xize.gtav_res_grabber.listeners.SteamButtonListener;

public class GuiScreen extends JFrame implements Gui {

	private static final long serialVersionUID = -5594173800194172941L;
	
	private JButton steam;
	private JButton nosteam;
	private JTextArea text;
	private JScrollPane scrollpane;
	
	public GuiScreen(String title) {
		super(title);
	}

	@Override
	public void initializeGui() {
		try {
			setIconImage(ImageIO.read(new File(getClass().getResource("resources/icon.png").getFile())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setResizable(false);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setMinimumSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttons = new JPanel();
		this.steam = new JButton("launch with steam");
		this.nosteam = new JButton("launch without steam");
		buttons.add(steam);
		buttons.add(nosteam);
		add(buttons);
		
		JPanel textb = new JPanel();
		
		text = new JTextArea("== here you see all the information ;-) ==\r\n");
		
		scrollpane = new JScrollPane(text);
		scrollpane.setPreferredSize(new Dimension(getSize().width-20, 300));
		
		textb.add(scrollpane);
		add(textb);
		
		pack();
		setVisible(true);
	}

	@Override
	public void initializeListeners() {
		steam.addActionListener(new SteamButtonListener());
		nosteam.addActionListener(new NoSteamButtonListener());
	}

	@Override
	public JButton getSteamButton() {
		return steam;
	}

	@Override
	public JButton getWithoutSteamButton() {
		return nosteam;
	}

	@Override
	public JTextArea getTextArea() {
		return text;
	}

	@Override
	public JScrollPane getScrollPane() {
		return scrollpane;
	}

}