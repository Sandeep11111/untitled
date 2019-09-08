import io.reactivex.Observable;

public class ObservableRange {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(0,5);
        observable.subscribe(System.out::println);
    }
}
