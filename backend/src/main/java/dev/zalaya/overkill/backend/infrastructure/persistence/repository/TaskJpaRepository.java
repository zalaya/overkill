package dev.zalaya.overkill.backend.infrastructure.persistence.repository;

import dev.zalaya.overkill.backend.infrastructure.persistence.entity.TaskEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {

}
