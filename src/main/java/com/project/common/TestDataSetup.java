package com.project.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestDataSetup {

	private static int totalEvents;
	
	
	

	public static int getTotalEvents() {
		return totalEvents;
	}

	public static void setTotalEvents(int totalEvents) {
		TestDataSetup.totalEvents = totalEvents;
	}

	public static String getUUID(){
		return new SimpleDateFormat("MMdd_HHmmss").format(Calendar.getInstance().getTime());
	}
}
