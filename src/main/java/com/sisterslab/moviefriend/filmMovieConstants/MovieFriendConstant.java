package com.sisterslab.moviefriend.filmMovieConstants;

public enum MovieFriendConstant {
    NAMEUPDATED("Name Updated!"),
    EXPLANATIONUPDATED("Explanation Updated! "),
    SCOREUPDATED( "Score Updated! "),
    DELETED(" -> DELETED"),
    QUOTES(" "),
    ALREADYEXIST(" -> ALREADY EXIST "),
    NOTFOUND(" -> NOT FOUND "),
    ADDED(" -> ADDED "),
    UPDATED(" -> UPDATED"),
    C("c"),
    OR(" OR "),
    ARROW(" -> "),
    YYYYMMDD("yyyy-MM-dd"),
    O("o"),
    NOTUPDATED("Not Updated!"),
    NOTDELETED("Not Deleted !"),
    USERNAMENOTCORRECT("User Name not correct"),
    GIVENINFORMATIONNOTMATCHED("Given information not matched");

    private final String name;
    MovieFriendConstant(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

}
