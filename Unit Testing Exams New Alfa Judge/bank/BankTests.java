package bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTests
{
     Bank bank;
     Client client;

     @Test
     public void test_Client_Constructor_Should_Initialize_Correctly()
     {
          client = new Client("Ludmil");
          Assertions.assertEquals("Ludmil", client.getName());
          Assertions.assertTrue(client.isApprovedForLoan());
     }

     @Test
     public void test_Bank_Constructor_Should_Initialize_Correctly()
     {
         bank = new Bank("DSK", 3);
         Assertions.assertEquals("DSK", bank.getName());
         Assertions.assertEquals(3, bank.getCapacity());
         Assertions.assertEquals(0, bank.getCount());
     }
     @Test
     public void test_Bank_SetName_Should_Throws_Exception_If_Name_Null()
     {
          //bank = new Bank(null, 3);
          assertThrows(NullPointerException.class,
                  () -> new Bank(null, 3),
                  "Invalid name!");

     }
     @Test
     public void test_Bank_SetName_Should_Throws_Exception_If_Name_Empty()
     {
          //bank = new Bank(null, 3);
          assertThrows(NullPointerException.class,
                  () -> new Bank("   ", 3),
                  "Invalid name!");

     }
     @Test
     public void test_Bank_SetCapacity_Should_Throws_Exception_If_Capacity_Negative()
     {
          //bank = new Bank(null, 3);
          assertThrows(IllegalArgumentException.class,
                  () -> new Bank("DSK", -1),
                  "Invalid capacity!");

     }

     @Test
     public void test_Bank_addClient_Should_Throws_Exception_If_Capacity_Full()
     {
          bank = new Bank("DSK", 3);
          Client client1 = new Client("N1");
          Client client2 = new Client("N2");
          Client client3 = new Client("N3");
          Client client4 = new Client("N4");
          bank.addClient(client1);
          bank.addClient(client2);
          bank.addClient(client3);
          assertThrows(IllegalArgumentException.class,
                  () -> bank.addClient(client4),
                  "The bank has no capacity for more clients!");

     }

     @Test
     public void test_Bank_removeClient_Should_Throws_Exception_If_Capacity_Full()
     {
          bank = new Bank("DSK", 10);
          Client client1 = new Client("N1");
          Client client2 = new Client("N2");
          Client client3 = new Client("N3");
          Client client4 = new Client("N4");
          bank.addClient(client1);
          bank.addClient(client2);
          bank.addClient(client3);
          assertThrows(IllegalArgumentException.class,
                  () -> bank.removeClient("N4"),
                  "Client named N4 does not exist!");

     }

     @Test
     public void test_Bank_removeClient_Should_Decrease_Count()
     {
          bank = new Bank("DSK", 10);
          Client client1 = new Client("N1");
          Client client2 = new Client("N2");
          Client client3 = new Client("N3");

          bank.addClient(client1);
          bank.addClient(client2);
          bank.addClient(client3);
          bank.removeClient("N3");
          Assertions.assertEquals(2, bank.getCount());
     }

     @Test
     public void test_Bank_loanWithdrawal_Should_Throws_Exception_If_Client_Not_Exist()
     {
          bank = new Bank("DSK", 10);
          Client client1 = new Client("N1");
          Client client2 = new Client("N2");
          Client client3 = new Client("N3");
          Client client4 = new Client("N4");
          bank.addClient(client1);
          bank.addClient(client2);
          bank.addClient(client3);
          assertThrows(IllegalArgumentException.class,
                  () -> bank.loanWithdrawal("N4"),
                  "Client named N4 does not exist!");

     }
     @Test
     public void test_Bank_loanWithdrawal_Should_Set_ApprovedForLoan_To_False()
     {
          bank = new Bank("DSK", 10);
          Client client1 = new Client("N1");
          Client client2 = new Client("N2");
          Client client3 = new Client("N3");

          bank.addClient(client1);
          bank.addClient(client2);
          bank.addClient(client3);
          bank.loanWithdrawal("N3");
          Assertions.assertFalse(client3.isApprovedForLoan());
     }
     @Test
     public void test_Bank_statistics_Should_Return_Correct_String()
     {
          bank = new Bank("DSK", 10);
          Client client1 = new Client("N1");
          Client client2 = new Client("N2");
          Client client3 = new Client("N3");

          bank.addClient(client1);
          bank.addClient(client2);
          bank.addClient(client3);

          Assertions.assertEquals("The client N1, N2, N3 is at the DSK bank!", bank.statistics());
     }
}
