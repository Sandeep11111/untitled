import io.reactivex.Observable;

public class ObservableDefer {

    private static int start=5, count=2;
    public static void main(String[] args) {

        // it didn't reset count because it not creating new instance of Observable.range
//        Observable<Integer> observable = Observable.range(start,count);
//        observable.subscribe(item-> System.out.println("observer 1-----"+item));
//        count = 3;
//        observable.subscribe(item-> System.out.println("observer 2-----"+item));

        Observable<Integer> observable = Observable.defer(()->Observable.range(start,count));
        observable.subscribe(item-> System.out.println("observer 1-----"+item));
        count = 3;
        observable.subscribe(item-> System.out.println("observer 2-----"+item));
    }
}
