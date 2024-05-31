package pizzaCalories;

class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingModifier;
        switch (toppingType) {
            case "Meat":
                toppingModifier = 1.2;
                break;
            case "Veggies":
                toppingModifier = 0.8;
                break;
            case "Cheese":
                toppingModifier = 1.1;
                break;
            default:
                toppingModifier = 0.9;
        }
        return (2 * weight) * toppingModifier;
    }
}