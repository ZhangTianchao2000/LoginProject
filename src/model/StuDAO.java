package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StuDAO {
    //分页查询信息
    public List<Student> page(Connection con, Page page) throws Exception {
        Student resultStu = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM student_t limit 3 offset ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, (page.getPage() - 1) * 3);

        ResultSet rs = pstmt.executeQuery();

        List<Student> list = new ArrayList<Student>();

        while (rs.next()) {

            resultStu = new Student();
            resultStu.setId(rs.getString("id"));
            resultStu.setName(rs.getString("name"));
            resultStu.setAge(rs.getString("age"));
            resultStu.setHome(rs.getString("home"));

            list.add(resultStu);
        }
        return list;
    }

    //查询总的记录数
    public int total(Connection con, Page page) throws Exception {
        PreparedStatement pstmt = null;
        String sql = "SELECT COUNT(*) totalCount FROM student_t";
        pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            page.setTotalSize(rs.getInt("totalCount"));
        }
        return page.getTotalSize();
    }

    //查询学生信息
    public List<Student> findAll(Connection con, Student stu) throws Exception {
        Student resultStu = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM student_t";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Student> list = new ArrayList<Student>();

        while (rs.next()) {

            resultStu = new Student();
            resultStu.setId(rs.getString("id"));
            resultStu.setName(rs.getString("name"));
            resultStu.setAge(rs.getString("age"));
            resultStu.setHome(rs.getString("home"));

            list.add(resultStu);
        }
        return list;
    }

    //添加学生
    public boolean add(Connection con, Student stu) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO student_t VALUES(?,?,?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, stu.getId());
        pstmt.setString(2, stu.getName());
        pstmt.setString(3, stu.getAge());
        pstmt.setString(4, stu.getHome());

        if (pstmt.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }

    //删除学生
    public boolean delete(Connection con, Student stu) throws Exception {

        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM student_t WHERE id = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, stu.getId());
        if (pstmt.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }

    //单个查询
    public Student findOne(Connection con, Student stu) throws Exception {

        String sql = "select * from student_t where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, stu.getId());

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            stu = new Student();
            stu.setId(rs.getString("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getString("age"));
            stu.setHome(rs.getString("home"));
        }
        return stu;
    }

    //修改学生
    public boolean update(Connection con, Student stu) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "UPDATE student_t SET name=? , age=? ,home=? WHERE id=?";
        pstmt = con.prepareStatement(sql);

        pstmt.setString(1, stu.getName());
        pstmt.setString(2, stu.getAge());
        pstmt.setString(3, stu.getHome());
        pstmt.setString(4, stu.getId());

        if (pstmt.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }

    //模糊查询
    public List<Student> findSome(Connection con, Student stu) throws Exception {
        Student resultStu = null;
        PreparedStatement pstmt = null;
        Empty empty = new Empty();
        String home = stu.getHome();
        String age = stu.getAge();

        if (!empty.isEmpty(age) && !empty.isEmpty(home)) {
            String sql = "SELECT * FROM student_t WHERE age = ? AND home = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, age);
            pstmt.setString(2, home);
        } else if (!empty.isEmpty(home)) {
            String sql = "SELECT * FROM student_t WHERE home = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, home);
        } else if (!empty.isEmpty(age)) {
            String sql = "SELECT * FROM student_t WHERE age = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, age);
        } else {
            String sql = "SELECT * FROM student_t";
            pstmt = con.prepareStatement(sql);
        }

        ResultSet rs = pstmt.executeQuery();

        List<Student> list = new ArrayList<Student>();

        while (rs.next()) {
            resultStu = new Student();
            resultStu.setId(rs.getString("id"));
            resultStu.setName(rs.getString("name"));
            resultStu.setAge(rs.getString("age"));
            resultStu.setHome(rs.getString("home"));

            list.add(resultStu);
        }
        return list;
    }
}
