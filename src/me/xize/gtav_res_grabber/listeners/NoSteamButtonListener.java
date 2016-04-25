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
import me.xize.gtav_res_grabber.scheduler.GTARunnable;
import me.xize.gtav_res_grabber.scheduler.Scheduler;


public class NoSteamButtonListener implements ActionListener {
			
		private final JFileChooser fc = new JFileChooser();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(Main.getGui().getWithoutSteamButton())) {
				fc.setDialogTitle("Open GTA5.exe");
				int sel = fc.showOpenDialog(null);
				if(sel == JFileChooser.APPROVE_OPTION && fc.getSelectedFile().getName().equalsIgnoreCase("GTA5.exe")) {
					TextWriter.getWriter().write("initializing GTA V");
					TextWriter.getWriter().write("windows resolution before GTA V launch: "+Toolkit.getDefaultToolkit().getScreenSize().getWidth()+"*"+Toolkit.getDefaultToolkit().getScreenSize().getHeight());
					Process proc = null;
					try {
						proc = Runtime.getRuntime().exec(fc.getSelectedFile().toString());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					doTask(proc);
				} else {
					TextWriter.getWriter().write("invalid program, this is not GTAV");
				}
			}
		}
		
		public void doTask(Process proc) {
			Scheduler.runTaskTimer(new GTARunnable() {

				private int count = 0;
				
				@Override
				public void run() {
					TextWriter.getWriter().write("do tick: "+count++);
					TextWriter.getWriter().write("windows resolution: "+Toolkit.getDefaultToolkit().getScreenSize().getWidth()+"*"+Toolkit.getDefaultToolkit().getScreenSize().getHeight());
					try {
						TextWriter.getWriter().write("process resolution: "+Arrays.toString(Window.getWindowApi().getWindowSize("Grand Theft Auto V")));
					} catch (Exception e) {
						TextWriter.getWriter().write(e.getMessage());
					}
				}
				
			}, 0L, 8000L);
		}
}
