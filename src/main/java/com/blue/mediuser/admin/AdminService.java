package com.blue.mediuser.admin;

import com.blue.mediuser.admin.domain.dto.AdminMenuAuthorityDto;
import com.blue.mediuser.admin.domain.entity.AdminMenuAuthority;
import com.blue.mediuser.admin.domain.repository.AdminMenuAuthorityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminService {

    private final AdminMenuAuthorityRepository adminMenuAuthorityRepository;

    public AdminService(AdminMenuAuthorityRepository adminMenuAuthorityRepository) {
        this.adminMenuAuthorityRepository = adminMenuAuthorityRepository;
    }

    public void addAdminMenuAuthority(AdminMenuAuthorityDto adminMenuAuthorityDto) {
        adminMenuAuthorityRepository.save(adminMenuAuthorityDto.insertEntity());
    }

    public List<AdminMenuAuthority> getAdminMenuAuthorityList() {
        List<AdminMenuAuthority> adminMenuAuthorityList = adminMenuAuthorityRepository.findAll();
        return adminMenuAuthorityList;
    }

    public AdminMenuAuthority getAdminMenuAuthority(Long seq) {
        AdminMenuAuthority adminMenuAuthority = adminMenuAuthorityRepository.findById(seq).orElseThrow(() -> new RuntimeException("getAdminMenuAuthority select null!!"));
        return adminMenuAuthority;
    }

}
