package network.y9.annotation.inheritance;


@TestAnnotation(value = "parent")
public class Parent {

    @TestAnnotation(value = "parentMethod")
    public void method(){

    }
}
