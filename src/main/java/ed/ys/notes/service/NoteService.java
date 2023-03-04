package ed.ys.notes.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ed.ys.notes.model.Note;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


@Service
@JsonAutoDetect
public class NoteService {

    static {
        loadNoteList();
    }

    private static List<Note> noteList;

    public List<Note> getList() {
        return noteList;
    }

    public void addNoteInList(Note note) {
        noteList.add(note);
    }

    public void deleteNote(Integer id) {
        noteList.removeIf(note -> note.getId().equals(id));
    }

    public void saveNoteList() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"))) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, noteList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadNoteList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("save.txt"))) {
            String base = reader.readLine();
            if (base == null) {
                noteList = new ArrayList<>();
                return;
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); //регистрация модуля, чтобы избежать ошибки с сериализацей Date
            CollectionType type = TypeFactory.defaultInstance()
                    .constructCollectionType(ArrayList.class, Note.class);
            noteList = mapper.readValue(base, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

