package com.netflix.movieapp.common.domain.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequest {
	
	private int page;
	private int size;
	private String[] sorts;
}
