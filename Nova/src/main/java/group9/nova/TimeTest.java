/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group9.nova;
import java.time.*;

/**
 *
 * @author xxcoo
 */

public class TimeTest {
    public static void main(String[] args) {
        Time t1 = new Time(23, 18, 23);
        LocalTime lt = LocalTime.now();
        System.out.println(lt); 
        System.out.printf("Time: %s", t1.toString());
        
        
    }
}
