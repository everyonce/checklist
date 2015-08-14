package demoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demoapp.domain.ChecklistItem;

public interface ChecklistItemRepository extends CrudRepository<ChecklistItem, Integer> {
	List<ChecklistItem> findAll();
	List<ChecklistItem> findByChecklistId(Integer id);
}
