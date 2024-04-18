package com.example.diary_bmk.dto;

import com.example.diary_bmk.domain.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddDiaryRequest {

    private String title;
    private String content;
    private String date;

    public Diary toEntity(){
        return Diary.builder()
                .title(title)
                .content(content)
                .date(date)
                .build();
    }
}
