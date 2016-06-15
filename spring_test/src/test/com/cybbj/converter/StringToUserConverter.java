/**   
 * 类名：StringToUserConverter
 *
 */
package com.cybbj.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/** 
 * StringToUserConverter: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-12 v1.0 15989 新建 
 */
public class StringToUserConverter implements Converter<String, User> {

	/** (非 Javadoc) 
	* @param arg0
	* @return 
	* @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object) 
	*/
	public User convert(String source) {
		User user = null;
		System.out.println(StringUtils.isNotEmpty(source) && StringUtils.contains(source, ":"));
		if (StringUtils.isNotEmpty(source) && StringUtils.contains(source, ":")) {
			String[] sourceArray = StringUtils.split(source, ":");
			
			user = new User();
			user.setUserName(sourceArray[0]);
			user.setUserPwd(sourceArray[1]);
			user.setName(sourceArray[2]);
		}
		return user;
	}

}
