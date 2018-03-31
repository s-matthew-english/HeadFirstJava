class MyOuterClass {

  private static int x; 

  class MyInnerClass {
    void go() {
      x = 42; 
      System.out.println("inside: " + x);
    }
  }

  public static void main(String[] args) {

    //MyOuterClass.MyInnerClass ic = new MyInnerClass();

    // MyInnerClass a = new MyOuterClass().new MyInnerClass();
    // a.go();

    new MyOuterClass().new MyInnerClass().go();

    System.out.println("outside: " + x);
    
    if(x == 42) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
  }
}
