package com.sisterslab.moviefriend.filmMovieConstants;

public enum MovieFriendConstant {
    NAMEUPDATED("Name Updated!"),
    UPDATED(" -> UPDATED"),
    EXPLANATIONUPDATED("Explanation Updated! "),
    SCOREUPDATED( "Score Updated! "),
    DELETED(" -> DELETED"),
    NOTDELETED("Not Deleted !"),
    ALREADYEXIST(" -> ALREADY EXIST "),
    ADDED(" -> ADDED "),
    C("c"),
    O("o"),
    QUOTES(" "),
    OR(" OR "),
    ARROW(" -> "),
    YYYYMMDD("yyyy-MM-dd"),
    NOTUPDATED("Not Updated !"),
    NOTFOUND(" -> NOT FOUND "),
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
