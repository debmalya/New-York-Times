/**
 * 
 */
package com.deb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Debmalya Jash debmalya.jash@gmail.com
 * 
 */
public class JSONReader
{

  private static String readAll (Reader rd) throws IOException
  {
    StringBuilder sb = new StringBuilder ();
    int cp;
    while ((cp = rd.read ()) != -1)
    {
      sb.append ((char)cp);
    }
    return sb.toString ();
  }



  /**
   * Read JSON string from a url and return a JSON object.
   * 
   * @param url
   *          from which JSON results will be read.
   * @return JSONObject.
   * @throws IOException
   *           url is not accessible or for other IOException.
   * @throws JSONException
   *           JSON is not in well format.
   */
  public static JSONObject readJsonFromUrl (String url) throws IOException, JSONException
  {
    // If required , we need to set proxy here. This should be configurable
//    Proxy proxy = new Proxy (Proxy.Type.HTTP, new InetSocketAddress ("10.150.79.22", 8080));
//    URLConnection conn = new URL (url).openConnection (proxy);

//    conn.getInputStream ();
//    InputStream is = conn.getInputStream ();

    // Code without proxy
    // URL urlObj = new URL (url).;
     InputStream is = new URL (url).openStream ();
    
    try
    {
      BufferedReader rd = new BufferedReader (new InputStreamReader (is, Charset.forName ("UTF-8")));
      String jsonText = readAll (rd);
      JSONObject json = new JSONObject (jsonText);
      return json;
    }
    finally
    {
      is.close ();
    }
  }
}
