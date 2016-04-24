package me.xize.gtav_res_grabber;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextWriter {
	
	private static TextWriter writer;
	
	public void write(String data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String date = format.format(new Date()).toString();
		Main.getGui().getTextArea().append("["+date+"]: "+data+"\r\n");
	}
	
	public static TextWriter getWriter() {
		if(writer == null) {
			writer = new TextWriter();
		}
		return writer;
	}

}
