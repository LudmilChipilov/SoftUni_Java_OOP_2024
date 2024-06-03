package ferrari;

public class Ferrari implements Car
{
    private String driverName;
    private final String model = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    @Override
    public String toString()
    {
        return String.format("%s/%s/%s/%s%n", model, brakes(), gas(), driverName);
    }
}
