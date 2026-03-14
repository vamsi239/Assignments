package com.lpu.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}