public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        veganMeal.validateMeal();
    }
}
interface MealPlan {
    String getDescription();
}

class VegetarianMeal implements MealPlan {
    public String getDescription() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getDescription() {
        return "Vegan Meal";
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public void validateMeal() {
        System.out.println("Validating: " + meal.getDescription());
    }
}

