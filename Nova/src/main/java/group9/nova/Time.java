/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group9.nova;
import java.time.LocalTime;
/**
 *
 * @author xxcoo
 */
public class Time {
    private int hour;
    private int minute;
    private int second;
    private LocalTime time;
   
    public Time() { // Default constructor using current local time
        LocalTime now = LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
        this.time = now;
    }
    public Time(int hour, int minute, int second) { // Overloaded constructor
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("Hour must be between 0 and 24");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be between 0 and 60");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be between 0 and 60");
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.time = LocalTime.of(hour, minute, second);
    }
    
    public void setHour(int hour){ //constructor
        if (hour < 0 ||hour >=24)
            throw new IllegalArgumentException("Hour must be between 0 and 24");
        
        this.hour = hour;
    }
    
    public void setMinute(int minute){
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be between 0 and 60");
        
        this.minute = minute;
    }
    
    public void setSecond(int second){
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Minute must be between 0 and 60");
        
        this.second = second;
    }
    
    public int getHour(){
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public int getSecond(){
        return second;
    }
    
    public String toString(){
        return String.format("%d:%02d:%02d %s", 
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM")); 
    }
    
    
}
