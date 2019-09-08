import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class DisposableAndComposite {
    public static void main(String[] args) throws InterruptedException {
       // handleDisposable();
        //handleDisposbleInObserver();
        //handleDisposbleOutsideObserver();
        compositeDisposable();
    }

    private static void handleDisposable() throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        Thread.sleep(3000);
        disposable.dispose();
//        Thread.sleep(3000);
//        observable.subscribe(System.out::println);
//        Thread.sleep(3000);
    }

    private static void handleDisposbleInObserver() throws InterruptedException{
        Observable<Integer> observable =  Observable.just(1,2,3,4,5);
        Observer<Integer> observer = new Observer<Integer>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
             disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
             if(integer == 3){
                 disposable.dispose();
             }
             System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
         observable.subscribe(observer);
    }

    private static void handleDisposbleOutsideObserver() throws InterruptedException {
        Observable<Integer> observable =  Observable.just(1,2,3,4,5);
        ResourceObserver<Integer> observer = new ResourceObserver<Integer>() {

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Disposable disposable = observable.subscribeWith(observer);
        disposable.dispose();

    }
    private static void compositeDisposable() throws InterruptedException{
//        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
//        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1---"+item));
//        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2---"+item));
//        Thread.sleep(3000);
//        disposable1.dispose();
//        disposable2.dispose();
//        Thread.sleep(3000);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1---"+item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2---"+item));
        compositeDisposable.addAll(disposable1,disposable2);
        Thread.sleep(3000);
        compositeDisposable.dispose();
        Thread.sleep(3000);
    }
}
