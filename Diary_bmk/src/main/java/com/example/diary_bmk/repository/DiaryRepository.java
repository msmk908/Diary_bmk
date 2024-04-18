package com.example.diary_bmk.repository;

import com.example.diary_bmk.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
