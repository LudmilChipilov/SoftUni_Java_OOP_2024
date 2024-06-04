package telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable
{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse()
    {
        StringBuilder sb = new StringBuilder();
        for(String url : urls)
        {
            if(checkIfUrlIsValid(url))
            {
                sb.append(String.format("Browsing: %s!%n", url));
            }
            else
            {
                sb.append(String.format("Invalid URL!%n"));
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call()
    {
        StringBuilder sb = new StringBuilder();
        for(String number : numbers)
        {
            if(checkIfNumberIsValid(number))
            {
                sb.append(String.format("Calling... %s%n", number));
            }
            else
            {
                sb.append(String.format("Invalid number!%n"));
            }
        }
        return sb.toString().trim();
    }
    public boolean checkIfNumberIsValid(String number)
    {
        for(int i = 0; i < number.length(); i++)
        {
            if(!Character.isDigit(number.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkIfUrlIsValid(String url)
    {
        for(int i = 0; i < url.length(); i++)
        {
            if(Character.isDigit(url.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
