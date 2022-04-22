package com.tolgacobanoglu.makeaquerycentralcarpolicy;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils
{
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String mapToString(Map<String, String> map)
    {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "," + map.get(key))
                .collect(Collectors.joining("|"));

        return mapAsString;
    }

    public static Map<String,String> stringToMap(String data)
    {
        Map<String,String> reports = new HashMap<>();
        String[] pairs = data.split("\\|");

        for (int index = 0; index < pairs.length;index++)
        {
            String pair = pairs[index];
            String[] keyValue = pair.split(",");
            reports.put(keyValue[0],keyValue[1]);
        }

        return reports;
    }
}
