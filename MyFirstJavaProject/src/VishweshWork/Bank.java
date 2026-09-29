package VishweshWork;



class BankAcount{
	private double balance = 3000;
	   
	   public void deposite(double amount) {
		   
		   if(amount > 0) {
			   balance += amount;
			   System.out.println("amount deposite "+amount);
			   showBalance("depiste done "+amount +" balance is "+balance);
		   }
	   }
	   
	   private void showBalance(String msg) {
		   System.out.println("amount credited balance is "+msg);
	   }
}



class Bank {
   public static void main(String args[]) {
	   
	   
	   BankAcount ba = new BankAcount();
	   ba.deposite(500);
	   
}

}


