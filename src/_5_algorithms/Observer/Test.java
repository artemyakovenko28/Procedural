package _5_algorithms.Observer;

public class Test {
    public static void main(String[] args) {
        Observable<String> observable = new Observable<>();

        Observer<String> firstObserver =
                event -> System.out.println("first observer notified about event: " + event);
        Observer<String> secondObserver =
                event -> System.out.println("second observer notified about event: " + event);

        observable.subscribe(firstObserver);
        observable.subscribe(secondObserver);

        observable.next("hello world!");
        observable.next("it's second event!");

        observable.unsubscribe(secondObserver);
        observable.next("only first observer will be notified about this event");
    }
}
