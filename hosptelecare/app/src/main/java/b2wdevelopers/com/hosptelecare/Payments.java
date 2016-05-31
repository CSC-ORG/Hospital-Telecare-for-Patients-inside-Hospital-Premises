package b2wdevelopers.com.hosptelecare;

/**
 * Created by admin on 12/26/2015.
 */


public class Payments {

    int _id;
    String _amount;
    String _issue;
    String _indate;
    String _bill;

    // Empty constructor
    public Payments(){

    }
    // constructor
    public Payments(int id,String issue,String bill,String amount,String date){//int id, String subject, String body, String time){
        this._id = id;
        this._bill = bill;
        this._amount= amount;
        this._issue = issue;
        this._indate = date;
    }



    public int getId(){
        return this._id;
    }

    public void setId(int id){
        this._id = id;
    }

    public String getAmount(){
        return this._amount;
    }

    public void setAmount(String name){
        this._amount = name;
    }

    public String getBill(){
        return this._bill;
    }

    public void setBill(String name){
        this._bill = name;
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
