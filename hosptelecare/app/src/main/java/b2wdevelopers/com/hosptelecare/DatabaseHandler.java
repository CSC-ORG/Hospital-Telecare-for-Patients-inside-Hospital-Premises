package b2wdevelopers.com.hosptelecare;

/**
 * Created by admin on 12/26/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    static int i=0;
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "Telecare2";

    // Contacts table name
    private static final String TABLE_NAME1 = "Records";
    private static final String TABLE_NAME2 = "Payments";
    private static final String TABLE_NAME3 = "Feedback";
    private static final String TABLE_NAME4 = "Users";

    // Contacts Table Columns names
    private static final String uid = "_uid";
    private static final String uname = "_uname";
    private static final String upass = "_upass";


    private static final String id = "id";
    private static final String doctorname = "doctorname";
    private static final String issue = "issue";
    private static final String indate = "indate";

    private static final String pid = "pid";
    private static final String billno = "bill";
    private static final String pissue = "pissue";
    private static final String date = "date";
    private static final String amount = "amount";

    private static final String fid = "fid";
    private static final String patname = "patname";
    private static final String docname = "docname";
    private static final String feed = "feed";
    private static final String fdate = "fdate";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String USER_TABLE = " CREATE TABLE " + TABLE_NAME4 + "("+ uid +" INTEGER PRIMARY KEY,"+ uname+ " TEXT," +upass + " TEXT"+")";
        String RECORDS_TABLE = " CREATE TABLE " + TABLE_NAME1 + "("+ id +" INTEGER,"+ doctorname+ " TEXT," +issue + " TEXT,"+ indate + " TEXT"+")";
        String PAYMENTS_TABLE = " CREATE TABLE " + TABLE_NAME2 + "("+ pid +" INTEGER,"+ pissue+ " TEXT," + billno+ " TEXT," +amount+ " TEXT,"+date+ " TEXT"+")";
        String FEEDBACK_TABLE = " CREATE TABLE " + TABLE_NAME3 + "("+ fid +" INTEGER,"+ patname+ " TEXT," + docname+ " TEXT,"+ feed+ " TEXT,"+fdate+ " TEXT"+")";

        db.execSQL(USER_TABLE);
        db.execSQL(RECORDS_TABLE);
        db.execSQL(PAYMENTS_TABLE);
        db.execSQL(FEEDBACK_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);

        // Create tables again
        onCreate(db);
    }


    void addUsers(Users u,Context context){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(uname, u.getUName());
        values.put(upass, u.getUPass());

        Log.d("IFF", u.getUName());
        Log.d("IFF", u.getUPass());

        db.insert(TABLE_NAME4, null, values);

    }

    String getUserName(int id)
    {
        String user="";
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME4 + ";";//+" ORDER BY datetime("+IN_TIME+") ASC";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor .moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                if(id==cursor.getInt(0))
                {
                    user=cursor.getString(1);
                   // Log.d("IF", cursor.getInt(0)+"");
                    break;
                }
                cursor.moveToNext();
            }
        }
        return user;
    }

    int check(String user,String pass)
    {
        int id=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME4 + ";";//+" ORDER BY datetime("+IN_TIME+") ASC";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {

                if((user.equals(cursor.getString(1)))&&(pass.equals(cursor.getString(2))))

                {
                    id=cursor.getInt(0);
                    Log.d("IF", cursor.getInt(0)+"");
                    break;
                }
                cursor.moveToNext();

            }
        }
        return id;
    }


    void check1()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME3 + ";";//+" ORDER BY datetime("+IN_TIME+") ASC";
        int id=0;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.d("oo", "check1");

        if (cursor.moveToFirst()) {

            while (cursor.isAfterLast() == false) {

                Log.d("oo", cursor.getInt(0)+"");
                Log.d("oo", cursor.getString(1));
                Log.d("oo", cursor.getString(2));
                Log.d("oo", cursor.getString(3));
                Log.d("oo", cursor.getString(4));

                cursor.moveToNext();
            }
        }
    }




    void addMedicalRecords(MedRecords med,Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(id, med.getId());
        values.put(doctorname, med.getName());
        values.put(issue, med.getIssue());
        values.put(indate, med.getDate());


        db.insert(TABLE_NAME1, null, values);

        check2();
    }

    void check2()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME1 + ";";//+" ORDER BY datetime("+IN_TIME+") ASC";
        int id=0;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.d("medrec", "check2");

        if (cursor.moveToFirst()) {

            while (cursor.isAfterLast() == false) {

                Log.d("medrec", cursor.getInt(0)+"");
                Log.d("medrec", cursor.getString(1));
                Log.d("medrec", cursor.getString(2));
                Log.d("medrec", cursor.getString(3));
                //Log.d("oo", cursor.getString(4));

                cursor.moveToNext();
            }
        }
    }


    void check3()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME2 + ";";//+" ORDER BY datetime("+IN_TIME+") ASC";
        int id=0;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.d("check3", "check3");

        if (cursor.moveToFirst()) {

            while (cursor.isAfterLast() == false) {

                Log.d("payrec", cursor.getInt(0)+"");
                Log.d("payrec", cursor.getString(1));
                Log.d("payrec", cursor.getString(2));
                Log.d("payrec", cursor.getString(3));
                Log.d("payrec", cursor.getString(4));

                cursor.moveToNext();
            }
        }
    }



    void addPayment(Payments pay,Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(pid, pay.getId());
        values.put(pissue, pay.getIssue());
        values.put(billno, pay.getBill());
        values.put(amount, pay.getAmount());
        values.put(date, pay.getDate());


        db.insert(TABLE_NAME2, null, values);

        check3();
    }

    void addFeedback(Feedback f,Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.d("aa",f.getId()+"");
        Log.d("aa", f.getPName());
        Log.d("aa", f.getDName());
        Log.d("aa", f.getIssue());
        Log.d("aa", f.getDate());
        ContentValues values = new ContentValues();
        values.put(fid, f.getId());
        values.put(patname, f.getPName());
        values.put(docname, f.getDName());
        values.put(feed, f.getIssue());
        values.put(fdate, f.getDate());


        db.insert(TABLE_NAME3, null, values);

        check1();

    }


    public List<Users> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Users> ul = new ArrayList<Users>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME4;//+" ORDER BY datetime("+IN_TIME+") ASC";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            while (cursor.isAfterLast() == false) {

                Users u = new Users();
                u.setUName(cursor.getString(1));
                u.setUPass(cursor.getInt(0) + "");
                ul.add(u);
                Log.d("userdet", cursor.getInt(0)+"");
                Log.d("userdet", cursor.getString(1));
                cursor.moveToNext();

            }
        }
        return ul;
    }

    public List<MedRecords> getRecords(int ID) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<MedRecords> me = new ArrayList<MedRecords>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME1 ;//+" ORDER BY datetime("+IN_TIME+") ASC";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {
                if(cursor.getInt(0)==ID) {
                    MedRecords r = new MedRecords();
                    r.setId(cursor.getInt(0));
                    r.setName(cursor.getString(1));
                    r.setIssue(cursor.getString(2));
                    r.setDate(cursor.getString(3));

                    me.add(r);
                    Log.d("medret", cursor.getInt(0)+"");
                    Log.d("medret", cursor.getString(1));
                    Log.d("medret", cursor.getString(2));
                    Log.d("medret", cursor.getString(3));
                }
                cursor.moveToNext();

            }
        }

        return me;
    }


    int getUserId(String user,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME4 +" WHERE _uname = "+ user +" AND _upass= "+ pass + ";";//+" ORDER BY datetime("+IN_TIME+") ASC";
        int id=0;
        Cursor cursor = db.rawQuery(selectQuery, null);
       // Cursor c=db.query()
        Users user1 = null;// = new Notification();
        if (cursor .moveToFirst()) {

                id = cursor.getInt(0);//, cursor.getString(1), cursor.getString(2));

                }


        return id;
        }

    List<Payments> getPayments(int ID) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME2 ;//+" ORDER BY datetime("+IN_TIME+") ASC";
        List<Payments> p = new ArrayList<Payments>();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {
                if(cursor.getInt(0)==ID) {
                    Payments pay = new Payments(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                    p.add(pay);
                    Log.d("IF", cursor.getString(0));
                }
                cursor.moveToNext();

            }
        }

        return p;
    }

    List<Feedback> getFeedback() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Feedback> f = new ArrayList<Feedback>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME3 ;//+" ORDER BY datetime("+IN_TIME+") ASC";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {
                    Feedback feed = new Feedback(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
                    cursor.moveToNext();
                    f.add(feed);
                 //   Log.d("IF", cursor.getString(0));
            }
        }

        return f;
    }

}
