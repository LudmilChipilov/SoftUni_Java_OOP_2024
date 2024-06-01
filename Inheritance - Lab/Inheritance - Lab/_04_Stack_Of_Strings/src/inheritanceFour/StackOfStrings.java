package inheritanceFour;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfStrings
{
    private ArrayList<String> data;
    public StackOfStrings()
    {
        this.data = new ArrayList<>();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
    public void push(String item)
    {
        data.add(item);
    }
    public String pop()
    {
        if(isEmpty())
        {
            return null;
        }
        String element = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return element;
    }
    public String  peek()
    {
        if(!isEmpty())
        {
            return data.get(data.size() - 1);
        }
        return null;
    }
    public boolean isEmpty()
    {
        if(data.isEmpty())
        {
            return true;
        }
        return false;
    }
}
