package com.netflix.movieapp.common.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@SuperBuilder(builderMethodName = "apiResponseBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude (JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends BaseResponse {

	private T data;
}
