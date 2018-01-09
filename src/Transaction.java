/** *********************************************************************
 * File:	Transaction.java
 * Author:	P. Howells
 * Contents:	6SENG002W CWK:
 *		Provides the basic data structure for a bank transaction.
 *		That is customer id & the amount to either deposit or
 *		withdraw
 * Created:	27/2/17
 * Modified:	10/11/17
 * Version:	1.0
 ************************************************************************ */


public class Transaction {

    private final String CustomerID ;
    private final int    amount ;

    public Transaction( String CID, int amount ) {
        this.CustomerID  = CID ;
        this.amount 	 = amount ;
    }

    public String getCID( )    {
        return CustomerID ;
    }

    public int getAmount( ) {
        return amount ;
    }

    public String toString( ) {
        return  new String( "[ " + "Customer: " + CustomerID + ", " + "Amount: "   + amount + "]"  ) ;
    }
}
