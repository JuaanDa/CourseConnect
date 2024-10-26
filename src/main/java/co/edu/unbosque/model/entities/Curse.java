package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CURSES")
@NamedQueries(
        @NamedQuery(name = "Curse.findAll", query = "SELECT c FROM Curse c")
)
public class Curse {
    @Id
    private String id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "course_type")
    private String type;

    @Column(name = "modality")
    private String modality;

    @Column(name = "image_url")
    private String imageUrl;

    public Curse() {
    }

    public Curse(String id, String courseName, LocalDate startDate, String type, String modality, String imageUrl) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.type = type;
        this.modality = modality;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Curse{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", type='" + type + '\'' +
                ", modality='" + modality + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
