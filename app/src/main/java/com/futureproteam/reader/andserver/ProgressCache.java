package com.futureproteam.reader.andserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/14.
 */

public class ProgressCache {

    private static Map<String,Float> progresses = new HashMap<>();

    public static float getProgress(String fileName){
        Float progress = progresses.get(fileName);
        if(progress == null){
            return -1;
        }
        return progress.floatValue();
    }

    public static void putProgress(String fileName,float progress){
       progresses.put(fileName,progress);
    }
}
