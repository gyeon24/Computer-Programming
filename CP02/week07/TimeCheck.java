import java.util.*;

public class TimeCheck {

    public static void main(String[] args){
        Vector<Double> myVector = new Vector<>();
        ArrayList<Double> myArrayList = new ArrayList<>();
        LinkedList<Double> myLinkedList = new LinkedList<>();

        long startTime = 0;
        Random myRandom = new Random();

        double vectorT1, vectorT2, vectorT3, vectorT4;
        double arrayListT1, arrayListT2, arrayListT3, arrayListT4;
        double linkedListT1, linkedListT2, linkedListT3, linkedListT4;

        /*
        T1: add last
        T2: access random
        T3: add first
        T4: random add/remove
         */

        // 1. add last
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myVector.add(Math.random());
        }
        vectorT1 = (System.nanoTime() - startTime) / 1e6;

        // 2. access random
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myVector.get((int)(Math.random()*myVector.size()));
        }
        vectorT2 = (System.nanoTime() - startTime) / 1e6;

        // 3. add first
        myVector = new Vector<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myVector.add(0, Math.random());
        }
        vectorT3 = (System.nanoTime() - startTime) / 1e6;

        // 4. random add/remove
        myVector = new Vector<>();
        startTime = System.nanoTime();
        int randomNumber = 0;
        for (int i = 0; i < 100000; i++) {
            randomNumber = myRandom.nextInt(2);
            if(myVector.size()==0 || randomNumber==0){
                myVector.add(Math.random());
            }else{
                myVector.remove((int)(Math.random()*myVector.size()));
            }
        }
        vectorT4 = (System.nanoTime() - startTime) / 1e6;

        System.out.println("[Vector] T1: "+vectorT1+"ms T2: "+vectorT2+"ms T3: "+vectorT3+"ms T4: "+vectorT4+"ms");

        // TODO: ArrayList 를 위해 위의 코드를 작성
// 1. add last
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myArrayList.add(Math.random());
        }
        arrayListT1 = (System.nanoTime() - startTime) / 1e6;

        // 2. access random
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myArrayList.get((int)(Math.random()*myArrayList.size()));
        }
        arrayListT2 = (System.nanoTime() - startTime) / 1e6;

        // 3. add first
        myArrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myArrayList.add(0, Math.random());
        }
        arrayListT3 = (System.nanoTime() - startTime) / 1e6;

        // 4. random add/remove
        myArrayList = new ArrayList<>();
        startTime = System.nanoTime();
        randomNumber = 0;
        for (int i = 0; i < 100000; i++) {
            randomNumber = myRandom.nextInt(2);
            if(myArrayList.size()==0 || randomNumber==0){
                myArrayList.add(Math.random());
            }else{
                myArrayList.remove((int)(Math.random()*myArrayList.size()));
            }
        }
        arrayListT4 = (System.nanoTime() - startTime) / 1e6;

        System.out.println("[ArrayList] T1: "+arrayListT1+"ms T2: "+arrayListT2+"ms T3: "+arrayListT3+"ms T4: "+arrayListT4+"ms");

        // TODO: LinkedList 를 위해 위의 코드 작성
        // 1. add last
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myLinkedList.add(Math.random());
        }
        linkedListT1 = (System.nanoTime() - startTime) / 1e6;

        // 2. access random
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myLinkedList.get((int)(Math.random()*myLinkedList.size()));
        }
        linkedListT2 = (System.nanoTime() - startTime) / 1e6;

        // 3. add first
        myLinkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            myLinkedList.add(0, Math.random());
        }
        linkedListT3 = (System.nanoTime() - startTime) / 1e6;

        // 4. random add/remove
        myLinkedList = new LinkedList<>();
        startTime = System.nanoTime();
        randomNumber = 0;
        for (int i = 0; i < 100000; i++) {
            randomNumber = myRandom.nextInt(2);
            if(myLinkedList.size()==0 || randomNumber==0){
                myLinkedList.add(Math.random());
            }else{
                myLinkedList.remove((int)(Math.random()*myLinkedList.size()));
            }
        }
        linkedListT4 = (System.nanoTime() - startTime) / 1e6;

        System.out.println("[LinkedList] T1: "+linkedListT1+"ms T2: "+linkedListT2+"ms T3: "+linkedListT3+"ms T4: "+linkedListT4+"ms");

    }
}
