package com.mohit.To_do.App.dao;

import com.mohit.To_do.App.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Tasks, Integer> {
}
