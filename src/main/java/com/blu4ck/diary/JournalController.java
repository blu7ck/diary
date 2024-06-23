package com.blu4ck.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping("/journals")
    public String getAllJournals(Model model) {
        model.addAttribute("journals", journalService.getAllEntries());
        return "journals";
    }

    @GetMapping("/journals/new")
    public String newJournalForm(Model model) {
        model.addAttribute("journal", new JournalEntry());
        return "new-journal";
    }

    @PostMapping("/journals")
    public String addJournal(@ModelAttribute JournalEntry journalEntry) {
        journalService.addEntry(journalEntry);
        return "redirect:/journals";
    }
}
