package com.example.diary_bmk.dto;

import com.example.diary_bmk.domain.Diary;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DiaryViewResponse {

    private Long id;
    private String title;
    private String content;
    private String date;

    public DiaryViewResponse(Diary diary){
        this.id = diary.getId();
        this.title = diary.getTitle();
        this.content = diary.getContent();
        this.date = diary.getDate();
    }
}
