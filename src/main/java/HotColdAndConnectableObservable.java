import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class HotColdAndConnectableObservable {
    public static void main(String[] args) {
        //createColdObservable();
        createHotAndConnectableObservable();
    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1,2,3);

        observable.subscribe(item-> System.out.println("observer1"+item));

        pause(3000);

        observable.subscribe(item-> System.out.println("observer2"+item));
    }
    private static void createHotAndConnectableObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1,2,3,4,5).publish();

        observable.subscribe(item-> System.out.println("observer1"+item));
        observable.subscribe(item-> System.out.println("observer1"+item));
        observable.connect();
    }

    private static void pause(int duration){
        try {
            Thread.sleep(duration);
        } catch(InterruptedException e) {
             e.printStackTrace();
        }
    }
}
