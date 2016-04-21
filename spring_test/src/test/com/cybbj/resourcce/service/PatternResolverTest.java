/**   
 * 类名：PatternResolverTest
 *
 */
package com.cybbj.resourcce.service;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/** 
 * PatternResolverTest: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-21 v1.0 15989 新建 
 */
public class PatternResolverTest {

	@Test
	public void resourcePatternResolver() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resourceArray = resolver.getResources("classpath:**/*.xml");
		for (Resource resource:resourceArray) {
			System.out.println(resource.getDescription());
		}
	}
}
