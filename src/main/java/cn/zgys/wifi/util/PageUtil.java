//package cn.zgys.wifi.util;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//
//public class PageUtil {
//	
//	 public static PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType, String direction) {
//		    Sort sort = null;
//		 
//		    if (!StringUtils.isEmpty(sortType)) {
//		      return new PageRequest(pageNumber - 1, pageSize);
//		    } else if (!StringUtils.isEmpty(direction)) {
//		      if (Direction.ASC.equals(direction)) {
//		        sort = new Sort(Direction.ASC, sortType);
//		      } else {
//		        sort = new Sort(Direction.DESC, sortType);
//		      }
//		      return new PageRequest(pageNumber - 1, pageSize, sort);
//		    } else {
//		      sort = new Sort(Direction.ASC, sortType);
//		      return new PageRequest(pageNumber - 1, pageSize, sort);
//		    }
//		  }
//	 
//	 	public static PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {	 
//	 		return buildPageRequest(pageNumber, pageSize, sortType, null);
//	 	}
//
//}
