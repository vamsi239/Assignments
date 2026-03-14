package com.lpu.mobile.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.mobile.DTO.MobileDTO;
import com.lpu.mobile.Entity.Mobile;
import com.lpu.mobile.Repository.MobileRepository;
import com.lpu.mobile.exception.ResourceNotFoundException;

@Service
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;

    public MobileServiceImpl(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    @CacheEvict(value = "mobiles", allEntries = true)
    public MobileDTO saveMobile(MobileDTO mobileDTO) {

        Mobile mobile = new Mobile();
        BeanUtils.copyProperties(mobileDTO, mobile);

        Mobile saved = mobileRepository.save(mobile);

        MobileDTO response = new MobileDTO();
        BeanUtils.copyProperties(saved, response);

        return response;
    }

    @Override
    @Cacheable("mobiles")
    public List<MobileDTO> getAllMobiles() {

        return mobileRepository.findAll()
                .stream()
                .map(mobile -> {
                    MobileDTO dto = new MobileDTO();
                    BeanUtils.copyProperties(mobile, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public MobileDTO getMobileById(int id) {

        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mobile not found with id: " + id));

        MobileDTO dto = new MobileDTO();
        BeanUtils.copyProperties(mobile, dto);

        return dto;
    }

    @Override
    @CacheEvict(value = "mobiles", allEntries = true)
    public MobileDTO updateMobile(int id, MobileDTO mobileDTO) {

        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mobile not found with id: " + id));

        BeanUtils.copyProperties(mobileDTO, mobile);

        Mobile updated = mobileRepository.save(mobile);

        MobileDTO dto = new MobileDTO();
        BeanUtils.copyProperties(updated, dto);

        return dto;
    }

    @Override
    @CacheEvict(value = "mobiles", allEntries = true)
    public void deleteMobile(int id) {

        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mobile not found with id: " + id));

        mobileRepository.delete(mobile);
    }

    @Override
    public void uploadMobilePhoto(int id, MultipartFile file) throws IOException {

        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mobile not found with id: " + id));

        mobile.setPhotoName(file.getOriginalFilename());
        mobile.setPhotoType(file.getContentType());
        mobile.setPhotoData(file.getBytes());

        mobileRepository.save(mobile);
    }
    
    @Override
    public List<MobileDTO> mobilePagination(int pageNumber, int size) {

        Pageable pageable = PageRequest.of(pageNumber, size);

        return mobileRepository.findAll(pageable)
                .stream()
                .map(mobile -> {
                    MobileDTO dto = new MobileDTO();
                    BeanUtils.copyProperties(mobile, dto);
                    return dto;
                })
                .toList();
    }
    
    @Override
    public List<MobileDTO> sortMobilePage(int pageNumber, int size, String field) {

        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(field).descending());

        return mobileRepository.findAll(pageable)
                .stream()
                .map(mobile -> {
                    MobileDTO dto = new MobileDTO();
                    BeanUtils.copyProperties(mobile, dto);
                    return dto;
                })
                .toList();
    }
    
    @Override
    public List<MobileDTO> sortMobileByFieldDesc(String field) {

        return mobileRepository.findAll(Sort.by(field).descending())
                .stream()
                .map(mobile -> {
                    MobileDTO dto = new MobileDTO();
                    BeanUtils.copyProperties(mobile, dto);
                    return dto;
                })
                .toList();
    }
    
    @Override
    public List<MobileDTO> sortMobileByFieldAsc(String field) {

        return mobileRepository.findAll(Sort.by(field).ascending())
                .stream()
                .map(mobile -> {
                    MobileDTO dto = new MobileDTO();
                    BeanUtils.copyProperties(mobile, dto);
                    return dto;
                })
                .toList();
    }
}