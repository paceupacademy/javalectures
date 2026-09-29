package VishweshWork;

class AccessSpecifierExample {
	 public static void main(String[] args) {
	    	
	    	Demo d = new Demo();
	    	System.out.println(" public var "+d.name);
	    	
	    	System.out.println(" default var "+d.data);
	    	
	    	System.out.println(" protected var "+d.result);
	    	
	    //	System.out.println(" private var "+d.info); not accesible you can access via public methid
	    	
	    	d.showPrivate();
	    }
    
}
class Demo {
	
	  int data;
      private String info;
      public String name;
      protected float result;
      
      public void showPrivate() {
          System.out.println(info); 
      }
   
}