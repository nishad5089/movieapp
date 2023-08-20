package com.netflix.movieapp.common.utils;


import com.netflix.movieapp.common.domain.request.PaginationRequest;
import com.netflix.movieapp.common.domain.response.PagedResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@UtilityClass
public class PageUtil {
	
	public <T> PagedResponse<T> paginate(Page<T> data) {

		return PagedResponse.<T>builder()
		                    .content(data.getContent())
		                    .page(data.getNumber() + 1)
		                    .size(data.getSize())
		                    .totalPages(data.getTotalPages())
		                    .totalItems(data.getTotalElements())
		                    .build();
	}

	public Sort getSort(String[] sortsQuery) {

		if (sortsQuery == null || sortsQuery.length == 0) {
			return Sort.unsorted();
		}
		
		List<Order> orders = Stream.of(sortsQuery)
		                           .map(query -> query.split(","))
		                           .filter(query -> query.length == 2)
		                           .map(order -> Order.by(order[0].trim())
		                                              .with(Sort.Direction.fromString(order[1].trim())))
		                           .collect(Collectors.toList());
		return Sort.by(orders);
	}

	public Pageable getPageable(PaginationRequest request) {
		Sort sort = getSort(request.getSorts());
		return PageRequest.of(request.getPage() - 1, request.getSize(), sort);
	}
	
}
