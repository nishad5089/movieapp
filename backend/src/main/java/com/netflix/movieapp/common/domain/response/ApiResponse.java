package com.netflix.movieapp.common.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder(builderMethodName = "apiResponseBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude (JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends BaseResponse {

	private T data;
}
