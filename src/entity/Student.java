package entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "enrollment_id", nullable = false)
    private String enrollment;

    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="guide_id")
    private Guide guide;


    public Student() {
    }

    public Student(String enrollment, String name, Guide guide) {
        this.enrollment = enrollment;
        this.name = name;
        this.guide = guide;
    }

    public Guide getGuide() {
        return guide;
    }
    public void setGuide(Guide guide){
        this.guide = guide;
    }

}
