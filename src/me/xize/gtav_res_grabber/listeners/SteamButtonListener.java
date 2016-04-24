package me.xize.gtav_res_grabber.listeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;

import me.xize.gtav_res_grabber.Main;
import me.xize.gtav_res_grabber.TextWriter;
import me.xize.gtav_res_grabber.Window;
import me.xize.gtav_res_grabber.Window.GetWindowRectException;
import me.xize.gtav_res_grabber.Window.WindowNotFoundException;
import me.xize.gtav_res_grabber.scheduler.GTARunnable;
import me.xize.gtav_res_grabber.scheduler.Scheduler;

public class SteamButtonListener implements ActionListener {
	
	private final JFileChooser fc = new JFileChooser();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Main.getGui().getSteamButton())) {
			fc.setDialogTitle("Open Steam.exe");
			int sel = fc.showOpenDialog(null);
			if(sel == JFileChooser.APPROVE_OPTION && fc.getSelectedFile().getName().equalsIgnoreCase("Steam.exe")) {
				TextWriter.getWriter().write("Steam found, initializing GTA V");
				TextWriter.getWriter().write("windows resolution before GTA V launch: "+Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())+"*"+Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
				TextWriter.getWriter().write("firing command: Steam.exe -applaunch 271590");
				Process proc = null;
				try {
					proc = Runtime.getRuntime().exec(fc.getSelectedFile().toString()+" -applaunch 271590");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				doTask(proc);
			} else {
				TextWriter.getWriter().write("invalid program, this is not steam.");
			}
		}
	}
	
	public void doTask(Process proc) {
		Scheduler.runTaskTimer(new GTARunnable() {

			private int count = 0;
			
			@Override
			public void run() {
				TextWriter.getWriter().write("do tick: "+count++);
				TextWriter.getWriter().write("windows resolution: "+Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())+"*"+Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
				try {
					TextWriter.getWriter().write("process resolution: "+Arrays.toString(Window.getRect("Grand Theft Auto V")));
				} catch (WindowNotFoundException e) {
					TextWriter.getWriter().write("process window not found, maybe wrong window name?");
				} catch (GetWindowRectException e) {
					TextWriter.getWriter().write("process exists, window is null");
				}
			}
			
		}, 0L, 8000L);
	}

}