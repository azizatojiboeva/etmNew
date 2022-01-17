package uz.elmurodov.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseUtils {
    public static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

}
