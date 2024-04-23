package ru.back.anichu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.back.anichu.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
