package com.passcontrol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.passcontrol.entity.Pass;
import com.passcontrol.entity.TypePass;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {

	Optional<List<Pass>> findByType(TypePass type);

	@Query(value = "SELECT * FROM passcontrol.pass WHERE is_active = TRUE ORDER BY type DESC, id LIMIT 5", nativeQuery = true)
	List<Pass> findByIsActive();

	@Query(value = "SELECT * FROM passcontrol.pass WHERE is_active = FALSE ORDER BY type, id DESC LIMIT 5", nativeQuery = true)
	List<Pass> findByNotActive();

	@Query(value = "SELECT * FROM passcontrol.pass WHERE is_active = TRUE ORDER BY type DESC, id  LIMIT 1", nativeQuery = true)
	Pass findNextPass();

	@Query(value = "SELECT * FROM passcontrol.pass WHERE type = :type_pass ORDER BY id DESC LIMIT 1;", nativeQuery = true)
	Pass findLastPass(@Param("type_pass") Character typePass);

}
