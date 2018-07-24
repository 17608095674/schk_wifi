//package cn.zgys.wifi.util;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class StringUtil {
//	
//	public static String[] stringSort(String [] s) {
//			List<String> list = new ArrayList<String>(s.length);
//			for (int i = 0; i < s.length; i++) {
//				list.add(s[i]);
//			}
//			Collections.sort(list);
//			return list.toArray(s);
//		}
//
//		public static void main(String[] args) {
//			String[] s = new String[]{"version1", "callNameDEPARTMENT", "requestTime1447236721", "orgNumber000040","name"+URLUtil.encode("张三")};
//			s = stringSort(s);
//			StringBuffer strBuffer = new StringBuffer();
//			for (int i = 0; i < s.length; i++) {
//				System.out.println(s[i]);
//				strBuffer.append(s[i]);
//			}
//			System.err.println(strBuffer.toString());
//			}
//
//	}
