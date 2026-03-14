package com.lpu.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.file.entity.FileData;



public interface FileRepository extends JpaRepository<FileData, Integer> {

}
