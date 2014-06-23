import wwyg.UserStory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WWyg_userStoryindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userStory/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'userStory.label', default: 'UserStory'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',16,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('sortableColumn','g',29,['property':("id"),'title':("Id")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',30,['property':("title"),'title':(message(code: 'userStory.title.label', default: 'Title'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',32,['property':("author"),'title':(message(code: 'userStory.author.label', default: 'Author'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',34,['property':("contactEmail"),'title':(message(code: 'userStory.contactEmail.label', default: 'Contact Email'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',36,['class':("hidden-xs hidden-sm"),'property':("story"),'title':(message(code: 'userStory.story.label', default: 'Story'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',38,['property':("dateCreated"),'title':(message(code: 'userStory.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',40,['property':("lastUpdated"),'title':(message(code: 'userStory.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( userStoryInstance in (userStoryInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(userStoryInstance.id)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: userStoryInstance, field: "title"))
})
invokeTag('link','g',49,['action':("details"),'id':(userStoryInstance.id)],3)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: userStoryInstance, field: "author"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: userStoryInstance, field: "contactEmail"))
printHtmlPart(16)
expressionOut.print(raw(userStoryInstance.story))
printHtmlPart(15)
invokeTag('formatDate','g',57,['date':(userStoryInstance.dateCreated)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',59,['date':(userStoryInstance.lastUpdated)],-1)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',67,['total':(userStoryInstanceCount ?: 0)],-1)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403269911000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
