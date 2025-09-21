package day5;

import java.util.List;

public class CenterService {
	
	private CenterDAO dao;

	public CenterService(CenterDAO dao) {
		super();
		this.dao = dao;
	}
	
	public void addMember(String name, int number, int kcal1, int kcal2) {
		CenterDTO dto = new CenterDTO(name, number, kcal1, kcal2);
		dao.save(dto);
	}
	
	
	public List<CenterDTO> getAllMember(){
		return dao.findAll();
	}
	

}
