package co.grandcircus.TaskList.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.TaskList.entity.User;
public interface UserDao extends JpaRepository<User, Long> {

	User findByName(String name);
	
	List<User> findAllByOrderByName();
	
	User findByEmail(String email);
}
