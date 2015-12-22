package by.khrapovitsky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "archives")
public class Archive {

    @Id
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "path",unique = true,nullable = false)
    private String path;
    @Column(name = "dateOfCreating",nullable = false)
    private Timestamp dateOfCreating;

    public Archive(String path,String name ,Timestamp dateOfCreating) {
        this.path = path;
        this.name = name;
        this.dateOfCreating = dateOfCreating;
    }

    public Archive() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(Timestamp dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
