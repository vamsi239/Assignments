package com.lpu.mobile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.mobile.Entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}