package com.ctbav.internship.cineplexbackend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
	Optional<UserType> findByTypeName(String typeName);

}
