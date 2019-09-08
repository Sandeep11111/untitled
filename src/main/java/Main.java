import io.reactivex.Observable;
//https://www.youtube.com/user/StylerockZzZ
public class Main {

    public static void main(String arg[]) {
        Observable.just(1,2,3,4,5)
                .subscribe(System.out::println);

        Thread thread = new Thread(Main::runit);

    }
        public static void runit(){

        }
}
