package cn.zgys.wifi.util;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
/**
 * Redis工具类，用于短信验证
 * @author hukun
 *
 */
@Component
public class RedisDao {
	
	@Resource
    private StringRedisTemplate stringRedisTemplate;
    
	/**
	 * 存储
	 * @param key
	 * @param value
	 */
    public  void setKey(String key,String value){
    	 if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {  
             return;  
         }  
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();  
        ops.set(key,value,180, TimeUnit.SECONDS);//180秒过期  
    }  
    
    /**
     * 根据key取出值
     * @param key
     * @return
     */
    public String getValue(String key){
    	if (StringUtils.isEmpty(key)) {  
              return null;  
        }  
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();  
        return ops.get(key);  
    }
    
    /**
     * 根据Key删除值
     * @param key
     */
    public void removeValue(String key){
    	stringRedisTemplate.delete(key);
    }


}
