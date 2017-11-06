package com.isb.chile.factory;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProcessFactoryProducer {
    
    /** The application context. */
    @Autowired
    private ApplicationContext applicationContext;
    
	public ProcessAbstractFactory getProcessFactory(String factoryId){
		if(StringUtils.isEmpty(factoryId)){
			return null;
		}
		Map<String, ProcessAbstractFactory> map = applicationContext.getBeansOfType(ProcessAbstractFactory.class);
		Set<String> keset = map.keySet();
		
		for (String key : keset) {
			if(factoryId.equals(map.get(key).getFactoryId())){
				return map.get(key);
			}
		}
		return null;
		
	}
}
