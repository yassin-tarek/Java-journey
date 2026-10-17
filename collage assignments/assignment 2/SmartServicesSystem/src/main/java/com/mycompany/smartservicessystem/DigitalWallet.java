package com.mycompany.smartservicessystem;

public class DigitalWallet {
    private final String walletId;
    private String ownerName;
    private double balance;
    private int transactionCount;
        public DigitalWallet(String walletId ,String ownerName , double balance ){
            if(walletId == null || walletId.isBlank())
                throw new IllegalArgumentException("Invalid walletID");            
            this.walletId = walletId;
            
            if(ownerName == null || ownerName.isBlank())
                throw new IllegalArgumentException("Invalid ownername");                        
            this.ownerName = ownerName;
            
            if(balance < 0)
                throw new IllegalArgumentException("Invalid balance");            
            this.balance = balance;
            
            transactionCount = 0;
            }
    // setters and getters
    public String getWalletId(){
        return walletId;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public boolean setOwnerName(String ownerName){
        if(ownerName == null || ownerName.isBlank())
        return false;
    this.ownerName = ownerName;
    return true;
    }
    public double getBalance(){
        return balance;
    }
    public int getTransactionCount(){
        return transactionCount;
    }
    
   // deposite method
   public boolean deposit(double amount){
       if(amount > 0){
           balance+=amount;
           transactionCount++;
           return true;
       }
       return false;
   }
   
   // withdraw
   public boolean withdraw(double amount){
       if(amount > 0 && amount <= balance ){
           balance-= amount;
           transactionCount++;
           return true;
       }
       return false;
   }
   //calculation transaction fee
   private double calculateTransactionFee(double amount){
       double fee;
       if(amount < 500)
          fee = 5;
       else if(amount < 1000)
           fee = 10;
       else
           fee = 15;
       return fee;
       
   }
   
   
   // transfer
   public boolean transfer(DigitalWallet receiver, double amount){
        if(receiver == null || receiver == this || amount <= 0)
           return false;
        double totalAmount = calculateTransactionFee(amount)+amount;
        if(totalAmount > this.balance)
            return false;
        
        receiver.balance += amount;
        this.balance -= totalAmount;
       receiver.transactionCount++;
       this.transactionCount++;
       return true;
   }
   
}
