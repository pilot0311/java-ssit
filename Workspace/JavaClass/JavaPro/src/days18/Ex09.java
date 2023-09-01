package days18;

public class Ex09 {

	public static void main(String[] args) {
		
		//	StringBuffer, StringBuilder 클래스
		//	StringBuilder	:	멀티 쓰레드 안전x			동기화 x			
		//	StringBuffer:	멀티 쓰레드 안전o 		동기화 o
		// 사용법은 둘다 동일함
		// 위의 두 클래스 언제 사용하는가? 
		//	String 변경 불가능한 클래스, (StringBuffer, StringBuilder)은 변경 가능한 클래스(삽입,수정,삭제,추가)
		//객체 생성이 라인 수만 큼 ..
		String sql = "SELECT "; 
        sql += "a.ano ";
        sql += " ";
        sql += ", a.user_id as userId ";
        sql += " ";
        sql += ", b.user_name as userName ";
        sql += " ";
        sql += ", a.rno ";
        sql += " ";
        sql += ", c.rname ";
        sql += " ";
        sql += ", DATE_FORMAT(a.sd,'%Y-%m-%d') as sd ";
        sql += " ";
        sql += ", DATE_FORMAT(a.ed,'%Y-%m-%d') as ed ";
        sql += " ";
        sql += ", DATE_FORMAT(a.rd,'%Y-%m-%d %T') as rd ";
        sql += " ";
        sql += ", DATE_FORMAT(a.check_in,'%Y-%m-%d %T') as checkIn ";
        sql += " ";
        sql += ", DATE_FORMAT(a.check_out,'%Y-%m-%d %T') as checkOut ";
        sql += " ";
        sql += "-- , a.sign_yn as signYn ";
        sql += " ";
        sql += ", d.code_name as signYn ";
        sql += " ";
        sql += "-- , a.cancel_yn as cancelYn ";
        sql += " ";
        sql += ", e.code_name as cancelYn ";
        sql += " ";
        sql += "FROM tb_reservation a left outer join tb_user b on a.user_id = b.user_id ";
        sql += " ";
        sql += "left outer join tb_rooms c on a.rno = c.rno ";
        sql += " ";
        sql += "left outer join tb_code d on a.sign_yn = d.code_cd ";
        sql += " ";
        sql += "left outer join tb_code e on a.cancel_yn = e.code_cd ";
        
        System.out.println(sql);
	} // main
}


/*
 * SELECT

a.ano

, a.user_id as userId

, b.user_name as userName

, a.rno

, c.rname

, DATE_FORMAT(a.sd,'%Y-%m-%d') as sd

, DATE_FORMAT(a.ed,'%Y-%m-%d') as ed

, DATE_FORMAT(a.rd,'%Y-%m-%d %T') as rd

, DATE_FORMAT(a.check_in,'%Y-%m-%d %T') as checkIn

, DATE_FORMAT(a.check_out,'%Y-%m-%d %T') as checkOut

-- , a.sign_yn as signYn

, d.code_name as signYn

-- , a.cancel_yn as cancelYn

, e.code_name as cancelYn

FROM tb_reservation a left outer join tb_user b on a.user_id = b.user_id

left outer join tb_rooms c on a.rno = c.rno

left outer join tb_code d on a.sign_yn = d.code_cd

left outer join tb_code e on a.cancel_yn = e.code_cd
[출처] [실전 풀스택] 데이터베이스 중점 웹개발 연속강의 - 코드 테이블 연동 및 페이징처리|작성자 나비다
 */
