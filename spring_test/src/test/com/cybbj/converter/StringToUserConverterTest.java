/**   
 * 类名：StringToUserConverterTest
 *
 */
package com.cybbj.converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * StringToUserConverterTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-6-12 v1.0 15989 新建 
 */
@Controller
@RequestMapping(value="/stringToUserConverterTest")
public class StringToUserConverterTest {
	
	@RequestMapping(value="convertTest")
	public String convertTest(@RequestParam("user") User user,ModelMap modelMap) {
		modelMap.put("user", user);
		return "/user/showUser";
	}
}
