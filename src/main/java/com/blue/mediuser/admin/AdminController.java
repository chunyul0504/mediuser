package com.blue.mediuser.admin;

import com.blue.mediuser.admin.domain.dto.AdminMenuAuthorityDto;
import com.blue.mediuser.admin.domain.entity.AdminMenuAuthority;
import com.blue.mediuser.util.ApiListResponse;
import com.blue.mediuser.util.ApiResponse;
import com.blue.mediuser.util.TestSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/authority-menu")
    public ResponseEntity<ApiResponse> addAdminMenuAuthority(@RequestBody AdminMenuAuthorityDto adminMenuAuthorityDto) {
        log.info("======addAdminMenuAuthority========");
        adminMenuAuthorityDto.setCreatedId(TestSession.id);
        adminService.addAdminMenuAuthority(adminMenuAuthorityDto);
        return ResponseEntity.ok(ApiResponse.success());
    }

    @GetMapping("/authority-menu")
    public ResponseEntity<ApiResponse> getAdminMenuAuthorityList() {
        log.info("======getAdminMenuAuthority========");
        List<AdminMenuAuthority> adminMenuAuthorities = adminService.getAdminMenuAuthorityList();
        return ResponseEntity.ok(ApiResponse.success(new ApiListResponse(adminMenuAuthorities, adminMenuAuthorities.size())));
    }

    @GetMapping("/authority-menu/{seq}")
    public ResponseEntity<ApiResponse> getAdminMenuAuthority(@PathVariable Long seq) {
        log.info("======getAdminMenuAuthority========");
        return ResponseEntity.ok(ApiResponse.success(adminService.getAdminMenuAuthority(seq)));
    }

}
