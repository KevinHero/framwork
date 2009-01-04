package com.flyong.others.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * URL和URI之间的转换
 * 
 * 
 * 
 */
public class URL2URI {

  public static void main(String[] args) {
    URI uri = null;
    URL url = null;

    // 创建一个URI
    try {
      uri = new URI("file://D:/workplace/URL2URI.java");
    } catch (URISyntaxException e) {
    }
    System.out.println(uri);

    // 转换为URL
    try {
      url = uri.toURL();
    } catch (IllegalArgumentException e) {

    } catch (MalformedURLException e) {
    }
    System.out.println(url);

    // 转换URL到 URI
    try {
      uri = new URI(url.toString());
    } catch (URISyntaxException e) {
    }
    System.out.println(uri);
  }

}
