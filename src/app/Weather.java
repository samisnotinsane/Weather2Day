/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.github.dvdme.ForecastIOLib.FIOAlerts;
import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.FIOMinutely;
import com.github.dvdme.ForecastIOLib.ForecastIO;

/**
 * Provides all weather forecast data using the ForecastIO API.
 * 
 * @author sameenislam
 */
public class Weather {
    
    private static ForecastIO fio;
    private static String apiKey = "a40d79b7f2233f02a693186d335b8f02";
    
    public static void main(String[] args) {
        System.out.println("Calling initialise()");
        initialise();        
        
        System.out.println("Calling currently()");
        currently(); // current weather reports
        
        System.out.println("Calling minutely()");
        minutely();
        
        System.out.println("Calling daily()");
        daily();
        
        System.out.println("Calling alerts()");
        alerts();
        
    } // END main
    
    private static void initialise() {
        fio = new ForecastIO(apiKey);                  //instantiate the class with the API key. 
        fio.setUnits(ForecastIO.UNITS_SI);             //sets the units as SI - optional
        fio.setExcludeURL("hourly,minutely");          //excluded the minutely and hourly reports from the reply
        fio.getForecast("51.5072", "0.1275");   // location unknown
    }
    
    // returns weather data matching current conditions
    public static void currently() {
        initialise();
        // get current weather conditions
        FIOCurrently currently = new FIOCurrently(fio);
        System.out.println("\nCurrently\n");
        String [] f  = currently.get().getFieldsArray();
        for(int i = 0; i<f.length;i++)
            System.out.println(f[i]+": "+currently.get().getByKey(f[i]));
    } // END currently
    
     private static void minutely() {
         // minutely data
        FIOMinutely minutely = new FIOMinutely(fio);
        //In case there is no minutely data available
        if(minutely.minutes()<0)
            System.out.println("No minutely data.");
        else
            System.out.println("\nMinutely\n");
        //Print minutely data
        for(int i = 0; i<minutely.minutes(); i++){
            String [] m = minutely.getMinute(i).getFieldsArray();
            System.out.println("Minute #"+(i+1));
        for(int j=0; j<m.length; j++)
            System.out.println(m[j]+": "+minutely.getMinute(i).getByKey(m[j]));
        }  
    } // END minutely

    private static void hourly() {
        // hourly
        FIOHourly hourly = new FIOHourly(fio);
        //In case there is no hourly data available
        if(hourly.hours()<0)
            System.out.println("No hourly data.");
        else
            System.out.println("\nHourly:\n");
        //Print hourly data
        for(int i = 0; i<hourly.hours(); i++){
            String [] h = hourly.getHour(i).getFieldsArray();
            System.out.println("Hour #"+(i+1));
            for(int j=0; j<h.length; j++)
                System.out.println(h[j]+": "+hourly.getHour(i).getByKey(h[j]));
            System.out.println("\n");
        // ----
        }
    } // END hourly

    private static void daily() {
        // daily
         FIODaily daily = new FIODaily(fio);
        //In case there is no daily data available
        if(daily.days()<0)
            System.out.println("No daily data.");
        else
            System.out.println("\nDaily:\n");
        //Print daily data
        for(int i = 0; i<daily.days(); i++){
            String [] h = daily.getDay(i).getFieldsArray();
            System.out.println("Day #"+(i+1));
            for(int j=0; j<h.length; j++)
                System.out.println(h[j]+": "+daily.getDay(i).getByKey(h[j]));
            System.out.println("\n");
        }
    } // END daily

    private static void alerts() {
         // Alerts
        FIOAlerts alerts = new FIOAlerts(fio);
        //Check if there are alerts
        if(alerts.NumberOfAlerts() <= 0){
            System.out.println("No alerts for this locatoin.");
        } 
        //if there are alerts, print them.
        else {
            System.out.println("Alerts");
            for(int i=0; i<alerts.NumberOfAlerts(); i++)
                System.out.println(alerts.getAlert(i));
        }
    } // END alerts

//    public static String showTemperature() {
//         // get current weather conditions
//        FIOCurrently currently = new FIOCurrently(fio);
//        String [] f  = currently.get().getFieldsArray();
//        String precip = currently.get().getByKey(f[11]);
//        System.out.println(f[11]+": "+precip);
//        return precip;
//    }

    public static String currentTemperature() {
        initialise();
         // get current weather conditions
        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();
        String temper = currently.get().getByKey(f[11]);
        //System.out.println("Temperature: "+precip);
        return temper;
    }
    
    public static String precipIntensity() {
        initialise(); 
        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();
        String precip = currently.get().getByKey(f[1]);
        return precip;
    }
    
    public static String currentSummary() {
        initialise();
        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();
        String con = currently.get().getByKey(f[0]);
        return con;
    }
    
}

