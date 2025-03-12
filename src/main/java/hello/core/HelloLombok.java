package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name ;
    private int age ;

    public static void main(String[] args) {
        HelloLombok hollLomok = new HelloLombok();
        hollLomok.setName("adb");

        System.out.println("hollLomok:: " +hollLomok.name );
    }
}
