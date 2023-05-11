package Dish;

public class ComTam implements Dish{
    @Override
    public String getName() {
        return "Com Tam";
    }

    @Override
    public String getDescription() {
        return "A dish consist of broken rice and numerous toppings" +
                " such as fried eggs, shredded pork skin, grilled pork chops";
    }

    @Override
    public String getValue() {
        return "Calories: 527-761";
    }
}
