package borderControl;

public class Citizen implements Identifiable
{
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id)
    {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    @Override
    public String getId() {
        return id;
    }
    private void setId(String id)
    {
        if(id == null || id.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }
    public String getName() {
        return name;
    }
    private void setName(String name)
    {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        this.age = age;
    }
}
