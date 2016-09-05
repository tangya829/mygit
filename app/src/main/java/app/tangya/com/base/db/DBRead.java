package app.tangya.com.base.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

import app.tangya.com.entity.TourInfo;

/**
 * Created by Administrator on 2016/8/28.
 */
public class DBRead {
    public static File tofile;
    static {
        String str="data/";
        str+= Environment.getDataDirectory().getAbsolutePath();
        str+="/app.tangya.com.myapp50/";
        File file=new File(str);
        file.mkdirs();
        str+="tour.db";
        tofile=new File(str);
    }
    public static boolean isExistFileToFile(){
        File file= DBRead.tofile;
        if (!file.exists()||file.length()<=0){
            return false;
        }
        return true;
    }
    public static ArrayList<TourInfo> readTeldbClasslist(){
        ArrayList<TourInfo> list=new ArrayList<TourInfo>();
        SQLiteDatabase db=null;
        Cursor cursor=null;
        try {
            db=SQLiteDatabase.openOrCreateDatabase(tofile,null);
            cursor=db.rawQuery("select*from tour;",null);
            if (cursor.moveToNext()){
                do {
                    String locality=cursor.getString(cursor.getColumnIndex("locality"));
                    int id=cursor.getInt(cursor.getColumnIndex("id"));
                    TourInfo info=new TourInfo(id,locality);
                    list.add(info);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){

        }finally {
            cursor.close();
            db.close();
        }
        return list;
    }
}
