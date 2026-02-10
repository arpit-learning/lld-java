package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.TheatreStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;
    private TheatreStatus theatreStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public TheatreStatus getTheatreStatus() {
        return theatreStatus;
    }

    public void setTheatreStatus(TheatreStatus theatreStatus) {
        this.theatreStatus = theatreStatus;
    }
}
