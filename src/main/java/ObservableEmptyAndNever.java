import io.reactivex.Observable;

public class ObservableEmptyAndNever {
    public static void main(String[] args) {
        //createEmptyObservable();// emit one time
        createNeverObservable();// never emit
    }

    private static void createEmptyObservable() {
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println,System.out::println, () -> System.out.println("completed"));
    }

    private static void createNeverObservable() {
        Observable observable = Observable.never();
        observable.subscribe(System.out::println,System.out::println, () -> System.out.println("completed"));
    }
}
