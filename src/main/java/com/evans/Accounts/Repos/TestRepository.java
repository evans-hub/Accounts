package com.evans.Accounts.Repos;

import com.evans.Accounts.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Country,Long> {
}
