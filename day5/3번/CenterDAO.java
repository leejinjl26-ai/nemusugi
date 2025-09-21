package day5;

import java.util.ArrayList;
import java.util.List;

public class CenterDAO {
	
	private List<CenterDTO> centerList = new ArrayList<>();
	
	public void save (CenterDTO dto) {
		centerList.add(dto);
	}
	
	public List<CenterDTO> findAll(){
		return centerList;
	}

}
