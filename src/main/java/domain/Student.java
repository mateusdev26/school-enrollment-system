package domain;
import lombok.*;
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public final class Student {
    private long id;
    private int age;
    private String name;
    private String grade;
    private Float mark;
}