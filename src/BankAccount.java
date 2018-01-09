/** *********************************************************************
 * File:	BankAccount.java
 * Author:	P. Howells
 * Contents:	6SENG002W CWK:
 *		This provides the interface for a Bank Account class.
 * Created:	27/2/17
 * Modified:	10/11/17
 * Version:	1.0
 ************************************************************************ */


public interface BankAccount {

    int    getBalance( ) ;           // returns the current balance

    int    getAccountNumber( ) ;     // returns the Account number

    String getAccountHolder( ) ;     // returns the Account holder


    void deposit( Transaction t ) ;     // perform a deposit transaction on the bank account

    void withdrawal( Transaction t ) ;  // perform a withdrawal transaction on the bank account


    boolean isOverdrawn( ) ;         // returns true if overdrawn; false otherwise

    void printStatement( ) ;         // prints out the transactions performed so far
}
