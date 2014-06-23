package wwyg

import grails.transaction.Transactional
import org.springframework.security.core.authority.GrantedAuthorityImpl
import wwyg.authentication.User
import wwyg.authentication.UserRole

import static org.springframework.http.HttpStatus.NO_CONTENT

class UserController {

    def userActivitiesService
    def springSecurityService

    def index() {
        userActivitiesService.createAccount(params.fName,params.lName,params.username,params.email,params.password1)
        forward controller:'userStory', action:'index'
    }

    def login(){
        render view:'login'
    }

    def logout(){
        render view:'logout'
    }
    def accountDetails(Integer max){
        params.max = Math.min(max ?: 5, 100)
        println User.list()
        Collection<UserStory> userStoryInstanceList = userActivitiesService.getUserStories(UserStory.list(), springSecurityService.currentUser as User)
        render view:'accountDetails', model:[userStoryInstanceCount: userStoryInstanceList.size(), userStoryInstanceList: userStoryInstanceList]
    }

    def adminDetails(Integer max){
        params.max = Math.min(max ?: 5, 100)
        Collection<UserStory> userStoryInstanceList = userActivitiesService.getUserStories(UserStory.list(), springSecurityService.currentUser as User)
        println User.list()
        render view:'adminDetails', model:[userStoryInstanceCount: userStoryInstanceList.size(), userStoryInstanceList: userStoryInstanceList, userInstanceList: User.list()]
    }

    def createAccount(){
        render view:'createAccount'
    }

    @Transactional
    def delete() {
        if(springSecurityService.getPrincipal().getAuthorities().contains(["ROLE_ADMIN"] as GrantedAuthorityImpl)) {
            UserRole.removeAll(User.get(params.id));
            userActivitiesService.deleteUser(params.id as Integer)
            redirect action:'adminDetails', params:[max:5 as Integer]
        }else{
            println "error"
            render status: 500
        }
    }
}
