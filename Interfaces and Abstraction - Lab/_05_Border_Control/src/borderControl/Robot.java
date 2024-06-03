package borderControl;

public class Robot implements Identifiable
{
    private String model;
    private String id;

    public Robot(String model, String id)
    {
        this.setId(id);
        this.setModel(model);
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
    public String getModel() {
        return model;
    }
    private void setModel(String model)
    {
        if(model == null || model.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
}
