package com.example.demo10.controller;

import com.example.demo10.entity.Journal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalController {

   private Map<Long, Journal> journalMap = new HashMap<>();
    @GetMapping
    public List<Journal> getall(){
        return new ArrayList<>(journalMap.values());
    }

    @GetMapping("/{myId}")  //@@
    public Journal getJournalById(@PathVariable Long myId){
        return journalMap.get(myId);
    }

    @PostMapping//@@
    public boolean createJournal(@RequestBody Journal journal){
        journalMap.put(journal.getId(), journal);
                return true;
    }

    @PutMapping("/{myid}")
    public Journal updateJournal(@PathVariable Long myid, @RequestBody Journal journal){
        return journalMap.put(myid, journal);
    }
    @DeleteMapping("/{myid}")//@@
    public Journal deleteJournalById(@PathVariable Long myid){
        return journalMap.remove(myid);
    }
}

