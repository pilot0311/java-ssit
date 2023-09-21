package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class BoardDTO {
/*
SEQ       NOT NULL NUMBER        
WRITER    NOT NULL VARCHAR2(20)  
PWD       NOT NULL VARCHAR2(20)  
EMAIL              VARCHAR2(100) 
TITLE     NOT NULL VARCHAR2(200) 
WRITEDATE          DATE          
READED             NUMBER        
TAG                NUMBER(1)     
CONTENT            CLOB        
 */
private int seq;
private String writer;
private String pwd;
private String email;
private String title;
private Date writedate;
private int readed;
private int tag;
private String content;
	
	
	
}
