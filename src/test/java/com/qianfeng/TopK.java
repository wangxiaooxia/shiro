package com.qianfeng;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TopK {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date oldDate = format.parse("2020-08-01 00:00:00");
        Date newData = format.parse("2020-10-01 00:00:00");

        long time = newData.getTime() - oldDate.getTime();

        long day = time/1000/60/60/24;

        System.out.println(day);


    }

}
