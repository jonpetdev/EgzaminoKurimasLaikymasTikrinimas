

public class LaikasEgzui implements Runnable {


    public boolean done=true;

    @Override
    public void run() {
        this.runTimer();

    }

    public void runTimer(){
        //int i = 60*5;
        int i =30;
        while (i>0){
            System.out.println("Iki egzamino pabaigos iko: "+i/60+":"+i%60+" ");
            try {
                i=i-10;
                Thread.sleep(10000L);    // 1000L = 1000ms = 1 second
            }
            catch (InterruptedException e) {
                //I don't think you need to do anything for your particular problem
            }

        }
        System.err.println("Egzaminui skirtas laikas baigesi!!!!");
        done=false;

    }

}
