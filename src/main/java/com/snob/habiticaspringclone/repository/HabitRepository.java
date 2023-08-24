package com.snob.habiticaspringclone.repository;

import com.snob.habiticaspringclone.model.entity.Habit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabitRepository extends MongoRepository<Habit, String> {
}
