package com.blue.mediuser.admin.domain.repository;

import com.blue.mediuser.admin.domain.entity.AdminGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGroupRepository extends JpaRepository<AdminGroup, Long> {
}
