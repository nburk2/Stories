import wwyg.UserStory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WWyg_userStorydetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userStory/details.gsp" }
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
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(userStoryInstance?.title)
printHtmlPart(4)
if(true && (userStoryInstance?.story)) {
printHtmlPart(5)
expressionOut.print(raw(userStoryInstance.story))
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (userStoryInstance?.author)) {
printHtmlPart(8)
expressionOut.print(userStoryInstance.author)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (userStoryInstance?.contactEmail)) {
printHtmlPart(11)
invokeTag('fieldValue','g',61,['bean':(userStoryInstance),'field':("contactEmail")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userStoryInstance?.dateCreated)) {
printHtmlPart(14)
invokeTag('formatDate','g',78,['date':(userStoryInstance?.dateCreated)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (userStoryInstance?.lastUpdated)) {
printHtmlPart(17)
invokeTag('message','g',94,['code':("userStory.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',96,['date':(userStoryInstance?.lastUpdated)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403019010000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
