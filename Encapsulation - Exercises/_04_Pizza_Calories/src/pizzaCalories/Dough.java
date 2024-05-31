package pizzaCalories;
class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories()
    {
        double flourModifier = flourType.equals("White") ? 1.5 : 1.0;
        double techniqueModifier;
        switch (bakingTechnique)
        {
            case "Crispy":
                techniqueModifier = 0.9;
                break;
            case "Chewy":
                techniqueModifier = 1.1;
                break;
            default:
                techniqueModifier = 1.0;
        }
        return (2 * weight) * flourModifier * techniqueModifier;
    }
}