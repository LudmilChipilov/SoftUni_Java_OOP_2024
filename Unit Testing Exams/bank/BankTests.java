package bank;
import org.junit.Test;
import org.junit.Assert;
public class BankTests
{
    Client client;
    Bank bank;
    @Test
    public void test_Client_Constructor_Should_Initialize_Correctly()
    {
        client = new Client("Ludmil");
        Assert.assertEquals("Ludmil", client.getName());
        Assert.assertTrue(client.isApprovedForLoan());
    }
    @Test
    public void test_Bank_Constructor_Should_Initialize_Correctly()
    {
       bank = new Bank("DSK", 5);
       Assert.assertEquals("DSK", bank.getName());
       Assert.assertEquals(5, bank.getCapacity());
       Assert.assertEquals(0, bank.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void test_Bank_setName_Should_Throws_Exception_If_Name_Null()
    {
        bank = new Bank(null, 5);

    }
    @Test(expected = NullPointerException.class)
    public void test_Bank_setName_Should_Throws_Exception_If_Name_WhiteSpace()
    {
        bank = new Bank("  ", 5);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Bank_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        bank = new Bank("DSK", -1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Bank_addClient_Should_Throws_Exception_If_Full_Capacity()
    {
        bank = new Bank("DSK", 5);
        Client client1 = new Client("C1");
        Client client2 = new Client("C2");
        Client client3 = new Client("C3");
        Client client4 = new Client("C4");
        Client client5 = new Client("C5");
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);
        Client client6 = new Client("C6");
        bank.addClient(client6);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Bank_removeClient_Should_Throws_Exception_If_Full_Capacity()
    {
        bank = new Bank("DSK", 10);
        Client client1 = new Client("C1");
        Client client2 = new Client("C2");
        Client client3 = new Client("C3");
        Client client4 = new Client("C4");
        Client client5 = new Client("C5");
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);
        Client client6 = new Client("C6");
        bank.removeClient("C6");

    }
    @Test
    public void test_Bank_removeClient_Should_Decrease_Count()
    {
        bank = new Bank("DSK", 10);
        Client client1 = new Client("C1");
        Client client2 = new Client("C2");
        Client client3 = new Client("C3");
        Client client4 = new Client("C4");
        Client client5 = new Client("C5");
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);
        bank.removeClient("C5");
        Assert.assertEquals(4, bank.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Bank_loanWithdrawal_Should_Throws_Exception_If_Client_Does_Not_Exist()
    {
        bank = new Bank("DSK", 10);
        Client client1 = new Client("C1");
        Client client2 = new Client("C2");
        Client client3 = new Client("C3");
        Client client4 = new Client("C4");
        Client client5 = new Client("C5");
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);
        Client client6 = new Client("C6");
        bank.loanWithdrawal("C6");

    }
    @Test
    public void test_Bank_loanWithdrawal_Should_Set_ApprovedForLoan_To_False()
    {
        bank = new Bank("DSK", 10);
        Client client1 = new Client("C1");
        Client client2 = new Client("C2");
        Client client3 = new Client("C3");
        Client client4 = new Client("C4");
        Client client5 = new Client("C5");
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);

        bank.loanWithdrawal("C5");
        Assert.assertFalse(client5.isApprovedForLoan());

    }
    @Test
    public void test_Bank_statistics_Should_Return_Correct_String()
    {
        bank = new Bank("DSK", 10);
        Client client1 = new Client("C1");
        Client client2 = new Client("C2");
        Client client3 = new Client("C3");
        Client client4 = new Client("C4");
        Client client5 = new Client("C5");
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);
        Assert.assertEquals("The client C1, C2, C3, C4, C5 is at the DSK bank!", bank.statistics());

    }
}

