package org.quangphan.spring.security.repository;

import org.quangphan.spring.security.domain.NewUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository("newUserRepository")
public class NewUserRepositoryImpl implements NewUserRepository {
    private PasswordEncoder passwordEncoder;

    public NewUserRepositoryImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public NewUser findUser(String username, String domain) {
        if (username == null || domain == null) {
            return null;
        } else {
            Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
            NewUser user = new NewUser(username, domain,
                    passwordEncoder.encode("secret"), true,
                    true, true, true, authorities);
            return user;
        }
    }
}
