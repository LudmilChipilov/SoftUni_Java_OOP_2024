package animals;

public abstract class Animal
{
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    private void setName(String name)
    {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age)
    {
        if(age < 0)
        {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender)
    {
        if(gender == null || gender.isEmpty())
        {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    public abstract String produceSound();

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", this.getClass().getSimpleName()));
        sb.append(String.format("%s %d %s%n", name, age, gender));
        sb.append(produceSound()).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
