package com.example.diary_bmk.controller;

import com.example.diary_bmk.domain.Diary;
import com.example.diary_bmk.dto.DiaryListViewResponse;
import com.example.diary_bmk.dto.DiaryViewResponse;
import com.example.diary_bmk.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DiaryViewController {

    private final DiaryService diaryService;

    @GetMapping("/diarys")
    public String getDiarys(Model model){
        List<DiaryListViewResponse> diarys = diaryService.findAll().stream()
                .map(DiaryListViewResponse::new)
                .toList();
        model.addAttribute("Diary", diarys);

        return "Calendar";
    }

    @GetMapping("/diarys/{id}")
    public String getDiary(@PathVariable Long id, Model model){
        Diary diary = diaryService.findById(id);
        model.addAttribute("Diary", new DiaryViewResponse(diary));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id == null){
            model.addAttribute("Diary", new DiaryViewResponse());
        } else{
            Diary diary = diaryService.findById(id);
            model.addAttribute("Diary", new DiaryViewResponse(diary));
        }

        return "newArticle";
    }

}
