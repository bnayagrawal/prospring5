package dev.bnayagrawal.prospring5.chapter4.profiles.highschool;

import dev.bnayagrawal.prospring5.chapter4.profiles.Food;
import dev.bnayagrawal.prospring5.chapter4.profiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {

    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
