package com.snob.habiticaspringclone.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "habit")
public class Habit {
    @Id
    private String id;
    private String taskTitle;
    private String notes;
    private boolean positive;
    private boolean negative;
    private Difficulty difficulty;
    private ResetCounter reCounter;
}
