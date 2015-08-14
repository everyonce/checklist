package demoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demoapp.domain.ChecklistItem;
import demoapp.repository.ChecklistItemRepository;

@Service
@Transactional
public class ChecklistItemServiceImpl implements ChecklistItemService {

	@Autowired
	private ChecklistItemRepository checklistItemRepository;
	
	@Override
	public boolean deleteChecklist(int id) {
		if(checklistItemRepository.exists(id)){
			checklistItemRepository.delete(id);
			
			return true;
		}
		
		return false;
	}

	@Override
	public void saveChecklist(ChecklistItem model) {
		checklistItemRepository.save(model);
	}

	@Override
	public ChecklistItem getChecklistItemById(int id) {
		if(checklistItemRepository.exists(id)){
			return checklistItemRepository.findOne(id);
		}
		return new ChecklistItem();
	}

	@Override
	public List<ChecklistItem> getAllChecklistItems() {
		return checklistItemRepository.findAll();
	}

	@Override
	public List<ChecklistItem> getChecklistItemsForChecklist(int id) {
		return checklistItemRepository.findByChecklistId(id);
	}

	public void setChecklistItemRepository(ChecklistItemRepository checklistItemRepository) {
		this.checklistItemRepository = checklistItemRepository;
	}
	
	

}
