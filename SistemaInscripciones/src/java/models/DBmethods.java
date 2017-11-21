package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author inspiron
 */
import java.sql.*;
import java.util.*;
/**
 *
 * @author Ferdiansyah Dolot
 */
public class DBmethods {
    static String myDriver = "org.apache.derby.jdbc.ClientDriver";
    static String myUrl = "jdbc:derby://localhost:1527/inscripciones";
    
    
    public static void deleteClassrooms(String[] selected) {
        try {
            Class.forName(myDriver).newInstance();
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "DELETE FROM classroom WHERE code = ?";           // create the java statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            for(int i = 0; i < selected.length; i++) {
                preparedStmt.setString(1, selected[i]);
                preparedStmt.execute();
            }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
    
    public static void addSalon(String code, String build, int number) {
        try {
            Class.forName(myDriver).newInstance();
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "INSERT INTO classroom(code, building, room) VALUES (?,?,?)";           // create the java statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, code);
            preparedStmt.setString(2, build);
            preparedStmt.setInt(3, number);
            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
    
    public static List<Classroom> allSalones(){
        try
        {
        // create our mysql database connection
            Class.forName(myDriver).newInstance();
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM classroom";            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            List<Classroom> salones = new ArrayList<Classroom>();
            while (rs.next()) {
                Classroom salon = new Classroom();
                salon.setCode(rs.getString("code"));
                salon.setBuilding(rs.getString("building"));
                salon.setNumber(rs.getInt("room"));
                salones.add(salon);
            }
            st.close();
            conn.close();
            return salones;
        }
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Class> allTimeSlot(){
        try
        {
        // create our mysql database connection
            Class.forName(myDriver).newInstance();
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM schedule";            // create the java statement
            Statement st = conn.createStatement();
            
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            String queryClassroom = "SELECT code FROM classroom WHERE id = ?";
            String queryClass = "SELECT (course_id, teacher_id) FROM class WHERE id = ?";
            String queryTeacher = "SELECT (first_name, last_name) FROM teacher WHERE id = ?";
            String queryCourse = "SELECT title FROM course WHERE id = ?";
            PreparedStatement prepClassroom = conn.prepareStatement(queryClassroom);
            PreparedStatement prepClass = conn.prepareStatement(queryClass);
            PreparedStatement prepTeacher = conn.prepareStatement(queryTeacher);
            PreparedStatement prepCourse = conn.prepareStatement(queryCourse);
        
            List<Class> times = new ArrayList<Class>();
            while (rs.next()) {
                TimeSlot time = new TimeSlot(rs.getString("start_time"), rs.getString("end_time"), rs.getString("day"));
                Class group = new Class();
                prepClassroom.setInt(1, rs.getInt("classroom_id"));
                ResultSet ns = prepClassroom.executeQuery();
                group.setClassroom(ns.getString("code"));
                prepClass.setInt(1, rs.getInt("class_id"));
                ns = prepClass.executeQuery();
                prepTeacher.setInt(1, ns.getInt("teacher_id"));
                prepCourse.setInt(1, ns.getInt("course_id"));
                ns = prepTeacher.executeQuery();
                group.setTeacher(ns.getString("first_name") + ns.getString("last_name"));
                ns = prepCourse.executeQuery();
                group.setCourse(ns.getString("title"));
                group.setTime(time);
                times.add(group);
            }
            st.close();
            conn.close();
            return times;
        }
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Classroom> getSalones(){
        try
        {
        // create our mysql database connection
            Class.forName(myDriver).newInstance();
            Connection conn = DriverManager.getConnection(myUrl);

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT id FROM classroom";            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            List<Integer> salones = new ArrayList<Integer>();
            while (rs.next()) {
                salones.add(rs.getInt("id"));
            }
            
            query = "SELECT classroom_id FROM schedule";
            List<Classroom> borrar = new ArrayList<Classroom>();
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(salones.contains(rs.getInt("classroom_id"))) {
                    Classroom salon = new Classroom();
                    query = "SELECT * FROM classroom WHERE id = '" + rs.getInt("classroom_id") + "'";            // create the java statement
                    ResultSet ns = st.executeQuery(query);
                    salon.setCode(ns.getString("code"));
                    salon.setBuilding(ns.getString("building"));
                    salon.setNumber(ns.getInt("room"));
                    borrar.add(salon);
                }
            }
            st.close();
            conn.close();
            return borrar;
        }
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
}