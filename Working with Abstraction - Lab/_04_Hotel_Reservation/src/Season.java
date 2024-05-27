public enum Season
{
    SPRING(2), SUMMER(4), AUTUMN(1), WINTER(3);
    private int value;
    Season(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return this.value;
    }

}
