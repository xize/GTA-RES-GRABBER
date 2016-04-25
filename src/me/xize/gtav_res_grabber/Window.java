package me.xize.gtav_res_grabber;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public class Window {
	
	//credits to "Hovercraft Full Of Eels" who wrote this at http://stackoverflow.com/questions/6091531/how-to-get-the-x-and-y-of-a-program-window-in-java
	
	private static Window window;
	
	/**
	 * @author xize
	 * @param Override the current class User32, in order to inject and override more methods.
	 */
	public interface User32 extends StdCallLibrary {
		
		//TODO: figuring out to let it generate a double value.
		
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
		HWND FindWindow(String lpClassName, String lpWindowName);
		int GetWindowRect(HWND handle, int[] rect);
	}
	
	/**
	 * returns the window size, by overriding the protected methods.
	 * 
	 * @author xize
	 * @param name - the name of the window
	 * @return double[]
	 * @throws Exception
	 */
	public int[] getWindowSize(String name) throws Exception {
		HWND window = User32.INSTANCE.FindWindow(null, name);
		if(window == null) {
			throw new Exception("window \""+name+"\" does not exist");
		}
		int[] data = {0, 0, 0, 0};
		int result = User32.INSTANCE.GetWindowRect(window, data);
		if(result == 0) {
			throw new Exception("window \""+name+"\" size is null");
		}
		return data; //double returns invalid NaN([0.0, 2.291755455191E-311, 0.0, 0.0]) by changing the int[] in the User32 interface in the abstract method GetWindowRect which is strange maybe a issue with my own implementation.
	}
	
	/**
	 * returns the window api
	 * 
	 * @author xize
	 * @return Window
	 */
	public static Window getWindowApi() {
		if(window == null) {
			window = new Window();
		}
		return window;
	}
	
	
}
