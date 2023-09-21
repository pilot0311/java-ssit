package days02;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConn;
import domain.EmpVO;
import domain.SalgradeVO;

public class Ex06_03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT e.deptno, d.dname, empno, ename, sal, losal, hisal, grade " +
                "FROM emp e " +
                "JOIN dept d ON e.deptno = d.deptno " +
                "JOIN salgrade s ON sal BETWEEN losal AND hisal ";
        EmpVO empvo = null;
        List<EmpVO> emplist  =null;
        SalgradeVO gradeVO = null;
        Map<SalgradeVO, ArrayList<EmpVO>> gradeMap = new LinkedHashMap<>();

        try {
            conn = DBConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int grade = rs.getInt("grade");
                int losal = rs.getInt("losal");
                int hisal = rs.getInt("hisal");

                empvo = new EmpVO();
                empvo.setDeptno(rs.getInt("deptno"));
                empvo.setDname(rs.getString("dname"));
                empvo.setEname(rs.getString("ename"));
                empvo.setEmpno(rs.getInt("empno"));
                empvo.setSal(rs.getInt("sal"));


                gradeVO = new SalgradeVO(grade, losal, hisal);

                if (gradeMap.containsKey(gradeVO)) {
                	gradeMap.get(gradeVO).add(empvo);
                }else {
                	emplist = new ArrayList<EmpVO>();
                	emplist.add(empvo);
                    
                    gradeMap.put(gradeVO, (ArrayList<EmpVO>) emplist);
                }
                
            }

            printMap(gradeMap);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConn.close();
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//main

    private static void printMap(Map<SalgradeVO, ArrayList<EmpVO>> gradeMap) {
        Iterator<Map.Entry<SalgradeVO, ArrayList<EmpVO>>> it = gradeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<SalgradeVO, ArrayList<EmpVO>> entry = it.next();
            SalgradeVO gradeVO = entry.getKey();
            ArrayList<EmpVO> empList = entry.getValue();
            
            System.out.println(gradeVO.getGrade() + "등급 (" + gradeVO.getLosal() + " ~ " + gradeVO.getHisal() + ") - " + empList.size() + "명");

            Iterator<EmpVO> ir = empList.iterator();
            while (ir.hasNext()) {
                EmpVO emp = ir.next();
                System.out.println(emp.getDeptno() + " " + emp.getDname() + " " + emp.getEmpno() + " " + emp.getEname() + " " + emp.getSal());
            }
            System.out.println();
        }
    }
}//calss