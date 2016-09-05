package test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zwx729915632 on 2016/9/5.
 */
public class datetest {
    public static void main(String[] args) {
            Date now =new Date();
            Calendar cal =Calendar.getInstance();
            System.out.println(now);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date now2=new Date();
        now2.setYear(2015);
        System.out.println(now.getTime()+"  "+now2.getTime());
    }
}
