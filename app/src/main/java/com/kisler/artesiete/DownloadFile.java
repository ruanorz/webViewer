package com.kisler.artesiete;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DownloadFile {

    private static String isDownload = "no";

    public static void setUrl(Context context, String urlFile, String fileName, String folderName) {
        try {
            //set the download URL, a url that points to a file on the internet
            //this is the file to be downloaded
            URL url = null;
            try {
                url = new URL(urlFile);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            //create the new connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


            //set up some things on the connection
            urlConnection.setRequestMethod("GET");
            //urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
            urlConnection.setRequestProperty("Accept", "*/*");

            //and connect!
            urlConnection.connect();

            String folderPath = Environment.getExternalStorageDirectory()+"/"+folderName;
            File folder = new File(folderPath);
            Log.v("PATH", folderPath);
            if(!folder.exists())
            {
                folder.mkdir();
            }

            //create a new file, specifying the path, and the filename
            //which we want to save the file as.
            File file = new File(folderPath, fileName);

            //this will be used to write the downloaded data into the file we created
            FileOutputStream fileOutput = new FileOutputStream(file);

            //this will be used in reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            //this is the total size of the file
            int totalSize = urlConnection.getContentLength();
            //variable to store total downloaded bytes
            int downloadedSize = 0;

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0; //used to store a temporary size of the buffer

            //now, read through the input buffer and write the contents to the file
            while ((bufferLength = inputStream.read(buffer)) > 0) {
                //add the data in the buffer to the file in the file output stream (the file on the sd card
                fileOutput.write(buffer, 0, bufferLength);
                //add up the size so we know how much is downloaded
                downloadedSize += bufferLength;
            }
            //close the output stream when done
            fileOutput.close();

            isDownload = "yes";

            //catch some possible errors...
        } catch (MalformedURLException e) {
            isDownload = "no";
            e.printStackTrace();
        } catch (ProtocolException e) {
            isDownload = "no";
            e.printStackTrace();
        } catch (IOException e) {
            isDownload = "no";
            e.printStackTrace();
        }

        Intent intent = new Intent("custom-event-name");
        intent.putExtra("data", isDownload);
        intent.putExtra("type", "download");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
