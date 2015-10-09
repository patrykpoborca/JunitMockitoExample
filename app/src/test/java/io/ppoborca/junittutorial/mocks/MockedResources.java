package io.ppoborca.junittutorial.mocks;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

import java.util.HashMap;
import java.util.Map;

public class MockedResources extends Resources{
    private Map<Integer, String> stringMap;

    public MockedResources(){
        this(null, null, null);
    }

    public MockedResources(AssetManager assets, DisplayMetrics metrics, Configuration config) {
        super(assets, metrics, config);
        stringMap = new HashMap<>(1);
    }



    public void addString(int id, String value){
        stringMap.put(id, value);
    }

    @NonNull
    @Override
    public String getString(int id) throws NotFoundException {
        return stringMap.get(id);
    }
}
