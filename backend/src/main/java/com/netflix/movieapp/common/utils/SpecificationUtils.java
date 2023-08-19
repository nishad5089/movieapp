package com.netflix.movieapp.common.utils;


import lombok.experimental.UtilityClass;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.lowerCase;

@UtilityClass
public final class SpecificationUtils {

	public static final String WILDCARD = "%";

	public String wildcards(String str) {
		return join(WILDCARD, str, WILDCARD);
	}

	public String wildcardEnd(String str) {
		return join(str, WILDCARD);
	}

	public String wildcardsAndLower(String str) {
		return wildcards(lowerCase(str));
	}

	public String wildcardEndAndLower(String str) {
		return wildcardEnd(lowerCase(str));
	}
	
}

