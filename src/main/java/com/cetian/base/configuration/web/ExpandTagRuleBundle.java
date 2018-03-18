package com.cetian.base.configuration.web;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * 
 * @ClassName:  ExpandTagRuleBundle   
 * @Description: 配置sitemesh实现自定义标签
 * @date:  2018年3月13日 下午3:52:33
 * @author: zangrong
 *
 */
public class ExpandTagRuleBundle implements TagRuleBundle {
	  @Override
	  public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
	      defaultState.addRule("myscript", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("myscript"), false));
	  }

	  @Override
	  public void cleanUp(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {

	  }
}
