import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WWyg_useraccountDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/accountDetails.gsp" }
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
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',11,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (userStoryInstanceCount > 0)) {
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('sortableColumn','g',32,['property':("id"),'title':("Id")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',35,['property':("title"),'title':(message(code: 'userStory.title.label', default: 'Title'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',37,['property':("title"),'title':("Edit")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',41,['property':("dateCreated"),'title':(message(code: 'userStory.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',43,['property':("lastUpdated"),'title':(message(code: 'userStory.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( userStoryInstance in (userStoryInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
expressionOut.print(userStoryInstance.id)
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: userStoryInstance, field: "title"))
})
invokeTag('link','g',51,['controller':("userStory"),'action':("details"),'id':(userStoryInstance.id)],4)
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('link','g',55,['type':("post"),'controller':("userStory"),'action':("edit"),'id':(userStoryInstance.id),'class':("btn btn-md btn-success")],4)
printHtmlPart(18)
createClosureForHtmlPart(19, 4)
invokeTag('form','g',59,['role':("form"),'method':("delete"),'controller':("userStory"),'action':("delete"),'id':(userStoryInstance.id)],4)
printHtmlPart(20)
invokeTag('formatDate','g',60,['date':(userStoryInstance.dateCreated)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',61,['date':(userStoryInstance.lastUpdated)],-1)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',67,['total':(userStoryInstanceCount ?: 0)],-1)
printHtmlPart(24)
}
else {
printHtmlPart(25)
expressionOut.print(createLink(controller:'shareYourStory', action:'index'))
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403289447000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
