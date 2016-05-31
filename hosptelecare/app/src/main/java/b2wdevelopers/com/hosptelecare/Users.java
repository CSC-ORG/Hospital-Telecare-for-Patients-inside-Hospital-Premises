package b2wdevelopers.com.hosptelecare;

/**
 * Created by admin on 12/26/2015.
 */


public class Users {

  //  int _uid;
    String _uname;
    String _upass;

    // Empty constructor
    public Users(){

    }
    // constructor
    public Users(/*int id,*/String uname,String upass){
    //    this._uid= id;
        this._uname= uname;
        this._upass= upass;
    }


/*
    public int getUId(){
        return this._uid;
    }

    public void setUId(int id){
        this._uid = id;
    }*/


    public String getUName(){
        return this._uname;
    }

    public void setUName(String name){
        this._uname= name;
    }

    public String getUPass(){
        return this._upass;
    }

    public void setUPass(String name){
        this._upass = name;
    }

}
