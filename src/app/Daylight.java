/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Calendar;
import java.util.TimeZone;
import uk.me.jstott.sun.*;
import uk.me.jstott.coordconv.LatitudeLongitude;
/**
 *
 * @author sameenislam
 */
public class Daylight {
 
    public static void main(String[] args) {
        
                // -------------------------------------------------------------------------
		// Calculate sunrise and sunet times for London, England for today
		// -------------------------------------------------------------------------
		LatitudeLongitude ll = new LatitudeLongitude(51.5072,0.1275);
		TimeZone gmt = TimeZone.getTimeZone("Europe/London");
		Calendar cal = Calendar.getInstance();
		boolean dst = false;

		System.out.println("London, England - "
				+ cal.get(Calendar.DAY_OF_MONTH) + "/"
				+ (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR)
				+ " ");

		System.out.println("Sunrise               = "
				+ Sun.sunriseTime(cal, ll, gmt, dst));
		System.out.println("Sunset                = "
				+ Sun.sunsetTime(cal, ll, gmt, dst));	
    }
}
