package Task3_prime_observer;

import java.util.ArrayList;
import java.util.List;

public class PrimeObservableThread implements Runnable,Subject{

    private static final int SLEEPTIME = 500;

    private int primeNumber;
    private int numCount = 1;
    private boolean stopRunning = false;

    private List<Observer> observerList;

    public PrimeObservableThread(){
        this.observerList = new ArrayList<Observer>();
    }

    public int getPrimeNumber() { return primeNumber; }

    public void stopRunning() {
        stopRunning = true;
    }

    public void startRunning() {
        stopRunning = false;
        run();
    }

    private void generatePrimeNumber() {

        primeNumber = 2;
        System.out.println(primeNumber);

        while (stopRunning == false) {

            numCount += 2; // 2를 제외한 짝수는 소수가 될 수 없음. 따라서 홀수만 검사
            if (isPrimeNumber(numCount)) {
                primeNumber = numCount;
                System.out.println(primeNumber);
                notiOb();
            }
            try {
                Thread.sleep(SLEEPTIME); // 1초 쉼
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrimeNumber(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() { //스레드를 새로 생성해서 이를 구동하는 메소드
        generatePrimeNumber();
    }

    @Override
    public void registeOb(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notiOb() {
        for(Observer observer: observerList){
            observer.update(primeNumber);
        }
    }

    @Override
    public void rmOb(Observer observer) {
        observerList.remove(observer);
    }
}
