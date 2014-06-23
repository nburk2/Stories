package wwyg

import grails.plugins.springsecurity.Secured
import org.springframework.security.core.authority.GrantedAuthorityImpl
import wwyg.authentication.User
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
//@Secured(["ROLE_ADMIN"])
class UserStoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def categoryService
    def springSecurityService
    def userActivitiesService

    def index(Integer max) {

        //println g.link(action:"index", absolute:true)
        params.max = Math.min(max ?: 5, 100)
        respond UserStory.list(params), model:[userStoryInstanceCount: UserStory.count()]
    }

    def home(){

        render view:'home'
    }

    @Secured(['ROLE_USER', 'ROLE_ADMIN'])
    def login(){
        redirect action:'index'
    }

    def details(UserStory userStoryInstance){
        println params
        respond userStoryInstance
    }

    def show(UserStory userStoryInstance) {
        render view: 'show', model:[userStoryInstance: userStoryInstance, category:categoryService.category]
    }

    def create() {
        println springSecurityService.currentUser.stories
        render view: 'create', model:[userStoryInstance: new UserStory(params), category:categoryService.category]
    }

    @Transactional
    def save(UserStory userStoryInstance) {
        if (userStoryInstance == null) {
            notFound()
            return
        }
        userStoryInstance.user = (springSecurityService.currentUser as User)

        if (!userStoryInstance.save(flush:true)) {
            respond userStoryInstance.errors, view:'create'
            return
        }

        userActivitiesService.addStory(userStoryInstance, springSecurityService.currentUser as User)
        try {
            categoryService.tagStory(userStoryInstance.id, params.category)
        }catch(Exception){println "could not tag the item created"}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userStory.label', default: 'UserStory'), userStoryInstance.id])
                //redirect action: "show", model:[userStoryInstance: userStoryInstance]
                render view: 'details', model:[userStoryInstance: userStoryInstance, category:categoryService.category]
            }
            '*' { respond userStoryInstance, [status: CREATED] }
        }
    }

    def edit(UserStory userStoryInstance) {
        if(params.id as int == springSecurityService.currentUser.id) {
            render view: 'edit', model: [userStoryInstance: userStoryInstance, category: categoryService.category]
        }else{
            render status: 500
        }
    }

    @Transactional
    def update(UserStory userStoryInstance) {
        if (userStoryInstance == null) {
            notFound()
            return
        }

        if (userStoryInstance.hasErrors()) {
            respond userStoryInstance.errors, view:'edit'
            return
        }

        userStoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserStory.label', default: 'UserStory'), userStoryInstance.id])
                render view: 'details', model:[userStoryInstance: userStoryInstance, category:categoryService.category]
            }
            '*'{ respond userStoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserStory userStoryInstance) {

        if(params.id as int == springSecurityService.currentUser.id) {
            if (params.userStoryId == null) {
                notFound()
                return
            }

            def story = UserStory.get(params.userStoryId as int)
            story.delete flush:true

            }else{
                render status: 500
        }

        if(springSecurityService.getPrincipal().getAuthorities().contains(["ROLE_ADMIN"] as GrantedAuthorityImpl)){
            println "should go to details"
            redirect controller: 'user', action:'adminDetails', params:[max:5 as Integer]
        }else {
            redirect controller: 'user', action:'adminDetails', params:[max:5 as Integer]
        }

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userStory.label', default: 'UserStory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
