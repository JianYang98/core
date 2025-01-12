package hello.core.singleton;

public class SingletonService {

    private  static  final SingletonService instnace = new SingletonService();

    public static SingletonService getInstance(){
        return instnace;
    }

    public  void logic(){
        System.out.println("싱클톤 객체로직 호출 ");
    }
}
