package develcode.devel.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LocalDate birth_date;

    private String photo;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User() {
    }

    public User(String name, String code, LocalDate  birth_date) {
        this.name = name;
        this.code = code;
        this.birth_date = birth_date;

    }
}
