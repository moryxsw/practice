package network.y9.optional;

import java.util.Objects;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Student student = new Student();
        student.setName("王");

        Optional<Student> studentOpt = Optional.ofNullable(student);

        studentOpt.ifPresent(s -> System.out.println(s.getName()));

        // 多层空值校验
        String address = Optional.ofNullable(student)
                .map(Student::getAddress)
                .map(Address::getName)
                .orElseThrow(() -> new RuntimeException("地址不存在"));

        // 校验替换
        Student stu = Optional.ofNullable(student)
                .filter(s -> Objects.equals(s.getName(), "王"))
                .orElseGet(() -> {
                    return Student.builder().name("王").build();
                });



    }
}
