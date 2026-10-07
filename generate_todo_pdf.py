import os
from reportlab.lib.pagesizes import A4
from reportlab.lib import colors
from reportlab.lib.units import mm
from reportlab.lib.styles import ParagraphStyle
from reportlab.platypus import (
    SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle, PageBreak, KeepTogether
)
from reportlab.pdfbase import pdfmetrics
from reportlab.pdfbase.ttfonts import TTFont

# 폰트 등록
font_path = ".fonts/AppleGothic.ttf"
pdfmetrics.registerFont(TTFont('KR', font_path))
pdfmetrics.registerFont(TTFont('KR-B', font_path))

# 색상 팔레트
C_PRIMARY = colors.HexColor('#1E40AF')
C_SECONDARY = colors.HexColor('#0F172A')
C_BG_LIGHT = colors.HexColor('#F8FAFC')
C_BORDER = colors.HexColor('#CBD5E1')
C_CODE_BG = colors.HexColor('#0F172A')
C_CODE_TEXT = colors.HexColor('#F1F5F9')
C_AMBER = colors.HexColor('#B45309')
C_GREEN = colors.HexColor('#047857')

styles = {
    'Title': ParagraphStyle('DocTitle', fontName='KR-B', fontSize=22, leading=26, textColor=C_PRIMARY),
    'SubTitle': ParagraphStyle('DocSub', fontName='KR', fontSize=12, leading=16, textColor=colors.HexColor('#475569')),
    'H1': ParagraphStyle('H1', fontName='KR-B', fontSize=16, leading=20, textColor=C_PRIMARY),
    'H2': ParagraphStyle('H2', fontName='KR-B', fontSize=12, leading=16, textColor=C_SECONDARY),
    'Body': ParagraphStyle('Body', fontName='KR', fontSize=9, leading=13, textColor=colors.HexColor('#1E293B')),
    'Analogy': ParagraphStyle('Analogy', fontName='KR-B', fontSize=10, leading=14, textColor=C_AMBER),
    'Bullet': ParagraphStyle('Bullet', fontName='KR', fontSize=8.5, leading=12, textColor=colors.HexColor('#334155')),
    'Code': ParagraphStyle('Code', fontName='KR', fontSize=7.5, leading=10, textColor=C_CODE_TEXT),
    'TableHeader': ParagraphStyle('TH', fontName='KR-B', fontSize=9, leading=12, textColor=colors.white),
    'TableCell': ParagraphStyle('TC', fontName='KR', fontSize=8, leading=11, textColor=C_SECONDARY),
    'TableAnalogy': ParagraphStyle('TCA', fontName='KR-B', fontSize=8, leading=11, textColor=C_PRIMARY),
}

pdf_filename = "src/main/java/com/korai/ch10/TODO/docs/TODO_APP_GUIDE.pdf"
doc = SimpleDocTemplate(
    pdf_filename,
    pagesize=A4,
    leftMargin=15*mm, rightMargin=15*mm,
    topMargin=15*mm, bottomMargin=15*mm
)

story = []

# 표지 & 비유 맵
story.append(Paragraph("📋 TODO 애플리케이션 클래스별 요약 바이블", styles['Title']))
story.append(Spacer(1, 3*mm))
story.append(Paragraph("비전공자도 쉽게 이해하는 일상생활 비유 & 1페이지 요약 가이드 (최신 업데이트 반영)", styles['SubTitle']))
story.append(Spacer(1, 5*mm))

# 비유 테이블
story.append(Paragraph("🗺️ 현실 세계 찰떡 비유 맵", styles['H2']))
story.append(Spacer(1, 2*mm))

table_data = [
    [Paragraph("클래스명", styles['TableHeader']), Paragraph("역할", styles['TableHeader']), Paragraph("현실 세계 찰떡 비유", styles['TableHeader'])],
    [Paragraph("TodoApplication", styles['TableCell']), Paragraph("실행 진입점", styles['TableCell']), Paragraph("🎡 <b>회전목마 모터</b>: 끄기 전까지 화면을 계속 돌려줌", styles['TableAnalogy'])],
    [Paragraph("View (인터페이스)", styles['TableCell']), Paragraph("화면 표준 규격", styles['TableCell']), Paragraph("🔘 <b>전원 버튼 규격</b>: 모든 화면이 똑같이 show()를 갖춤", styles['TableAnalogy'])],
    [Paragraph("RootRouter", styles['TableCell']), Paragraph("조립소 & 라우터", styles['TableCell']), Paragraph("👮 <b>교통경찰 & 조립소</b>: 부품을 조립하고 화면 전환 총괄", styles['TableAnalogy'])],
    [Paragraph("SecurityConfig", styles['TableCell']), Paragraph("보안 설정 (UPDATE)", styles['TableCell']), Paragraph("🎫 <b>출입증 발급기</b>: 로그인 도장 토큰 발급 및 getUserId()", styles['TableAnalogy'])],
    [Paragraph("User", styles['TableCell']), Paragraph("회원 엔티티", styles['TableCell']), Paragraph("🪪 <b>플라스틱 회원 카드</b>: 이름, 아이디, 비밀번호가 적힌 신분증", styles['TableAnalogy'])],
    [Paragraph("TodoStatus (NEW)", styles['TableCell']), Paragraph("상태 열거형", styles['TableCell']), Paragraph("🏷️ <b>3색 상태 스티커</b>: [진행전/진행중/완료] 딱 3가지만 허용", styles['TableAnalogy'])],
    [Paragraph("Todo (UPDATE)", styles['TableCell']), Paragraph("할 일 엔티티", styles['TableCell']), Paragraph("📝 <b>할 일 메모지</b>: 3색 스티커와 작성자 카드가 붙은 종이", styles['TableAnalogy'])],
    [Paragraph("UserRepository", styles['TableCell']), Paragraph("회원 저장소", styles['TableCell']), Paragraph("📖 <b>회원 관리 장부</b>: 도서관 사서의 회원 명부", styles['TableAnalogy'])],
    [Paragraph("TodoRepository (UPDATE)", styles['TableCell']), Paragraph("할 일 저장소", styles['TableCell']), Paragraph("🗄️ <b>할 일 보관함</b>: 번호표 찍기, 내 메모만 골라내기, 상태변경", styles['TableAnalogy'])],
    [Paragraph("UserService", styles['TableCell']), Paragraph("인증 서비스", styles['TableCell']), Paragraph("👮 <b>신분증 검사관</b>: 아이디와 비밀번호를 장부와 대조", styles['TableAnalogy'])],
    [Paragraph("TodoService (UPDATE)", styles['TableCell']), Paragraph("할 일 매니저", styles['TableCell']), Paragraph("🧑‍💼 <b>할 일 총괄 매니저</b>: 내 할 일 조회, 새 메모 등록, 상태변경 지휘", styles['TableAnalogy'])],
    [Paragraph("LoginView", styles['TableCell']), Paragraph("로그인 창구", styles['TableCell']), Paragraph("🚪 <b>입구 창구</b>: 아이디/비밀번호 물어보고 출입증 받기", styles['TableAnalogy'])],
    [Paragraph("TodoListView (UPDATE)", styles['TableCell']), Paragraph("목록 창구", styles['TableCell']), Paragraph("📋 <b>게시판 창구</b>: 내 메모들을 칠판에 보여주고 메뉴 선택", styles['TableAnalogy'])],
    [Paragraph("TodoRegisterView", styles['TableCell']), Paragraph("등록 창구", styles['TableCell']), Paragraph("✍️ <b>메모 접수 창구</b>: 새 할 일 내용을 받아 매니저에게 넘김", styles['TableAnalogy'])],
    [Paragraph("TodoStatusView (NEW)", styles['TableCell']), Paragraph("상태 변경 창구", styles['TableCell']), Paragraph("🏷️ <b>스티커 교체 창구</b>: 메모 번호 골라 3색 스티커로 교체", styles['TableAnalogy'])],
]

col_widths = [45*mm, 35*mm, 100*mm]
t = Table(table_data, colWidths=col_widths)
t.setStyle(TableStyle([
    ('BACKGROUND', (0,0), (-1,0), C_PRIMARY),
    ('ALIGN', (0,0), (-1,-1), 'LEFT'),
    ('VALIGN', (0,0), (-1,-1), 'MIDDLE'),
    ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
    ('ROWBACKGROUNDS', (0,1), (-1,-1), [colors.white, C_BG_LIGHT]),
    ('TOPPADDING', (0,0), (-1,-1), 3),
    ('BOTTOMPADDING', (0,0), (-1,-1), 3),
]))
story.append(t)
story.append(PageBreak())

# 클래스별 상세 1페이지씩 생성하는 헬퍼
cards = [
    {
        "name": "01. TodoApplication.java",
        "analogy": "🎡 현실 비유: 회전목마 모터 (화면을 계속 돌려주는 전원 스위치)",
        "reasons": [
            "RootRouter.setUp() 1회 호출: 프로그램 시작 전 모든 부품(Repo, Service, View)을 한 번에 조립 완료!",
            "while (true) 무한 반복: 콘솔 창이 바로 꺼지지 않고 사용자가 끝낼 때까지 계속 화면을 대기",
            "RootRouter.getCurrentView().show(): 메인은 화면이 무엇이든 다형성으로 한 줄로 실행!"
        ],
        "code": """public class TodoApplication {
    public static void main(String[] args) {
        // [이유 1]: 부품 조립 1회 완료
        RootRouter.setUp();
        // [이유 2]: 화면 지속 대기 이벤트 루프
        while (true) {
            // [이유 3]: 다형성 화면 출력
            RootRouter.getCurrentView().show();
        }
    }
}"""
    },
    {
        "name": "06. TodoStatusView.java (🔥 NEW!)",
        "analogy": "🏷️ 현실 비유: 스티커 교체 창구 (메모지 번호를 골라 [진행전/진행중/완료]로 변경)",
        "reasons": [
            "selectedTodoId 변수: 사용자가 '몇 번 메모 골랐어요'라고 했을 때 그 번호를 기억하기 위한 보관함",
            "try-catch (NumberFormatException): 숫자가 아닌 글자를 쳤을 때 프로그램이 죽지 않고 친절하게 재입력 안내",
            "selectedTodoId == 0 검사: 메모지를 고르지도 않고 상태부터 바꾸려고 할 때 '먼저 TODO를 선택하세요'로 방어"
        ],
        "code": """public class TodoStatusView implements View {
    private int selectedTodoId; // [이유 1]: 선택한 번호 기억

    private void selectedTodo() {
        // [이유 2]: 숫자 변환 예외 안전 처리
        try {
            selectedTodoId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
        }
    }

    private void modificationStatus(TodoStatus todoStatus) {
        // [이유 3]: 미선택 변경 방어
        if (selectedTodoId == 0) {
            System.out.println("먼저 TODO를 선택하세요");
            return;
        }
        todoService.updateStatus(selectedTodoId, todoStatus);
    }
}"""
    },
    {
        "name": "07. SecurityConfig.java (🔥 UPDATE getUserId!)",
        "analogy": "🎫 현실 비유: 출입증 발급기 (도장 찍힌 토큰 발급 및 회원 번호 즉시 확인)",
        "reasons": [
            "uuid + '@' + userId: 난수 뒤에 회원 번호를 적어두어 출입증만 봐도 누구인지 바로 식별 가능",
            "getUserId() 메서드 신설 (NEW): 매번 복잡하게 자르지 않고 getUserId() 한 줄로 내 회원 번호를 추출",
            "static 전역 변수: 프로그램 어디서든 번거롭게 객체를 만들지 않고 바로 로그인 상태를 확인"
        ],
        "code": """public class SecurityConfig {
    private static String loginSession = null;

    // [이유 1]: 난수 뒤에 '@회원번호'를 결합한 토큰 발급
    public static String generateSessionToken(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid + "@" + user.getId();
    }

    // [이유 2: NEW!]: 출입증에서 회원번호만 숫자로 쏙 뽑아 리턴!
    public static int getUserId() {
        String token = loginSession;
        return Integer.parseInt(token.substring(token.indexOf("@") + 1));
    }
}"""
    },
    {
        "name": "10. TodoStatus.java (🔥 NEW Enum!)",
        "analogy": "🏷️ 현실 비유: 3색 상태 규격 스티커 (딱 3가지만 붙일 수 있도록 규격화)",
        "reasons": [
            "문자열 대신 enum을 쓴 이유: '진행중', '진행 중'처럼 오타가 나는 것을 방지하고 딱 3가지로 강제",
            "한글 문구(status) 내장: 화면에 보여줄 때 직관적으로 '진행전', '진행중', '완료' 한글을 꺼내 씀",
            "toString() 오버라이드: 콘솔에 찍을 때 예쁘게 상태 이름이 나오도록 구현"
        ],
        "code": """public enum TodoStatus {
    // [이유 1]: 상태는 딱 3가지만 엄격하게 허용!
    todo("진행전"), inProgress("진행중"), done("완료");

    private String status;

    // [이유 2]: 한글 설명 문구 연결
    TodoStatus(String status) {
        this.status = status;
    }
    public String getStatus() { return status; }
}"""
    },
    {
        "name": "13. TodoRepository.java (🔥 UPDATE findAllByUserId & updateStatus)",
        "analogy": "🗄️ 현실 비유: 할 일 보관함 & 번호표 기계 (번호표 찍고, 내 메모만 골라줌)",
        "reasons": [
            "autoIncrement++: 새 메모지가 들어올 때마다 번호표를 1씩 올려서 자동으로 찍어줌",
            "findAllByUserId (NEW!): 남의 메모는 빼고 '내 회원 번호'와 일치하는 메모만 바구니에 골라 담음",
            "updateStatus (NEW!): 번호표를 찾아 상태 스티커를 새것으로 교체"
        ],
        "code": """public class TodoRepository {
    // [이유 1]: 번호표 자동 증가 후 저장
    public void insert(Todo todo) {
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    // [이유 2: NEW!]: 내 회원번호와 일치하는 메모만 필터링!
    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filtered = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().getId() == userId) filtered.add(todo);
        }
        return filtered;
    }

    // [이유 3: NEW!]: 메모지 찾아 스티커 교체
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) { todo.setStatus(todoStatus); break; }
        }
    }
}"""
    },
    {
        "name": "15. TodoService.java (🔥 UPDATE 내 할 일 조회 & 상태 변경)",
        "analogy": "🧑‍💼 현실 비유: 할 일 총괄 매니저 (출입증 확인, 메모 등록, 스티커 교체 지휘)",
        "reasons": [
            "getTodoList() 진화 (NEW): SecurityConfig.getUserId()를 써서 내 할 일만 골라오도록 변경",
            "register() 간결화 (NEW): getUserId()로 작성자를 찾아 초기 상태(todo)로 깔끔하게 등록",
            "updateStatus() 추가 (NEW): 화면에서 스티커 교체 요청이 들어오면 보관함에 지시"
        ],
        "code": """public class TodoService {
    // [이유 1: NEW!]: 내 출입증 회원번호로 '내 메모'만 골라옴!
    public List<Todo> getTodoList() {
        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    // [이유 2: NEW!]: 내 번호로 회원을 찾아 '진행전' 상태로 등록
    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    // [이유 3: NEW!]: 보관함에 스티커 교체 지시
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        todoRepository.updateStatus(todoId, todoStatus);
    }
}"""
    }
]

for card in cards:
    story.append(Paragraph(card['name'], styles['H1']))
    story.append(Spacer(1, 2*mm))
    story.append(Paragraph(card['analogy'], styles['Analogy']))
    story.append(Spacer(1, 4*mm))

    # 왜 이렇게 코드를 짰는가 박스
    reason_table_data = [
        [Paragraph("📌 왜 이렇게 코드를 짰는가? (비전공자 맞춤 핵심 이유)", styles['TableHeader'])],
    ]
    for r in card['reasons']:
        reason_table_data.append([Paragraph("• " + r, styles['Bullet'])])

    rt = Table(reason_table_data, colWidths=[180*mm])
    rt.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,0), C_PRIMARY),
        ('BACKGROUND', (0,1), (-1,-1), C_BG_LIGHT),
        ('GRID', (0,0), (-1,-1), 0.5, C_BORDER),
        ('TOPPADDING', (0,0), (-1,-1), 4),
        ('BOTTOMPADDING', (0,0), (-1,-1), 4),
        ('LEFTPADDING', (0,0), (-1,-1), 6),
        ('RIGHTPADDING', (0,0), (-1,-1), 6),
    ]))
    story.append(rt)
    story.append(Spacer(1, 4*mm))

    # 코드 박스
    story.append(Paragraph("💻 코드 전문 & 핵심 주석", styles['H2']))
    story.append(Spacer(1, 2*mm))

    code_lines = card['code'].strip().split('\n')
    code_para_list = [Paragraph(line.replace(' ', '&nbsp;'), styles['Code']) for line in code_lines]
    
    code_table = Table([[p] for p in code_para_list], colWidths=[180*mm])
    code_table.setStyle(TableStyle([
        ('BACKGROUND', (0,0), (-1,-1), C_CODE_BG),
        ('TOPPADDING', (0,0), (-1,-1), 1),
        ('BOTTOMPADDING', (0,0), (-1,-1), 1),
        ('LEFTPADDING', (0,0), (-1,-1), 6),
        ('RIGHTPADDING', (0,0), (-1,-1), 6),
    ]))
    story.append(code_table)
    story.append(PageBreak())

doc.build(story)
print("PDF 빌드 성공:", pdf_filename)
