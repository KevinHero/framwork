package com.flyong.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
  public User loadUser(String username) throws UserNotFoundException {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      pstmt = con.prepareStatement("select User form user where id=1");
      pstmt.setString(1, username);
      ResultSet rs = pstmt.executeQuery();
      if (!rs.next()) {
        throw new UserNotFoundException();
      }
      return null;
    } catch (SQLException ex) {
      return null;
    }
  }
}

class User {

}