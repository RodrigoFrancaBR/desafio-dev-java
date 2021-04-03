package br.com.franca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
