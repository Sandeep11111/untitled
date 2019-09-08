import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import sun.tools.tree.BitAndExpression;

import java.util.concurrent.TimeUnit;

public class ObservableInterval {
    public static void main(String[] args) throws InterruptedException {
        Observable  observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(item-> System.out.println("emitting item...."+item));

        Thread.sleep(2000);

        observable.subscribe(item-> System.out.println("emitting item2...."+item));

        Thread.sleep(2000);

        //converting into connectable observable

        ConnectableObservable  observable1 = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable1.subscribe(item-> System.out.println("emitting item...."+item));

        observable1.connect();

        Thread.sleep(2000);

        observable1.subscribe(item-> System.out.println("emitting item2...."+item));

        observable1.connect();

        Thread.sleep(2000);
    }
}
