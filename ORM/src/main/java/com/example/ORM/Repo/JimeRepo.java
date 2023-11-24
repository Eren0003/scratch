package com.example.ORM.Repo;

import com.example.ORM.Entity.TicketTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface JimeRepo extends JpaRepository<TicketTable,Long> {
}
