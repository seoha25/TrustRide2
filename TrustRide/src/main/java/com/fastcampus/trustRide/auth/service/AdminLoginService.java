package com.fastcampus.trustRide.auth.service;


import com.fastcampus.trustRide.dao.admin.AdminDao;
import com.fastcampus.trustRide.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("adminDetailsService")
public class AdminLoginService implements UserDetailsService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminDto admin = adminDao.findByEmail(email);
        if (admin == null) {
            throw new UsernameNotFoundException("Admin not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(admin.getAdminEmail())
                .password(admin.getAdminPassword())
                .roles("ADMIN")
                .build();
    }
}
