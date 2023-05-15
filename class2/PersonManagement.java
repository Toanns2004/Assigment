package com.class2;

import com.DBUtil.DBUtil;
import com.class1.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonManagement {
    public void addNewPerson(Person person)throws Exception{
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "INSERT INTO Person(Name,Email,Address,Phone) VALUES (?,?,?,?)");
            pstm.setString(1,person.getName());
            pstm.setString(2, person.getEmail());
            pstm.setString(3,person.getAddress());
            pstm.setString(4, person.getPhone());

            int updated = pstm.executeUpdate();
            if (updated > 0){
                System.out.println("Insert Student success!!!");
            }
            pstm.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getAllPerson(){
        try {
            Connection connect = DBUtil.getConnection();
            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Id,Name, Email, Address, Phone FROM Person ");
            while (rs.next()){
                Person person = new Person(
                  rs.getInt(1),
                  rs.getString(2),
                  rs.getString(3),
                  rs.getString(4),
                  rs.getString(5)
                );
                System.out.println(person.toString());
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Person getPersonById(int id)throws Exception{
        Person person = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "SELECT ID, NAME, EMAIL, ADDRESS, PHONE FROM Person WHERE Id =?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                person = new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return person;
    }

    public void updateStudent(int id) throws Exception{
        try {
            Person updateSt = this.getPersonById(id);
            if (updateSt != null){
                updateSt.inputData();
                Connection conn = DBUtil.getConnection();
                PreparedStatement psmt = conn.prepareStatement(
                        "UPDATE Person SET NAME =?, EMAIL = ?, ADDRESS =?, PHONE=? WHERE ID=?");
                psmt.setString(1,updateSt.getName());
                psmt.setString(2,updateSt.getEmail());
                psmt.setString(3,updateSt.getAddress());
                psmt.setString(4,updateSt.getPhone());
                psmt.setInt(5,updateSt.getId());

                int updated = psmt.executeUpdate();
                if (updated > 0){
                    System.out.println("Update Person success!!!");
                }
                psmt.close();
                conn.close();
            }else {
                System.out.println("Person not found");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletePerson(int id)throws Exception{
        try {
            Person delete = this.getPersonById(id);
            if (delete != null) {
                Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM Person WHERE id =?");
                stmt.setInt(1,delete.getId());
                stmt.executeUpdate();
                stmt.close();
                conn.close();
            }else {
                System.out.println("Person not found");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
