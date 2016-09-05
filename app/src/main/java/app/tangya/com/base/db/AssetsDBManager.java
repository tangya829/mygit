package app.tangya.com.base.db;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/28.
 */
public class AssetsDBManager {
    public static void copyAssetsFileToFile(Context context, String path, File tofile){
        InputStream in=null;
        BufferedInputStream read=null;
        BufferedOutputStream write=null;
        try {
            in=context.getAssets().open(path);
            read=new BufferedInputStream(in);
            write=new BufferedOutputStream(new FileOutputStream(tofile,false));
            byte[] b=new byte[2*1024];
            int len=0;
            while (-1!=(len=read.read(b,0,b.length))){
                write.write(b,0,len);
            }
            write.flush();
        } catch (Exception e) {
            Log.d("出错","出错");
        }finally {
            try {
                in.close();
                read.close();
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
