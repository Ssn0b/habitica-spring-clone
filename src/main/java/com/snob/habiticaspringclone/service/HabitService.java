package com.snob.habiticaspringclone.service;

import com.snob.habiticaspringclone.exception.HabitNotFoundException;
import com.snob.habiticaspringclone.model.dto.HabitDTO;
import com.snob.habiticaspringclone.model.entity.Habit;
import com.snob.habiticaspringclone.repository.HabitRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitService {
    private final HabitRepository habitRepository;
    private final ModelMapper modelMapper;
    public HabitDTO createHabit(HabitDTO habitDTO){
        Habit habit = new Habit();
        habit.setTaskTitle(habitDTO.getTaskTitle());
        habit.setNotes(habitDTO.getNotes());
        habit.setPositive(habitDTO.isPositive());
        habit.setNegative(habitDTO.isNegative());
        habit.setDifficulty(habitDTO.getDifficulty());
        habit.setReCounter(habitDTO.getReCounter());

        Habit saveHabit = habitRepository.save(habit);

        return modelMapper.map(saveHabit,HabitDTO.class);
    }

    public HabitDTO updateHabit(String habitId, HabitDTO habitDTO){
        Optional<Habit> optionalHabit = habitRepository.findById(habitId);
        if (optionalHabit.isPresent()) {
            Habit existingHabit = optionalHabit.get();

            if (habitDTO.getTaskTitle() != null) {
                existingHabit.setTaskTitle(habitDTO.getTaskTitle());
            }
            if (habitDTO.getNotes() != null) {
                existingHabit.setNotes(habitDTO.getNotes());
            }
            if (habitDTO.isPositive() != existingHabit.isPositive()) {
                existingHabit.setPositive(habitDTO.isPositive());
            }
            if (habitDTO.isNegative() != existingHabit.isNegative()) {
                existingHabit.setNegative(habitDTO.isNegative());
            }
            if (habitDTO.getDifficulty() != null) {
                existingHabit.setDifficulty(habitDTO.getDifficulty());
            }
            if (habitDTO.getReCounter() != null) {
                existingHabit.setReCounter(habitDTO.getReCounter());
            }

            Habit updatedHabit = habitRepository.save(existingHabit);

            return modelMapper.map(updatedHabit,HabitDTO.class);
        }else {
            throw new HabitNotFoundException("Habit not found with id: " + habitId);
        }
    }

    public void deleteHabit(String habitId){
        Optional<Habit> optionalHabit = habitRepository.findById(habitId);
        if (optionalHabit.isPresent()) {
            habitRepository.deleteById(habitId);
        } else {
            throw new HabitNotFoundException("Habit not found with id: " + habitId);
        }
    }

    public List<HabitDTO> getAllHabits() {
        return habitRepository.findAll()
                .stream()
                .map(habit->modelMapper.map(habit,HabitDTO.class))
                .collect(Collectors.toList());
    }
}
