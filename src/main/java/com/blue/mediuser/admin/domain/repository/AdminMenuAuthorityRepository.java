package com.blue.mediuser.admin.domain.repository;

import com.blue.mediuser.admin.domain.entity.AdminMenuAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMenuAuthorityRepository extends JpaRepository<AdminMenuAuthority, Long> {
}
