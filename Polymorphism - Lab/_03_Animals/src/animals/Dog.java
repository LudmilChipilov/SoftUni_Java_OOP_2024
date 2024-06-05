package animals;

public class Dog extends Animal
{
    private String name;
    private String favouriteFood;
    protected Dog(String name, String favouriteFood)
    {
        super(name, favouriteFood);
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    @Override
    public String explainSelf()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("I am %s and my favourite food is %s%n", getName(), getFavouriteFood()));
        sb.append("DJAAF").append(System.lineSeparator());
        return sb.toString().trim();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }
}
