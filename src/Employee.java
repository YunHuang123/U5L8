public class Employee {
    private String firstName;
    private String lastName;
    private int ID;
    private static int amount = 0;
    private static int mostRecent = 100;

    public Employee(String first, String last)
    {
        firstName = first;
        lastName = last;
        amount ++;
        mostRecent ++;
        ID = mostRecent;
    }

    public String fullName()
    {
        return firstName + " " + lastName;
    }

    public int IDNumber()
    {
        return ID;
    }

    public int amountEmployee()
    {
        return amount;
    }

    public int mostRecent()
    {
        return mostRecent;
    }
}
