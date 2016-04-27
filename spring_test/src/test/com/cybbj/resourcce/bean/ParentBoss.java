/**   
 * 类名：ParentBoss
 *
 */
package com.cybbj.resourcce.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ParentBoss: TODO请填写类描述
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-4-25 v1.0 15989 新建
 */
public class ParentBoss {

	private List<String> favorite = new ArrayList<String>();

	private Set<String> jobSet = new HashSet<String>();

	public List<String> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<String> favorite) {
		this.favorite = favorite;
	}

	public Set<String> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<String> jobSet) {
		this.jobSet = jobSet;
	}

}
