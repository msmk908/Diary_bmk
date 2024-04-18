package com.example.diary_bmk.service;

import com.example.diary_bmk.domain.Diary;
import com.example.diary_bmk.dto.AddDiaryRequest;
import com.example.diary_bmk.dto.UpdateDiaryRequest;
import com.example.diary_bmk.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public Diary save(AddDiaryRequest request){
        return diaryRepository.save(request.toEntity());
    }

    public List<Diary> findAll(){
        return diaryRepository.findAll();
    }

    public Diary findById(Long id){
        return diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        diaryRepository.deleteById(id);
    }

    @Transactional
    public Diary update(long id, UpdateDiaryRequest request){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        diary.update(request.getTitle(), request.getContent());

        return diary;
    }

}
