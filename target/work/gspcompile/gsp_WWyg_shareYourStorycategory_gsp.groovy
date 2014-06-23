import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WWyg_shareYourStorycategory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/shareYourStory/category.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'userStory.label', default: 'UserStory'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',13,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
loop:{
int i = 0
for( category in (categoryList) ) {
printHtmlPart(6)
createTagBody(3, {->
expressionOut.print(category)
})
invokeTag('link','g',45,['controller':("shareYourStory"),'action':("stories"),'id':(category),'elementId':("${category}story")],3)
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
expressionOut.print(category)
printHtmlPart(9)
})
invokeTag('script','r',53,[:],3)
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',60,['controller':("UserStory"),'action':("create")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403012635000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}