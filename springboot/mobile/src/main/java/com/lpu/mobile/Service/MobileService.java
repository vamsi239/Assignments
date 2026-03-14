package com.lpu.mobile.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lpu.mobile.DTO.MobileDTO;

public interface MobileService {

    MobileDTO saveMobile(MobileDTO mobileDTO);

    List<MobileDTO> getAllMobiles();

    MobileDTO getMobileById(int id);

    MobileDTO updateMobile(int id, MobileDTO mobileDTO);

    void deleteMobile(int id);

    
    void uploadMobilePhoto(int id, MultipartFile file) throws IOException;
    
    // Pagination
    List<MobileDTO> mobilePagination(int pageNumber, int size);

    // Pagination + Sorting
    List<MobileDTO> sortMobilePage(int pageNumber, int size, String field);

    // Sorting DESC
    List<MobileDTO> sortMobileByFieldDesc(String field);

    // Sorting ASC
    List<MobileDTO> sortMobileByFieldAsc(String field);
}