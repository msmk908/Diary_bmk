package com.example.diary_bmk.controller;

import com.example.diary_bmk.domain.Diary;
import com.example.diary_bmk.dto.AddDiaryRequest;
import com.example.diary_bmk.dto.DiaryResponse;
import com.example.diary_bmk.dto.UpdateDiaryRequest;
import com.example.diary_bmk.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTp Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class DiaryApiController {

    private final DiaryService diaryService;

    @PostMapping("/api/diarys")
    public ResponseEntity<Diary> addDiary(@RequestBody AddDiaryRequest request){
        Diary saveDiary = diaryService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveDiary);
    }

    @GetMapping("/api/diarys")
    public ResponseEntity<List<DiaryResponse>> findAllDiarys(){
        List<DiaryResponse> diarys = diaryService.findAll()
                .stream()
                .map(DiaryResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(diarys);
    }

    @GetMapping("/api/diarys/{id}")
    public ResponseEntity<DiaryResponse> findDiary(@PathVariable long id){
        Diary diary = diaryService.findById(id);

        return ResponseEntity.ok()
                .body(new DiaryResponse(diary));
    }

    @DeleteMapping("/api/diarys/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable long id){
        diaryService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/diarys/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable long id, @RequestBody UpdateDiaryRequest request){
        Diary updatedDiary = diaryService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedDiary);
    }

}
