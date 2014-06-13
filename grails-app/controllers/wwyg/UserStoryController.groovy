package wwyg

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserStoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def categoryService

    def index(Integer max) {
        //println g.link(action:"index", absolute:true)
        params.max = Math.min(max ?: 10, 100)
        respond UserStory.list(params), model:[userStoryInstanceCount: UserStory.count()]
    }

    def details(UserStory userStoryInstance){
        respond userStoryInstance
    }

    def show(UserStory userStoryInstance) {
        render view: 'show', model:[userStoryInstance: userStoryInstance, category:categoryService.category]
    }

    def create() {
        render view: 'create', model:[userStoryInstance: new UserStory(params), category:categoryService.category]
    }

    @Transactional
    def save(UserStory userStoryInstance) {
        if (userStoryInstance == null) {
            notFound()
            return
        }

        if (userStoryInstance.hasErrors()) {
            respond userStoryInstance.errors, view:'create'
            return
        }
        println params
        userStoryInstance.save flush:true
        try {
            categoryService.tagStory(userStoryInstance.id, params.category)
        }catch(Exception){println "could not tag the item created"}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userStory.label', default: 'UserStory'), userStoryInstance.id])
                //redirect action: "show", model:[userStoryInstance: userStoryInstance]
                render view: 'show', model:[userStoryInstance: userStoryInstance, category:categoryService.category]
            }
            '*' { respond userStoryInstance, [status: CREATED] }
        }
    }

    def edit(UserStory userStoryInstance) {
        render view: 'edit', model:[userStoryInstance: userStoryInstance, category:categoryService.category]
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
                redirect userStoryInstance
            }
            '*'{ respond userStoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserStory userStoryInstance) {

        if (userStoryInstance == null) {
            notFound()
            return
        }

        userStoryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserStory.label', default: 'UserStory'), userStoryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
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
