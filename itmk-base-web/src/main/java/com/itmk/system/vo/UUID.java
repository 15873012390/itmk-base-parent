package com.itmk.system.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UUID {
    public static String getNewNo(String heand){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return heand+newDate+result;
    }
}
