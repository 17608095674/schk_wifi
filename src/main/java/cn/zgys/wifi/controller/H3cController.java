package cn.zgys.wifi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.entity.Staff;
import cn.zgys.wifi.util.H3cUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/h3c")
@Slf4j
public class H3cController {
	
	//数据展示
	@RequestMapping(value="/online")
	public Map<String,String> online() {
		
		//在线人数
		String online = H3cUtil.online();
		//访客人数
		//pc人数
		String pcOnline = Integer.parseInt(H3cUtil.windowsTerminal())+Integer.parseInt(H3cUtil.macTerminal())+"";
		//移动设备		
		String mobileOnline = Integer.parseInt(H3cUtil.androidTerminal())+Integer.parseInt(H3cUtil.iOSTerminal())+"";
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", online);
		map.put("2", "123");
		map.put("3", pcOnline);
		map.put("4", mobileOnline);
//		map.put("1", "2");
//		map.put("2", "123");
//		map.put("3", "3");
//		map.put("4", "5");
		return map;
	}
	
	//最近7天在线用户数
		@RequestMapping(value="/last")
		public Map<Integer,String> last() {
//			Map<Integer,String> map = new HashMap<Integer,String>();
//			map.put(1, "24");
//			map.put(2, "24");
//			map.put(3, "24");
//			map.put(4, "24");
//			map.put(5, "24");
//			map.put(6, "24");
//			map.put(7, "24");
//			return map;
			return	H3cUtil.lastTerminal();
		}
	
	
	
		
		
	

}
