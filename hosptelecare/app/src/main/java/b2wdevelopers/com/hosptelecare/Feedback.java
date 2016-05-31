package b2wdevelopers.com.hosptelecare;

/**
 * Created by admin on 12/26/2015.
 */


public class Feedback {

    int _id;
    String _patname;
    String _drname;
    String _issue;
    String _indate;

    // Empty constructor
    public Feedback(){

    }
    // constructor
    public Feedback(int id,String pname,String dname,String issue,String date){//int id, String subject, String body, String time){
        this._id = id;
        this._patname = pname;
        this._drname= dname;
        this._issue = issue;
        this._indate = date;
    }

    public int getId(){
        return this._id;
    }

    public void setId(int id){
        this._id = id;
    }

    public String getPName(){
        return this._patname;
    }

    public void setPName(String name){
        this._patname = name;
    }

    public String getDName(){
        return this._drname;
    }

    public void setDName(String name){
        this._drname = name;
    }

    public String getIssue(){
        return this._issue;
    }

    public void setIssue(String iss){
        this._issue = iss;
    }

    public String getDate(){ return this._indate; }

    public void setDate(String d){
        this._indate = d;
    }

}
