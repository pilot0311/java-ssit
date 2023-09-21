package days02;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.util.DBConn;
import domain.EmpVO;
import domain.SalgradeVO2;

public class Ex06_02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT e.deptno, d.dname, empno, ename, sal, losal, hisal, grade " +
                "FROM emp e " +
                "JOIN dept d ON e.deptno = d.deptno " +
                "JOIN salgrade s ON sal BETWEEN losal AND hisal";

        Map<Integer, SalgradeVO2> gradeMap = new HashMap<>();

        try {
            conn = DBConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int grade = rs.getInt("grade");
                int losal = rs.getInt("losal");
                int hisal = rs.getInt("hisal");

                EmpVO emp = new EmpVO();
                emp.setDeptno(rs.getInt("deptno"));
                emp.setDname(rs.getString("dname"));
                emp.setEname(rs.getString("ename"));
                emp.setEmpno(rs.getInt("empno"));
                emp.setSal(rs.getInt("sal"));


                SalgradeVO2 gradeVO = gradeMap.get(grade);

                if (gradeVO == null) {

                    gradeVO = new SalgradeVO2(grade, losal, hisal);
                    gradeVO.setEmpList(new ArrayList<>());
                    gradeMap.put(grade, gradeVO);
                }

                // 직원 정보를 해당 등급의 직원 목록에 추가
                gradeVO.getEmpList().add(emp);
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
    }

    private static void printMap(Map<Integer, SalgradeVO2> gradeMap) {
        Iterator<Map.Entry<Integer, SalgradeVO2>> it = gradeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, SalgradeVO2> entry = it.next();
            SalgradeVO2 gradeVO = entry.getValue();
            System.out.println(gradeVO.getGrade() + "등급 (" + gradeVO.getLosal() + " ~ " + gradeVO.getHisal() + ") - " + gradeVO.getEmpList().size() + "명");

            Iterator<EmpVO> ir = gradeVO.getEmpList().iterator();
            while (ir.hasNext()) {
                EmpVO emp = ir.next();
                System.out.println(emp.getDeptno() + " " + emp.getDname() + " " + emp.getEmpno() + " " + emp.getEname() + " " + emp.getSal());
            }

            System.out.println();
        }
    }
}