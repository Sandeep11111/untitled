import io.reactivex.Observable;

public class ObservableErrorCallable {
    public static void main(String[] args) {
        //throwsException();
        throwsExceptionUsingCallable();// create new instance for error
    }

    private static void throwsException() {
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error-> System.out.println("Error1: "+error.hashCode()));
        observable.subscribe(System.out::println, error-> System.out.println("Error2: "+error.hashCode()));
    }
    private static void throwsExceptionUsingCallable() {
        Observable observable = Observable.error(()->new Exception("An Exception"));
        observable.subscribe(System.out::println, error-> System.out.println("Error1: "+error.hashCode()));
        observable.subscribe(System.out::println, error-> System.out.println("Error2: "+error.hashCode()));
    }
}
