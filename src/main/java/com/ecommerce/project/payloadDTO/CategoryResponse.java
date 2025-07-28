package com.ecommerce.project.payloadDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryResponse {

	private List<CategoryDTO> content;

	private Integer pageNumebr;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private Boolean lastPage;

	public Integer getPageNumebr() {
		return pageNumebr;
	}

	public void setPageNumebr(Integer pageNumebr) {
		this.pageNumebr = pageNumebr;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Boolean getLastPage() {
		return lastPage;
	}

	public void setLastPage(Boolean lastPage) {
		this.lastPage = lastPage;
	}

	public List<CategoryDTO> getContent() {
		return content;
	}

	public void setContent(List<CategoryDTO> categoryDTOS) {
		// TODO Auto-generated method stub
		this.content = categoryDTOS;
	}

}
