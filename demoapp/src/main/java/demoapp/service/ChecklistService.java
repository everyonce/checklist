package demoapp.service;

import java.util.List;

import demoapp.domain.Checklist;

public interface ChecklistService {
	public boolean deleteChecklist(int id);
	public void saveChecklist(Checklist model);
	public Checklist getChecklistById(int id);
	public List<Checklist> getAllChecklists();
}
