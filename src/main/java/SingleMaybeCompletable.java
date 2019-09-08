import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.Callable;

public class SingleMaybeCompletable {
    public static void main(String[] args) {
        //createSingle();
        //  createMaybe();
        createCompletable();
    }
    private static void createSingle() {
        Single.just("Hello World").subscribe(System.out::println);
    }
    private static void createMaybe() {
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("onSuccess");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
               System.out.println("complete");
            }
        });
    }
    private static void createCompletable() {
       // Completable.fromCallable(() -> "Hello World").subscribe(System.out.println("done1"));
        Completable.fromSingle(Single.just("Hello World")).subscribe(() -> System.out.println("done"));
    }
}
