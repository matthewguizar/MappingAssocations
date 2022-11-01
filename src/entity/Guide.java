package entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="staff_id", nullable = false)
    private String staffId;

    
    private String name;
    private Integer salary;
    
    @OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST})
    private Set<Student> students = new HashSet<>();

    public Guide() {
    }

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }

    public void setSalary(int amount){
        this.salary = amount;
    }

    public Set<Student> getStudents(){return students;}
    
    public void addStudents(Student student) {
        students.add(student);
        student.setGuide(this);
    }
}
