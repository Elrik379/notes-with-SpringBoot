package ed.ys.notes.controller;

import ed.ys.notes.model.Note;
import ed.ys.notes.service.NoteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteRestController {

    private final NoteService noteService;

    public NoteRestController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public List<Note> getNoteList() {
        return noteService.getList();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Integer id) {
        for(Note note: noteService.getList()){
            if(note.getId().equals(id)){
                return Optional.of(note);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/")
    Note postNote(@RequestBody Note note){
        noteService.addNoteInList(note);
        return note;
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id){
        noteService.deleteNote(id);
    }

}
