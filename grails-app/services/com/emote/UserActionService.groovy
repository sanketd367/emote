package com.emote

class UserActionService {
	
	NotificationService notificationService

    def addDoing(String userId, String title) {
        UserDoing userDoing = UserDoing.findByUserIdAndTitle(userId, title)
        if(userDoing){
            userDoing.count++
            userDoing.lastUpdated = new Date()
            userDoing.save()
        }
        else{
            new UserDoing(userId: userId, title: title, count:1).save()
        }
    }

    def addFavouriteTitle(User user, String title){
        def favorite = UserFavourite.findOrCreateByUserId(user.id)
        if(!favorite.favouriteTitles){
            favorite.favouriteTitles = new HashSet<String>()
        }
        favorite.favouriteTitles.add title
        favorite.save()
//		notificationService.registerInterest(title, user, TitleInterest.Type.FAVOURITE)
    }

    def removeFavouriteTopic(User user, String title) {
        def favorite = UserFavourite.findOrCreateByUserId(user.id)
        if(!favorite.favouriteTitles){
            favorite.favouriteTitles = new HashSet<String>()
        }
        favorite.favouriteTitles.remove title
        favorite.save()
    }
    def changePointToEmote(User user,String emoteId, UserEmotePoint.Point point){
        def pointOfUser = UserEmotePoint.findOrSaveByUserIdAndEmoteId(user.id, emoteId)
        pointOfUser.point = point
        pointOfUser.save()
    }

    def addTitleInToDoList(String title, User user) {
        if(!UserToDo.findByUserIdAndTitle(user.id, title)) {
            new UserToDo(userId: user.id, title: title).save()
        }
    }

    def removeFromToDoList(String title, User user) {
        UserToDo.findByUserIdAndTitle(user.id, title)?.delete()
    }
}