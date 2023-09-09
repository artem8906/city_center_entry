package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.AdminEntity;
import com.example.city_center_entry.entity.UserEntity;
import com.example.city_center_entry.enums.AuthorityType;
import com.example.city_center_entry.repository.AdminRepository;
import com.example.city_center_entry.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@RequiredArgsConstructor
@SessionScope
public class SecurityContextService {

    private int id = 0;
    private AuthorityType authorisation = null;

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public void login(AuthorityType authorityType, String login, String password) throws Exception {
        if (authorityType == AuthorityType.USER) {
            UserEntity user = userRepository.getByLoginAndPassword(login, password);
            if (user == null) {
                throw new Exception("Zadané údaje sú nesprávne");
            }
            id = user.getId();
            authorisation = AuthorityType.USER;
        } else {
            AdminEntity admin = adminRepository.getByLoginAndPassword(login, password);
            if (admin == null) {
                throw new Exception("Zadané údaje sú nesprávne");
            }
            id = admin.getId();
            authorisation = AuthorityType.ADMIN;
        }

    }

    public boolean hasAuthority(AuthorityType authorityType) {
        if (authorisation == null) {
            return false;
        }
        if (authorisation.equals(authorityType)) {
            if (authorityType == AuthorityType.USER) {
                if (getUser(id) != null) {
                    return true;
                }
            } else {
                if (getAdmin(id) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public UserEntity getUser() {
        return userRepository.getUserById(id);
    }

    public AdminEntity getAdmin() {
        return adminRepository.getById(id);
    }

    private UserEntity getUser(int id) {
        return userRepository.getUserById(id);
    }

    private AdminEntity getAdmin(int id) {
        return adminRepository.getById(id);
    }

    public void logout() {
        this.id = 0;
        this.authorisation = null;
    }
}
