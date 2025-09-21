package day5;

import java.util.List;

public class AnimalService {
	
	private AnimalDAO dao;
	AnimalService(AnimalDAO dao) {
		super();
		this.dao = dao;
	
	}
	
	public void addAnimal(String id, String name, String animalname, int age, int number) {
		AnimalDTO dto = new AnimalDTO(id, name, animalname, age, number);
		dao.save(dto);
	}
	
	public List<AnimalDTO> getAllAnimal(){
		return dao.findAll();
		
	}

}
