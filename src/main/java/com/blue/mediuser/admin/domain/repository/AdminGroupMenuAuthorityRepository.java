package com.blue.mediuser.admin.domain.repository;

import com.blue.mediuser.admin.domain.entity.AdminGroupMenuAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGroupMenuAuthorityRepository extends JpaRepository<AdminGroupMenuAuthority, Long> {
}
