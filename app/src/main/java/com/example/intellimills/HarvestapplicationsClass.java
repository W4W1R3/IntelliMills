package com.example.intellimills;

public class HarvestapplicationsClass {

    String username,user_id,useremail,usersubcounty,usercounty,usersugarcaneage,userarea,userphone,trailers;

    public HarvestapplicationsClass() {
    }

    public HarvestapplicationsClass(String username, String user_id, String useremail, String usersubcounty, String usercounty, String usersugarcaneage, String userarea, String userphone, String trailers) {
        this.username = username;
        this.user_id = user_id;
        this.useremail = useremail;
        this.usersubcounty = usersubcounty;
        this.usercounty = usercounty;
        this.usersugarcaneage = usersugarcaneage;
        this.userarea = userarea;
        this.userphone = userphone;
        this.trailers = trailers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsersubcounty() {
        return usersubcounty;
    }

    public void setUsersubcounty(String usersubcounty) {
        this.usersubcounty = usersubcounty;
    }

    public String getUsercounty() {
        return usercounty;
    }

    public void setUsercounty(String usercounty) {
        this.usercounty = usercounty;
    }

    public String getUsersugarcaneage() {
        return usersugarcaneage;
    }

    public void setUsersugarcaneage(String usersugarcaneage) {
        this.usersugarcaneage = usersugarcaneage;
    }

    public String getUserarea() {
        return userarea;
    }

    public void setUserarea(String userarea) {
        this.userarea = userarea;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getTrailers() {
        return trailers;
    }

    public void setTrailers(String trailers) {
        this.trailers = trailers;
    }
}
