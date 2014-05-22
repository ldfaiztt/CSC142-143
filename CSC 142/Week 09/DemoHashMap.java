import java.util.*;
/**
 * A short demo of HashMap and Iterator.
 * This sample makes use of Java 1.5.0 generics.
 * 
 * @author csc142
 * @version 2-17-06
 */
public class DemoHashMap
{
    /**
     * The data type of accounts is HashMap<String, BankAccount>
     * This means that KEYS used in this HashMap must be type String
     * and VALUES must be type BankAccount.
     */
    private HashMap<String, BankAccount> accounts;
    
    public DemoHashMap()
    {
        accounts = new HashMap<String, BankAccount>( );
    }

    /**
     * Construct a new BankAccount and add it to the map.  The account 
     * ID is used to create the key for the HashMap entry, and the 
     * account itself is the value.
     * @param ID the account identification
     * @param name the account owner's name
     * @param balance the initial account balance
     */
    public void addAccount( String ID, String name, double balance )
    {
        BankAccount newAccount = new BankAccount( name, ID, balance );
        accounts.put( ID, newAccount );
    }

    /**
     * Show in the terminal window a description of the BankAccount
     * associated with the account number provided, or an error message
     * if there is no account with that number.
     * @param num the account number
     */
    public void showAccount( String ID)
    {
        BankAccount acc = accounts.get( ID );
        if ( acc == null )
            System.out.println("Sorry, account number not found.");
        else 
            printAccount( acc );
    }

    /**
     * Show in the terminal window a listing of all bank accounts in the
     * collection by using an Iterator to iterate through the HashMap's
     * key set.
     */
    public void showAllAccounts()
    {
        // Notice that both the Set and the Iterator are declared
        // with type String as the type argument.  The keys used
        // in the HashMap are String objects, so that's what will
        // provided in the key set, and therefore by the Iterator.
        Set<String> accSet = accounts.keySet();
        Iterator<String> it = accSet.iterator();
        while ( it.hasNext() ) {
            String ID = it.next();
            BankAccount b = accounts.get( ID );
            printAccount( b );
        }
    }

    /**
     * Show in the terminal window a representation of the BankAccount
     * object provided.
     * @param acc the account to show
     */
    private void printAccount( BankAccount acc )
    {
        System.out.println( "Account summary for " + acc.getID() );
        System.out.println( "  Name: " + acc.getOwner() );
        System.out.println( "  Balance: " + acc.getBalance() );
    }
    
    /**
     * A short method to test this class.
     */
    public void test()
    {
        System.out.println( "RUNNING TEST..." );
        accounts.clear();
        addAccount( "123456", "Mary", 1200.0 );
        addAccount( "987654", "Joey", 1.95 );
        addAccount( "888888", "Bill", 10000000001.95 );
        
        showAccount( "888888" );
        showAccount( "2" );
        showAllAccounts();

        System.out.println( "NOW ADD A FEW MORE AND SHOW ALL..." );
        addAccount( "288", "Wong", 250000.0 );
        addAccount( "1234567890", "Monty", 20000000.0 );
        showAllAccounts();
    }
    
    /**
     * Allows the test to be run from a command prompt.
     */
    public static void main( String[] args ) {
        DemoHashMap d = new DemoHashMap( );
        d.test( );
    }
}
