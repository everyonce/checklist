package demoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demoapp.domain.Checklist;
import demoapp.repository.ChecklistRepository;

@Service
@Transactional
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	private ChecklistRepository checklistRepository;
	
	@Override
	public boolean deleteChecklist(int id) {
		if(checklistRepository.exists(id)){
			checklistRepository.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public void saveChecklist(Checklist model) {
		
		checklistRepository.save(model);
	}

	@Override
	public Checklist getChecklistById(int id) {
		if(checklistRepository.exists(id)){
			return checklistRepository.findOne(id);
		}
		return new Checklist();
	}

	@Override
	public List<Checklist> getAllChecklists() {
		return checklistRepository.findAll();
	}

	public void setChecklistRepository(ChecklistRepository checklistRepository) {
		this.checklistRepository = checklistRepository;
	}

	
}
