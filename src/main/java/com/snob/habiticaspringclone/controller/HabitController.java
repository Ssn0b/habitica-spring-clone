package com.snob.habiticaspringclone.controller;

import com.snob.habiticaspringclone.model.dto.HabitDTO;
import com.snob.habiticaspringclone.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;
    @PostMapping
    public ResponseEntity<HabitDTO> createHabit(@RequestBody HabitDTO habitDTO){
        HabitDTO createdHabit = habitService.createHabit(habitDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHabit);
    }
    @PutMapping("/{habitId}")
    public ResponseEntity<HabitDTO> updateHabit(@PathVariable String habitId, @RequestBody HabitDTO habitDTO){
        HabitDTO updatedHabit = habitService.updateHabit(habitId, habitDTO);
        return ResponseEntity.ok(updatedHabit);
    }
    @GetMapping
    public ResponseEntity<List<HabitDTO>> getAllHabits() {
        List<HabitDTO> allHabits = habitService.getAllHabits();
        return ResponseEntity.ok(allHabits);
    }
    @DeleteMapping("/{habitId}")
    public ResponseEntity<Void> deleteHabit(@PathVariable String habitId){
        habitService.deleteHabit(habitId);
        return ResponseEntity.noContent().build();
    }
}
