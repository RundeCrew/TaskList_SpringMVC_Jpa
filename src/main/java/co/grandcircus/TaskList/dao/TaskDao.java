package co.grandcircus.TaskList.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.TaskList.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long>{

	List<Task> findAllByOrderByComplete();
}
