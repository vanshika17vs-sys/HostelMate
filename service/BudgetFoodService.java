package com.hostelmate.service;

import com.hostelmate.model.Food;
import java.util.ArrayList;
import java.util.List;

public class BudgetFoodService {

    private final List<Food> foods = new ArrayList<>();

    public BudgetFoodService() {

        foods.add(new Food("Poha", 20, 30, "Breakfast"));
        foods.add(new Food("Sandwich", 30, 50, "Snack"));
        foods.add(new Food("Chole Kulche", 40, 60, "Lunch"));
        foods.add(new Food("Rajma Rice", 50, 80, "Lunch"));
        foods.add(new Food("Dal Rice", 40, 60, "Dinner"));
        foods.add(new Food("Banana", 10, 20, "Healthy"));
        foods.add(new Food("Oats", 30, 50, "Healthy"));
        foods.add(new Food("Eggs", 20, 40, "Protein"));
        foods.add(new Food("Milk", 25, 40, "Healthy"));
        foods.add(new Food("Veg Thali", 60, 90, "Dinner"));
    }

    public List<Food> suggest(double budget) {

        List<Food> result = new ArrayList<>();

        for (Food food : foods) {

            if (food.min() <= budget) {
                result.add(food);
            }
        }

        return result;
    }
}