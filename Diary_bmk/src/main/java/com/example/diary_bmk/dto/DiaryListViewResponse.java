package com.example.diary_bmk.dto;

import com.example.diary_bmk.domain.Diary;
import lombok.Getter;

@Getter
public class DiaryListViewResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String date;

    public DiaryListViewResponse(Diary diary){
        this.id = diary.getId();
        this.title = diary.getTitle();
        this.content = diary.getContent();
        this.date = diary.getDate();
    }

}
