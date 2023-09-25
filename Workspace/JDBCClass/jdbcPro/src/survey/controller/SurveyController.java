package survey.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import days04.board.domain.BoardDTO;
import survey.domain.SurveyDTO;
import survey.domain.SurveyOptionDTO;
import survey.domain.VoteDTO;
import survey.survice.SurveyService;

public class SurveyController {

	private Scanner sc;
	private int selectedNumber;
	private SurveyService service;

	// 페이징 처리 필드
	private int currentPage = 1;
	private int numberPerPage = 10;
	private int numberOfPageBlock = 10;

	public SurveyController() {
		this.sc = new Scanner(System.in);
	}

	public SurveyController(SurveyService service) {
		this();
		this.service = service;
	}

	public void surveyStart() {
		while (true) {
			메뉴출력();
			메뉴선택();
			메뉴처리();
		}
	}

	private void 메뉴처리() {

		switch (this.selectedNumber) {
		case 1: // 새글
			새글쓰기();
			break;
		case 2: // 목록
			목록보기();
			break;
		case 3: // 보기
			상세보기();
			break;
		case 4: // 검색
			검색하기();
			break;
		case 5: // 투표하기
			투표하기();
			break;
		case 6: // 투표수정
			투표수정();
			break;
		case 7: // 투표삭제
			투표취소();
			break;
		case 8: // 종료
			exit();
		}

	}

	private void 검색하기() {
		System.out.print(">검색조건 제목(1),작성자(2),제목+작성자(3) 선택: ");
		int searchCondition = this.sc.nextInt();
		System.out.print("> 검색어 입력: ");
		String searchWord = this.sc.next();
		// 목록보기() 모든 코딩 복붙
		System.out.print("> 현재 페이지(currentPage) 번호를 입력: ");
		this.currentPage = this.sc.nextInt();

		ArrayList<SurveyDTO> list = this.service.selectService(currentPage, numberPerPage,searchCondition,searchWord);
		  LocalDate now = LocalDate.now();
		String state = null;
		// 뷰-출력담당
		System.out.println("\t\t\t 게시판");
		System.out.println("-".repeat(95));
		System.out.printf("%s %s %s %s %s %s %s\n", "글번호", "글쓴이", "시작일", "종료일", "제목", "항목수", "참여수");
		System.out.println("-".repeat(95));
		if (list == null) {
			System.out.println("\t\t\t> 게시글은 존재 X");
		} else {
			Iterator<SurveyDTO> ir = list.iterator();
			while (ir.hasNext()) {
				
				SurveyDTO dto = ir.next();
				
				System.out.printf("%d %s %s %s %s %d %d\n", dto.getSurveyId(), dto.getUserId(), dto.getStartDate(),
						dto.getEndDate(), dto.getTitle(), dto.getOptionList(), dto.getSurveyAllCnt());
			}
		}
		System.out.println("-".repeat(95));
		String pagingBlock = this.service.pageService(this.currentPage, this.numberPerPage, this.numberOfPageBlock);
		System.out.println(pagingBlock);
		System.out.println("-".repeat(95));
		일시정지();
		
	}

	private String stateCheck(Date startDate, Date endDate) {
		String state = "종료";
		LocalDate start = startDate.toLocalDate();
		LocalDate end = endDate.toLocalDate();
		LocalDate now = LocalDate.now();
		if (now.compareTo(start)>=0 && now.compareTo(end)<=0) {
			state = "진행중";
		}else if(now.compareTo(start)<=0 && now.compareTo(end)<=0) {
			state = "비진행";		}
		return state;
	}

	private void 투표취소() {
		System.out.print(">삭제할 게시글 번호(seq)를 입력: ");
		int seq = this.sc.nextInt();
		System.out.print(">삭제할 user_id를 입력: ");
		String user_id = this.sc.next();
		int rowCount = this.service.voteDeleteService(user_id, seq);
		if (rowCount == 1)
			System.out.println(seq + "번 설문 투표 취소 성공");

		일시정지();

	}

	private void 투표수정() {
		System.out.print("> 설문 번호(seq)를 입력: ");
		int seq = this.sc.nextInt();

		SurveyDTO dto = this.service.viewService(seq);

		if (dto == null) {
			System.out.println("> 해당 게시글 존재 XX");
			return;
		}
		// 해당 설문 정보 출력
		System.out.printf("%d %s %s %s %s %d %d\n", dto.getSurveyId(), dto.getUserId(), dto.getStartDate(),
				dto.getEndDate(), dto.getTitle(), dto.getOptionList(), dto.getSurveyAllCnt());
		// 설문 항목
		System.out.printf("%s %s %s\n", "항목번호", "투표수", "내용");
		ArrayList<SurveyOptionDTO> list = this.service.optViewService(seq);
		Iterator<SurveyOptionDTO> ir = list.iterator();
		while (ir.hasNext()) {
			SurveyOptionDTO optdto = ir.next();
			System.out.printf("%d번 %d %s\n", optdto.getOptionId(), optdto.getOptionCnt(), optdto.getOptionContent());

		}

		System.out.println("\t\n [수정] [삭제] [목록(home)]");
		일시정지();
		// email,title,content
		// UPDAE SET email = ? ,title = ?, content = ?
		System.out.print(">userid입력: ");
		String user_id = this.sc.next();
		System.out.print(">설문항목 입력: ");
		int option_id = this.sc.nextInt();
		

		// dto
		
		VoteDTO vdto = VoteDTO.builder().survey_id(seq).user_id(user_id).option_id(option_id).build();
		int rowCount = this.service.voteUpdateService(vdto);
		if (rowCount == 1)
			System.out.printf("> %d번째 설문 투표 수정 완료", seq);
		일시정지();

	}

	private void 투표하기() {
		System.out.print("> user_id, 설문번호, 투표번호 입력: ");

		String user_id = this.sc.next();
		int survey_id = this.sc.nextInt();
		int option_id = this.sc.nextInt();
		

		VoteDTO dto = VoteDTO.builder().user_id(user_id).survey_id(survey_id).option_id(option_id).build();

		int rowCount = this.service.voteInsertService(dto);
		
		
		if (rowCount == 1)
			System.out.println("투표 완료");
		else
			System.out.println("투표 실패");

		일시정지();

	}

	private void 상세보기() {
		System.out.print("> 설문 번호(seq)를 입력: ");
		int seq = this.sc.nextInt();

		SurveyDTO dto = this.service.viewService(seq);

		if (dto == null) {
			System.out.println("> 해당 게시글 존재 XX");
			return;
		}
		// 해당 설문 정보 출력
		
		String state = null;
		state = stateCheck(dto.getStartDate(),dto.getEndDate());
		System.out.printf("%d %s %s %s %s %d %d %s\n", dto.getSurveyId(), dto.getUserId(), dto.getStartDate(),
				dto.getEndDate(), dto.getTitle(), dto.getOptionList(), dto.getSurveyAllCnt(),state);
		// 설문 항목
		int temp = dto.getSurveyAllCnt();
		//if(temp == 0) temp = 1; 
		System.out.printf("%s %s %s %s\n", "항목번호","내용","투표수","비율");
		ArrayList<SurveyOptionDTO> list = this.service.optViewService(seq);
		Iterator<SurveyOptionDTO> ir = list.iterator();
		while (ir.hasNext()) {
			double per = 0;
			SurveyOptionDTO optdto = ir.next();
			per = (optdto.getOptionCnt()*100/dto.getSurveyAllCnt());
			System.out.printf("%4d번 %s %d %s (%.2f)%% \n", optdto.getOptionId(),optdto.getOptionContent(),optdto.getOptionCnt()
					,"#".repeat((int) per),per);
			
		}

		System.out.println("\t\n [수정] [삭제] [목록(home)]");
		일시정지();

	}

	private void 목록보기() {
		System.out.print("> 현재 페이지(currentPage) 번호를 입력: ");
		this.currentPage = this.sc.nextInt();

		ArrayList<SurveyDTO> list = this.service.selectService(currentPage, numberPerPage,0,"0");
	
		// 뷰-출력담당
		System.out.println("\t\t\t 게시판");
		System.out.println("-".repeat(95));
		System.out.printf("%s\t%-10s\t%-10s\t%-10s\t%-20s\t%-3s\t%-3s\t%-3s\n", "글번호", "글쓴이", "시작일", "종료일", "제목", "항목수", "참여수","상태");
		System.out.println("-".repeat(95));
		if (list == null) {
			System.out.println("\t\t\t> 게시글은 존재 X");
		} else {
			String state = null;
			Iterator<SurveyDTO> ir = list.iterator();
			while (ir.hasNext()) {
				
				SurveyDTO dto = ir.next();
				state = stateCheck(dto.getStartDate(),dto.getEndDate());
//				"%s\t%-10s\t%-10s\t%-10s\t%-30s\t%-3s\t%-3s\t%-3s\n"
				System.out.printf("%d\t%-10s\t%-10s\t%-10s\t%-15s\t%3d\t%d\t%-3s\n", dto.getSurveyId(), dto.getUserId(), dto.getStartDate(),
						dto.getEndDate(), dto.getTitle(), dto.getOptionList(), dto.getSurveyAllCnt(),state);
			}
		}
		System.out.println("-".repeat(110));
		String pagingBlock = this.service.pageService(this.currentPage, this.numberPerPage, this.numberOfPageBlock);
		System.out.println(pagingBlock);
		System.out.println("-".repeat(110));
		일시정지();
	}

	private void 새글쓰기() {
		System.out.print("> user_id, endDate, title, 항목수 입력: ");

		String user_id = this.sc.next();
		String endDate = this.sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = null;
		try {
			date = dateFormat.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		String title = this.sc.next();
		int optionList = this.sc.nextInt();

		SurveyDTO dto = SurveyDTO.builder().userId(user_id).endDate(sqlDate).title(title).optionList(optionList)
				.build();

		int rowCount = this.service.insertService(dto);
		int optRowCount = 0;
		for (int i = 1; i <= optionList; i++) {
			System.out.printf("%d번째 항목 내용 입력: ", i);
			String optionContent = this.sc.next();
			SurveyOptionDTO optdto = SurveyOptionDTO.builder().optionId(i).optionContent(optionContent).build();
			optRowCount += this.service.optInsertService(optdto);

		}
		if (rowCount == 1 && optRowCount == optionList)
			System.out.println("설문 작성 완료");
		else
			System.out.println("설문 작성 실패");

		일시정지();
	}

//	private void 새글쓰기() {
//		System.out.print("> user_id, endDate, title, 항목수 입력: ");
//	
//		String user_id = this.sc.next();
//		String endDate = this.sc.next();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		java.util.Date date = null;
//		try {
//			date = dateFormat.parse(endDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		String title = this.sc.next();
//		int optionList = this.sc.nextInt();
//	
//		SurveyDTO dto = SurveyDTO.builder().userId(user_id).endDate(sqlDate).title(title).optionList(optionList)
//				.build();
//	
//		int rowCount = this.service.insertService(dto);
//		int optRowCount = 0;
//		for (int i = 1; i <= optionList; i++) {
//			System.out.printf("%d번째 항목 내용 입력: ", i);
//			String optionContent = this.sc.next();
//			SurveyOptionDTO optdto = SurveyOptionDTO.builder().optionId(i).optionContent(optionContent).build();
//			optRowCount += this.service.optInsertService(optdto);
//	
//		}
//		if (rowCount == 1 && optRowCount == optionList)
//			System.out.println("설문 작성 완료");
//		else
//			System.out.println("설문 작성 실패");
//	
//		일시정지();
//	}

	private void 메뉴선택() {
		System.out.print("메뉴 선택 하세요:");
		this.selectedNumber = this.sc.nextInt();
	}

	private void 메뉴출력() {
		String[] menus = { "새글", "목록", "보기", "검색", "투표하기", "투표수정", "투표취소","종료" };
		System.out.println("[메뉴]");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s \t", i + 1, menus[i]);
		}
		System.out.println();

	}

	private void 일시정지() {
		System.out.println(" \t\t 계속하려면 엔터치세요.");
		try {
			System.in.read();
			System.in.skip(System.in.available()); // 13, 10
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exit() {
		DBConn.close();
		System.out.println("\t\t\t  프로그램 종료!!!");
		System.exit(-1);
	}
}
