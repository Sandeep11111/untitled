import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Observer {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(1,2,3,4,null);

        io.reactivex.Observer<Integer> observer  = new io.reactivex.Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
              //System.out.println(d);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        };

        observable.subscribe(observer);
    }
}
