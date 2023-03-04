package ed.ys.notes.controller;

import ed.ys.notes.model.Note;
import ed.ys.notes.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String getAllNote(Model model){
        List<Note> notes = noteService.getList();
        model.addAttribute("notes", notes);
        return "/notes";
    }

    @PostMapping(path = "/notes")
    public String addNote(@RequestParam String noteText,
                          Model model) {
        Note note = new Note();
        LocalDate localDate = LocalDate.now();
        note.setNoteText(noteText);
        note.setDate(localDate);
        noteService.addNoteInList(note);
        List<Note> notes = noteService.getList();
        model.addAttribute("notes", notes);
        noteService.saveNoteList();
        return "/notes";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteNote(@PathVariable Integer id,
                             Model model) {
        noteService.deleteNote(id);
        List<Note> notes = noteService.getList();
        model.addAttribute("notes", notes);
        noteService.saveNoteList();
        return "redirect:/notes";
    }

}
