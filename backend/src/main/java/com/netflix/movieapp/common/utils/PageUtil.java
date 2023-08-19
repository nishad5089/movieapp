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
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class PageUtil {
	
	public  <T, R> PagedResponse<R> paginate(Page<T> data, Function<T, R> mapper) {
		List<R> content = data.stream()
		                      .map(mapper)
		                      .collect(Collectors.toList());
		
		return PagedResponse.<R>builder()
		                    .content(content)
		                    .page(data.getNumber() + 1)
		                    .size(data.getSize())
		                    .totalPages(data.getTotalPages())
		                    .totalItems(data.getTotalElements())
		                    .build();
	}
	
	/**
	 * Create a sort object from the query string
	 *
	 * @param sortsQuery the query string
	 *
	 * @return the sort object
	 */
	public  Sort getSort(String[] sortsQuery) {
		// MOVIE validate the sort query based on the entity fields
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
