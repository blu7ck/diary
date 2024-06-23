package com.blu4ck.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntry> getAllEntries() {
        return journalRepository.findAll();
    }

    public JournalEntry addEntry(JournalEntry journalEntry) {
        return journalRepository.save(journalEntry);
    }
}
