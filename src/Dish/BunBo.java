package Dish;

public class BunBo implements Dish {
    @Override
    public String getName() {
        return "Bun Bo";
    }

    @Override
    public String getDescription() {
        return "A popular Vietnamese rice noodle dish" +
                " with sliced beef, chả lụa, and sometimes pork knuckles.";
    }

    @Override
    public String getValue() {
        return "Calories: 534";
    }
}
