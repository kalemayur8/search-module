package com.search.builder;

import java.util.List;

import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.search.constant.SearchDataConstant;

public class JsonPathQueryBuilder {

	
	/**
	 * As our current Database is JSON , I have used jsonpath to parse the json. instead or creating multiple pojos and iterating through it.
	 * If database changes we can use Spring data jpa, Hibernate etc.
	 * This is Native Queries used to parse Json , we can use, Jsonpath, Predicate, Criteria also to make it more descriptive
	 * @param queryMap - Query String parameters.
	 * @return String : formed query for search criteria.
	 */
	
	public static String buildCriteria(MultiValueMap<String, List<String>> queryMap) {
		int mapSize = queryMap.size();
		if (queryMap.size() > 0) {
			StringBuilder sb = new StringBuilder("$.[?(");
			String end = ")]";
			queryMap.forEach((k, v) -> {
				String str = "";
				if (SearchDataConstant.RELEASE_FIELDS.contains(k)) { // As we have static data that is why , I have used this Constant fields to nest, if data changes we can use Predicates
					str = "@.release.";
				} else if (SearchDataConstant.HARDWARE_FIELDS.contains(k)) {
					str = "@.hardware.";
				} else {
					str = "@.";
				}
				str = str + k + " == '" + (!StringUtils.isEmpty(v.get(0)) ? v.get(0) : "*") + "'";
				sb.append(str + (mapSize > 1 ? " && " : ""));
			});
			sb.append(end);
			return sb.toString().replace("&& )]", ")]");
		} else {
			return "[*]";
		}

	}
}
