package me.xize.gtav_res_grabber.scheduler;

import java.util.Timer;

public class Scheduler {
	
	private static Timer timer = new Timer();
	
	public static void scheduleDelayedTask(GTARunnable run, long when) {
		if(timer == null) {
			timer = new Timer();
		}
		timer.schedule(run, when);
	}
	
	public static void runTaskTimer(GTARunnable run, long start, long end) {
		if(timer == null) {
			timer = new Timer();
		}
		timer.scheduleAtFixedRate(run, start, end);
	}
	
	public static void cancel() {
		if(timer == null) {
			timer = new Timer();
		}
		timer.cancel();
	}

}
