package ed.ys.notes.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@JsonAutoDetect
public class Note {

    private String noteText;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    private Integer id;
    private static Integer allId = 0;

    public Note() {
        allId += 1;
        id = allId * new Random().nextInt(9157);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
