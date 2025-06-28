package com.keeper.keeperapp.store.repository;

import com.keeper.keeperapp.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByEmail(String email);
}
