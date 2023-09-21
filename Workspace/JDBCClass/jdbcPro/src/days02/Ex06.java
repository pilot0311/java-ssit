package days02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.util.DBConn;

public class Ex06 {
    //EmpDao,EmpImpl pstmt
// days02.Ex04 수정
//2.
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
//       String sql = " SELECT deptno,job,empno, ename,sal "
//                + " FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal WHERE grade = ? ";

        String sql =" SELECT e.deptno,d.dname,empno,ename,sal  FROM emp e JOIN dept d ON e.deptno=d.deptno JOIN salgrade s ON sal BETWEEN losal AND hisal where grade = ? ";
        String sql2 = " SELECT losal,hisal,grade,count(*)  FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal GROUP BY losal,hisal,grade ORDER BY grade ";
        int grade = 0;
        try {
            conn = DBConn.getConnection();

            pstmt2 = conn.prepareStatement(sql2);
            rs2 = pstmt2.executeQuery();
            pstmt = conn.prepareStatement(sql);
            if (rs2.next()) {

                do {
                    System.out.printf("%d등급 (%d ~ %d) - %d명\n",rs2.getInt("grade"),rs2.getInt("losal"),rs2.getInt("hisal"),rs2.getInt("count(*)"));
                    pstmt.setInt(1,rs2.getInt("grade"));
                    rs = pstmt.executeQuery();

                    if (rs.next()){
                        do {
                            System.out.printf("%d %s %d %s %d\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5));


                        } while (rs.next());
                    }
                System.out.println();
                } while (rs2.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            DBConn.close();
            rs.close();
            rs2.close();
            pstmt.close();
            pstmt2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }// main
}// class

// 2.
/*
 * [실행결과] 1등급 ( 700~1200 ) - 2명
 * 20 RESEARCH 7369 SMITH 800
 * 30 SALES 7900 JAMES 950
 * 2등급 ( 1201~1400 ) - 2명
 * 30 SALES 7654 MARTIN 2650
 * 30 SALES 7521 WARD 1750
 * 3등급 ( 1401~2000 ) - 2명
 * 30 SALES 7499 ALLEN 1900
 * 30 SALES 7844 TURNER 1500
 * 4등급 ( 2001~3000 ) - 4명
 * 10 ACCOUNTING 7782 CLARK 2450
 * 20 RESEARCH 7902 FORD 3000
 * 20 RESEARCH 7566 JONES 2975
 * 30 SALES 7698 BLAKE 2850
 * 5등급 ( 3001~9999 ) - 1명
 * 10 ACCOUNTING 7839 KING 5000
 *
 * /////////
 *
 * 1등급 (700 ~ 1200) - 2명
20 RESEARCH 7369 SMITH 800
30 SALES 7900 JAMES 950
2등급 (1201 ~ 1400) - 3명
30 SALES 7521 WARD 1250
30 SALES 7654 MARTIN 1250
10 ACCOUNTING 7934 MILLER 1300
3등급 (1401 ~ 2000) - 2명
30 SALES 7499 ALLEN 1600
30 SALES 7844 TURNER 1500
4등급 (2001 ~ 3000) - 4명
20 RESEARCH 7566 JONES 2975
30 SALES 7698 BLAKE 2850
10 ACCOUNTING 7782 CLARK 2450
20 RESEARCH 7902 FORD 3000
5등급 (3001 ~ 9999) - 1명
10 ACCOUNTING 7839 KING 5000
 */