package org.comeia.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.comeia.project.search.SearchCriteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=false)
public @Data class DocumentFilterDTO implements Serializable {

	private String fullName;
	private String type;
	private String directory;
	
	public static List<SearchCriteria> buildCriteria(DocumentFilterDTO filter) {
		List<SearchCriteria> criterias = new ArrayList<>();
		
		if(filter.getFullName() != null && !filter.getFullName().isEmpty()) { 
			criterias.add(new SearchCriteria("fullName", "%".concat(filter.getFullName()).concat("%")));
		}
		
		if(filter.getType() != null && !filter.getType().isEmpty()) { 
			criterias.add(new SearchCriteria("type", filter.getType()));
		}
		
		if(filter.getDirectory() != null && !filter.getDirectory().isEmpty()) {
			criterias.add(new SearchCriteria("directory", "%".concat(filter.getDirectory()).concat("%")));
		}
		
		return criterias;
	}
}
