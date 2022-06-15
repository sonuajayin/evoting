package in.ajaykumarsingh.evoting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajaykumarsingh.evoting.models.Area;
import in.ajaykumarsingh.evoting.repositories.AreaRepository;

@Service
public class AreaService {
	
	@Autowired
	private AreaRepository areaRepository;
	
	public AreaService(AreaRepository areaRepository) {
		this.areaRepository=areaRepository;
	}

//	private List<Area> getAreas(){
//		throw new UnsupportedOperationException();
//	}
	
	public void saveArea(Area area) {		
		areaRepository.findById(null);
	}
}
