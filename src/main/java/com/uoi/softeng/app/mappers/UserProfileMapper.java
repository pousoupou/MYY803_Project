package com.uoi.softeng.app.mappers;

import com.uoi.softeng.app.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileMapper extends JpaRepository<UserProfile, String> {

    UserProfile findByUsername(String username);

}
