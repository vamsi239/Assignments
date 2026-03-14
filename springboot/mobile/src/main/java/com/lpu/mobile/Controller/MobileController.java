package com.lpu.mobile.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.mobile.DTO.MobileDTO;
import com.lpu.mobile.Entity.Mobile;
import com.lpu.mobile.Repository.MobileRepository;
import com.lpu.mobile.Service.MobileService;

import jakarta.validation.Valid;	

import com.lpu.mobile.Entity.*;

@RestController
@RequestMapping("/api/mobiles1")
public class MobileController {

    private final MobileService mobileService;
    private final MobileRepository mobileRepository;

    public MobileController(MobileService mobileService,
                            MobileRepository mobileRepository) {
        this.mobileService = mobileService;
        this.mobileRepository = mobileRepository;
    }

    @PostMapping
    public ResponseEntity<MobileDTO> createMobile(@Valid @RequestBody MobileDTO mobileDTO) {
        return ResponseEntity.ok(mobileService.saveMobile(mobileDTO));
    }

    @GetMapping
    public ResponseEntity<List<MobileDTO>> getAllMobiles() {
        return ResponseEntity.ok(mobileService.getAllMobiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MobileDTO> getMobileById(@PathVariable int id) {
        return ResponseEntity.ok(mobileService.getMobileById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MobileDTO> updateMobile(@PathVariable int id,
                                                  @Valid @RequestBody MobileDTO mobileDTO) {
        return ResponseEntity.ok(mobileService.updateMobile(id, mobileDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMobile(@PathVariable int id) {
        mobileService.deleteMobile(id);
        return ResponseEntity.ok("Mobile deleted successfully");
    }

    @PostMapping("/{id}/photo")
    public String uploadMobilePhoto(@PathVariable int id,
                                    @RequestParam("file") MultipartFile file) throws IOException {

        mobileService.uploadMobilePhoto(id, file);

        return "Photo uploaded for mobile id " + id;
    }
    
    @GetMapping("/{id}/photo")
    public ResponseEntity<byte[]> getMobilePhoto(@PathVariable int id) {

        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mobile not found"));

        return ResponseEntity.ok()
                .header("Content-Type", mobile.getPhotoType())
                .header("Content-Disposition",
                        "inline; filename=\"" + mobile.getPhotoName() + "\"")
                .body(mobile.getPhotoData());
    }
    
    @GetMapping("/page")
    public ResponseEntity<List<MobileDTO>> getMobilesPagination(
            @RequestParam int pageNumber,
            @RequestParam int size) {

        return ResponseEntity.ok(mobileService.mobilePagination(pageNumber, size));
    }
    
    @GetMapping("/pageSort/{pageNumber}/{size}/{field}")
    public ResponseEntity<List<MobileDTO>> getMobilesPaginationSort(
            @PathVariable int pageNumber,
            @PathVariable int size,
            @PathVariable String field) {

        return ResponseEntity.ok(
                mobileService.sortMobilePage(pageNumber, size, field));
    }
    
    @GetMapping("/sort/desc/{field}")
    public ResponseEntity<List<MobileDTO>> sortMobilesDesc(@PathVariable String field) {
        return ResponseEntity.ok(mobileService.sortMobileByFieldDesc(field));
    }
    
    @GetMapping("/sort/asc/{field}")
    public ResponseEntity<List<MobileDTO>> sortMobilesAsc(@PathVariable String field) {
        return ResponseEntity.ok(mobileService.sortMobileByFieldAsc(field));
    }
}