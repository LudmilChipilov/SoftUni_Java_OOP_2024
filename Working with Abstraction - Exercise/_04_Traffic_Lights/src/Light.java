public enum Light
{
    RED(0), GREEN(1), YELLOW(2);

    private int value;
    Light(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String changeLight(String input)
    {

         if(input.equals("RED"))
         {
             input = "GREEN";
         }
         else if(input.equals("GREEN"))
         {
             input = "YELLOW";
         }
         else if(input.equals("YELLOW"))
         {
             input = "RED";
         }
         return input;
    }
}
