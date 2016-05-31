package b2wdevelopers.com.hosptelecare;

/**
 * Created by admin on 12/26/2015.
 */


public class MedRecords {

    int _id;
    String _drname;
    String _issue;
    String _indate;

    // Empty constructor
    public MedRecords(){

    }
    // constructor
    public MedRecords(int id,String name,String issue,String date){//int id, String subject, String body, String time){
        this._id = id;
        this._drname= name;
        this._issue = issue;
        this._indate = date;
    }



    public int getId(){
        return this._id;
    }

    public void setId(int id){
        this._id = id;
    }

    public String getName(){
        return this._drname;
    }

    public void setName(String name){
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
