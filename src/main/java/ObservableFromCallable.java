import io.reactivex.Observable;

import java.util.concurrent.Callable;
//https://www.youtube.com/watch?v=aWhhgVblLDU&list=PLYHDP_mF5KjYC-k2DEVtOZCmjHfQqnav4&index=12
public class ObservableFromCallable {
    public static void main(String[] args) {
//        Observable<Integer> observable = Observable.just(getNumber());
//        observable.subscribe(System.out::println, error->System.out.println("An Exception occured"+error.getLocalizedMessage()),
//                ()-> System.out.println("complete"));
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("calling method");
            return getNumber();
        });
        observable.subscribe(System.out::println, error->System.out.println("An Exception occured"+error.getLocalizedMessage()),
                ()-> System.out.println("complete"));
    }

    public static int getNumber(){
        System.out.println("generating value");
        //return 3*5;
        return 1/0;
    }
}
