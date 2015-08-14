package demoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demoapp.domain.Checklist;

public interface ChecklistRepository extends CrudRepository<Checklist, Integer> {
	List<Checklist> findAll();
}
