package me.xize.gtav_res_grabber.scheduler;

import java.util.Timer;

public class Scheduler {
	
	private static Timer timer = new Timer();
	
	/**
	 * starts a delayed task
	 * 
	 * @author xize
	 * @param run - the gta runnable
	 * @param when - when the task fires
	 */
	public static void scheduleDelayedTask(GTARunnable run, long when) {
		if(timer == null) {
			timer = new Timer();
		}
		timer.schedule(run, when);
	}
	
	/**
	 * starts a scheduled task
	 * 
	 * @author xize
	 * @param run - the GTA runnable
	 * @param delay
	 * @param end
	 */
	public static void runTaskTimer(GTARunnable run, long delay, long period) {
		if(timer == null) {
			timer = new Timer();
		}
		timer.scheduleAtFixedRate(run, delay, period);
	}
	
	/**
	 * cancels all tasks
	 * 
	 * @author xize
	 */
	public static void cancel() {
		if(timer == null) {
			timer = new Timer();
		}
		timer.cancel();
	}

}
