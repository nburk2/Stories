package wwyg.authentication

import grails.transaction.Transactional
import wwyg.UserStory

@Transactional
class UserActivitiesService {


    def serviceMethod() {

    }

    def createAccount(String fName, String lName, String username, def email, String password) {

        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER').save(flush: true)

        println "fName: ${fName}, lName: ${lName}, username: ${username}, email: ${email}, password: ${password}"

        def user = User.findOrSaveWhere(username: username, password: password, fName: fName, lName: lName, email: email)
        user.save(flush: true)


        UserRole.create(user, userRole, true)


    }

    //associates a story with the current user logged in.
    def addStory(UserStory story, User newUser){
        newUser.addToStories(story)
    }

    def getUserStories(Collection<UserStory> stories, User currentUser){
        stories.findAll{it.user.id == currentUser.id}

    }

    def deleteUser(int id){
        println id
        User.get(id).delete flush:true
    }

}
