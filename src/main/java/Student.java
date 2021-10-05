import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {


    private int id;
    private String name;
    private int age;
    private String gender;
    private String university;
    private int numberOfLateReturnings;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", genre='" + gender + '\'' +
                ", university='" + university + '\'' +
                ", numberOfLateReturnings=" + numberOfLateReturnings +
                '}';
    }
}
