package com.ioc.factory;

import com.ioc.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
    private Map<Long, Car> carMap;
    public InstanceCarFactory(){
        carMap = new HashMap<Long, Car>();
        carMap.put(1L,new Car(1L,"baoma"));
        carMap.put(2L,new Car(2L,"benzi"));
    }
    public Car getCar(Long id){
        return carMap.get(id);
    }
}
