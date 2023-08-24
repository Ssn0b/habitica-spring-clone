package com.snob.habiticaspringclone.model.dto;

import com.snob.habiticaspringclone.model.entity.Difficulty;
import com.snob.habiticaspringclone.model.entity.ResetCounter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HabitDTO {
    private String id;
    private String taskTitle;
    private String notes;
    private boolean positive;
    private boolean negative;
    private Difficulty difficulty;
    private ResetCounter reCounter;
}
