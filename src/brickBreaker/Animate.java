package brickBreaker;

public class Animate implements Runnable {
    BrickBreakerPanel brickBreaker;

    public Animate(BrickBreakerPanel bp) {
        this.brickBreaker = bp;
    }

    @Override
    public void run() {
        while(true) {
            brickBreaker.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
