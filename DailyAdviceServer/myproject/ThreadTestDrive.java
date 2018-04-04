class ThreadTestDrive {

  public static void main(String[] args) {

    for(int i = 0; i < 666; i ++) {
      theDeed();
    }

  }

  public static void theDeed() {
    Runnable threadJob = new MyRunnable();
    Thread myThread = new Thread(threadJob);

    myThread.start();

    System.out.println("back in main");
  }
}
