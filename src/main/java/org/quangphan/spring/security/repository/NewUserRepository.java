package org.quangphan.spring.security.repository;

import org.quangphan.spring.security.domain.NewUser;

public interface NewUserRepository {

    NewUser findUser(String username, String domain);
}
