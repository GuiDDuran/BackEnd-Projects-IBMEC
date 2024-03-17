package br.com.ibmec.backend.taskmanager.repository;

import br.com.ibmec.backend.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
