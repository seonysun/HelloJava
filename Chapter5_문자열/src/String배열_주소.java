import java.util.Scanner;

public class String배열_주소 {

	public static void main(String[] args) {
		String[] nature = {"홍릉시험림(홍릉숲)","가을단풍길 - 남산남측순환로","화랑대 철도공원","금선사","화랑대 철도공원","마포구 메타세쿼이아 숲길","중랑캠핑숲","난지천공원","개화산","개화산","녹사평역 지하예술정원","어린이대공원 반려견 놀이터","솔밭근린공원","녹사평역 지하예술정원","어린이대공원 반려견 놀이터","백범광장공원","사직공원","노을공원","어린이대공원 반려견 놀이터","백범광장공원","사직공원","여의도 한강공원(소녀시대숲)","어린이대공원","서울숲","하늘공원 야경","하늘공원","서울대공원","낙산공원 야경","낙산공원","홍익문화공원","백악(북악)산 (서울 한양도성)","석촌호수 야경","석촌호수공원","인왕산","선유도 공원","관악산","남산서울타워 야경","노들섬","서소문역사공원","삼천사계곡","진관사계곡","우이동계곡","노들섬","서소문역사공원","삼천사계곡","진관사계곡","우이동계곡","백사실계곡","푸른수목원","배봉산근린공원","백사실계곡","푸른수목원","배봉산근린공원","솔밭근린공원","노을공원","봉산","아차산","서래섬","도봉산","청계천","남산공원","한강","북한산국립공원","여의도 공원","올림픽공원","북서울꿈의숲","보라매공원","양재시민의 숲","여의도샛강생태공원","토성산성어울길","몽촌토성","낙성대 공원","망원 한강공원","월드컵공원","청운공원","불암산","길동생태공원","북악산 야경","서서울호수공원","도산공원","마포대교 바람의 길 & 서울색공원","마로니에공원","현대원서공원","뚝섬유원지","춘당지","효창공원","서리풀 공원","인왕산 야경","월드컵공원 반려견놀이터","응봉산 야경","수성동계곡","지양산","백련산","안산","경의선 숲길","일자산허브천문공원","광진숲나루","서초문화예술공원","서순라길","살곶이길","화랑로 낙엽거리","매봉산 야경","금선사"};
		String[] nature_address = {"02455 서울 동대문구 회기로 57 (청량리동, 국립산림과학원)","04340 서울 용산구 남산공원길 126 (용산동2가)","01802 서울 노원구 화랑로 608 (공릉동) 화랑대 철도공원","03000 서울 종로구 비봉길 137 (구기동, 금선사)","01802 서울 노원구 화랑로 608 (공릉동) 화랑대 철도공원","03900 서울 마포구 하늘공원로 95 (상암동, 탐방객안내소) 메타세쿼이아 숲길","02062 서울 중랑구 망우로87길 110 (망우동, 캠핑장관리소) 중랑캠핑장","03900 서울 마포구 월드컵로 365 (난지천공원 잔디광장매점) 난지천공원 주차장","07601 서울 강서구 양천로 22 (방화동, 개화산역) 개화산","07601 서울 강서구 양천로 22 (방화동, 개화산역) 개화산","04353 서울 용산구 녹사평대로 지하 195 (용산동4가, 6호선 녹사평역)","04991 서울 광진구 능동로 216 (능동, 어린이대공원)","01007 서울 강북구 삼양로 561 (우이동, 솔밭공원 관리실및화장실)","04353 서울 용산구 녹사평대로 지하 195 (용산동4가, 6호선 녹사평역)","04991 서울 광진구 능동로 216 (능동, 어린이대공원)","04633 서울 중구 퇴계로8길 49-4","03027 서울 종로구 사직로9길 5 (사직동, 사직근린공원)","03900 서울 마포구 하늘공원로 84 (상암동, 한국지역난방공사)","04991 서울 광진구 능동로 216 (능동, 어린이대공원)","04633 서울 중구 퇴계로8길 49-4","03027 서울 종로구 사직로9길 5 (사직동, 사직근린공원)","07231 서울특별시 영등포구 여의도 여의서로(윤중로)","04991 서울특별시 광진구 능동로 216, 서울어린이대공원(능동)","04770 서울특별시 성동구 뚝섬로 273 (성수동1가)","03900 서울 마포구 하늘공원로 95 (상암동, 탐방객안내소)","03900 서울 마포구 하늘공원로 95 (탐방객안내소)","13829 경기 과천시 대공원광장로 102 (막계동, 서울대공원)","03085 서울특별시 종로구 낙산길 41","03085 서울 종로구 낙산길 41 (동숭동)","04040 서울 마포구 와우산로21길 19-3 서교빌딩","03038 서울 종로구 옥인6길 26-17","05608 서울 송파구 삼학사로 136 (잠실동)","05608 서울 송파구 삼학사로 136 (서울놀이마당)","110-080 서울특별시 종로구 통일로18가길 20 (무악동)","07200 서울 영등포구 선유로 343 (당산동, 선유도공원)","151-019 서울특별시 관악구 대학동 일대","04340 서울 용산구 남산공원길 105 (용산동2가, YTN서울타워)","04427 서울 용산구 양녕로 445 (이촌동) 노들섬","04510 서울 중구 칠패로 5 (서소문공원)","03308 서울 은평구 연서로54길 127 (진관동, 삼천사) 인근","03308 서울 은평구 진관길 73 (진관동, 진관사)","01000 서울 강북구 삼양로181길 141-5 (우이산장)","04427 서울 용산구 양녕로 445 (이촌동) 노들섬","04510 서울 중구 칠패로 5 (서소문공원)","03308 서울 은평구 연서로54길 127 (진관동, 삼천사) 인근","03308 서울 은평구 진관길 73 (진관동, 진관사)","01000 서울 강북구 삼양로181길 141-5 (우이산장)","03019 서울 종로구 세검정로6길 98","08361 서울 구로구 연동로 240 (항동, 푸른수목원)","02509 서울 동대문구 한천로43길 12-14 (전농동)","03019 서울 종로구 세검정로6길 98","08361 서울 구로구 연동로 240 (항동, 푸른수목원)","02509 서울 동대문구 한천로43길 12-14 (전농동)","01007 서울 강북구 삼양로 561 (우이동, 솔밭공원 관리실및화장실)","03900 서울 마포구 하늘공원로 84 (상암동, 한국지역난방공사)","03424 서울 은평구 서오릉로23길 8-5 (수국사)","04948 서울 광진구 영화사로 135 (아차산등산로 입구)","06500 서울 서초구 신반포로11길 40 (반포동, 한강공원 반포 안내센터)","132-010 서울특별시 도봉구 도봉동 경기 의정부시, 양주시 장흥면 일대","03187 서울 종로구 무교로 37 (서린동)","04628 서울특별시 중구 삼일대로 231","07243 서울 영등포구 여의공원로 68","02700 서울 성북구 보국문로34길 6-21 (정릉동)","07243 서울 영등포구 여의공원로 68 (여의도동, 여의도공원관리사무소)","05540 서울 송파구 올림픽로 424 (방이동, 올림픽공원)","01228 서울특별시 강북구 월계로 173 (번동)","07062 서울 동작구 여의대방로20길 33 (신대방동, 보라매공원)","06773 서울특별시 서초구 매헌로 99 (양재동)","07323 서울 영등포구 여의동로 48 (여의도샛강생태공원 방문자센터)","서울특별시 송파구 올림픽로 424 (방이동) 올림픽공원","05540 서울특별시 송파구 올림픽로 424 (방이동)","08799 서울 관악구 낙성대로 77 (봉천동, 낙성대공원)","04005 서울특별시 마포구 마포나루길 467 (망원동) 한강공원망원지구사무소","03900 서울특별시 마포구 하늘공원로 108-1","서울시 종로구 창의문로 119 (청운동)","01716 서울특별시 노원구 덕릉로94길 73 (중계동)","05291 서울 강동구 천호대로 1291 (길동)","03010 서울 종로구 북악산로 267 (평창동, 북악팔각정)","07916 서울 양천구 남부순환로64길 20 (신월동, 공원관리사무소)","06020 서울 강남구 도산대로45길 20 (도산전시관)","07337 서울 영등포구 여의동로 330 (여의도동, 한강사업본부 여의도안내센터)","03086 서울 종로구 대학로8길 1 (동숭동)","03058 서울특별시 종로구 창덕궁길 19 (원서동)","05097 서울특별시 광진구 강변북로 139 (자양동)","03072 서울 종로구 창경궁로 185 (와룡동, 창경궁)","04311 서울 용산구 효창원로 177-18 (효창공원)","137-070 서울특별시 서초구 서초동 1005-6 서리풀공원","03023 서울 종로구 통일로18나길 3","03901 서울 마포구 증산로 32 (상암동, 안내소)","04743 서울 성동구 독서당로 362 (응봉산팔각정 공중화장실)","03034 서울 종로구 옥인동 185-3 수성동 계곡","08037 서울 양천구 신월동 산 158-1","03651 서울 서대문구 홍은동","서울 서대문구 봉원동 산 2-1","서울시 마포구 연남동","134-060 서울 강동구 둔촌동 산86","04982 서울 광진구 광장로 11","06769 서울 서초구 바우뫼로12길 40 (양재동, 서초문화예술공원)","03139 서울 종로구 종로 지하 129 (1호선 종로3가역)","04792 서울 성동구 광나루로 200","01805 서울특별시 노원구 공릉동 육군사관학교 일대","서울특별시 중구 신당동 매봉산 공원","03000 서울 종로구 비봉길 137 (구기동, 금선사)"};
		String[] shop = {"뚝섬 아름다운 나눔장터","가든파이브라이프","제일시장","증산종합시장","커먼그라운드","고투몰","이태원 앤틱 가구거리","한신옹기","공덕시장","금남시장","연서시장","영천시장","남성사계시장","대림중앙시장","성수동 수제화 거리","카카오프렌즈 홍대 플래그십 스토어","카카오프렌즈 강남 플래그십 스토어","가락몰","숭인시장","더 페이스샵","반디네일 강남본점","에비수","새김소리","회현 중고 LP 상가","명동 쇼핑","제2롯데월드몰","이마트 왕십리점","홍대앞 예술시장 프리마켓","교보 핫트랙스 광화문점","서울약령시장","현대백화점 무역센터점","답십리 고미술상가","용산전자랜드","용산전자상가","어라운드더코너 가로수길점","목동 로데오거리","설화수 플래그십 스토어","젠틀몬스터 홍대 플래그십스토어","아모레 플래그십 스토어 (성수)","서울 중앙시장","해방촌 신흥시장","망원시장","쌈지길","알맹상점","더현대서울","더 피커","디어얼스","상생상회","루미에르 붙임머리","스타일난다 핑크 호텔 (명동 플래그십 스토어)","서초 벼룩시장","명동지하쇼핑센터","센트럴시티","에뛰드하우스","갤러리아백화점 EAST","서초 벼룩시장","명동지하쇼핑센터","센트럴시티","정샘물 인스피레이션","인사동길","남대문시장","광장시장","신사동 가로수길","코엑스몰","롯데백화점 본점","이태원 거리","동대문 쇼핑타운","이대 패션거리","타임스퀘어","통인시장","삼성 딜라이트","롯데 영플라자 명동점","아이파크몰","메세나폴리스","현대백화점 본점","마리오아울렛","신세계백화점 강남점","광희패션몰","이태원 앤티크(가구) 거리","동대문역 창신동 완구 도매 시장","갤러리아백화점 WEST","롯데백화점 에비뉴엘관","동묘 벼룩시장","10 꼬르소 꼬모","종로 귀금속 거리","동대문 헌책방 거리","방학동 도깨비시장","두타(DOOTA)","동화면세점","회현지하쇼핑센터","서울풍물시장","테크노마트","낙원악기상가","명동 M플라자","문정동 로데오거리","청담 패션 거리","에뛰드하우스","갤러리아백화점 EAST","Addicted","라움에디션","SPAO","SPAO","라뷰티코아 청담 세이엇데이점","올리브영 명동 플래그십","스타일난다","핫트랙스 타임스퀘어점","SJYP 가로수길점","K-STAR ROAD 강남 한류스타거리","K-STAR ROAD 강남 한류스타거리","엔터식스 왕십리점","Re:CODE","평화시장","송림수제화","마이시티 상암점","통인가게","평화시장","송림수제화","마이시티 상암점","통인가게","씨제이더마켓 제일제당센터점","신세계면세점","한국관광명품점","정샘물 플롭스","통인가게","씨제이더마켓 제일제당센터점","신세계면세점","한국관광명품점","정샘물 플롭스","레어마켓 (Rare Market)","젠틀몬스터 신사 플래그쉽 스토어","컬처앤네이처","젠틀몬스터 신사 플래그쉽 스토어","컬처앤네이처","자비시주얼리","에이바이봄","이영애화장품 삼청동하우스","마이분 (Myboon)","아티지 (ARTAGE)","아시안무드","아시안무드","서촌구루루","북촌상회　","강남역 지하쇼핑센터","밀리오레 명동점","한사토이"};
		String[] shop_address = {"05097 서울 광진구 강변북로 139 (자양동, 한강사업본부뚝섬안내센터)","05838 서울 송파구 충민로 66 (문정동, 가든파이브라이프)","03397 서울 은평구 통일로 731 (대조동) 제일시장","03500 서울 은평구 증산로3길 12 (증산동) 증산종합시장","05071 서울 광진구 아차산로 200 (자양동) 커먼그라운드","06545 서울 서초구 신반포로 지하 200 (잠원동, 강남터미널지하쇼핑몰)","04391 서울 용산구 보광로 109-1","04338 서울 용산구 신흥로 7 (용산동2가)","04214 서울 마포구 만리재로 19 (공덕동, 공덕시장)","04730 서울 성동구 장터5길 2-15 (금호동3가)","03345 서울 은평구 통일로 850 (불광동, 연서시장)","03734 서울 서대문구 통일로 189-1 (영천동, 동성건물)","06997 서울 동작구 동작대로29나길 10","07419 서울 영등포구 도림천로11길 26-1 (대림동)","04793 서울 성동구 성수동2가","04050 서울 마포구 양화로 162 (동교동, 좋은사람들 빌딩) 좋은사람들빌딩 1~3층","06612 서울 서초구 강남대로 429 (동일빌딩) 유창빌딩 1~3층","05699 서울 송파구 양재대로 932 (가락동, 가락동 농수산물도매시장) 가락몰","142-140 서울특별시 강북구 도봉로 45 (미아동)","04533 서울 중구 을지로 30 롯데백화점 9층","06123 서울 강남구 봉은사로 114 (역삼동, 반디빌딩) 계전빌딩 1, 2층","100-810 서울특별시 중구 명동4길 20","03149 서울특별시 종로구 인사동길 33 (관훈동) 1층","100-747 서울특별시 중구 소공로 63 (충무로1가)","04536 서울 중구 명동8길 27 (명동2가, 엠 플라자)","05551 서울 송파구 올림픽로 300 (신천동)","133-070 서울특별시 성동구 왕십리광장로 17","04041 서울 마포구 와우산로21길 19-3 (서교동)","03154 서울 종로구 종로 1 (종로1가, 교보생명빌딩)","02570 서울 동대문구 약령중앙로 10 (제기동)","135-090 서울특별시 강남구 테헤란로 517 (삼성동)","02603 서울 동대문구 고미술로 21 (답십리동)","04372 서울특별시 용산구 청파로 74 (한강로3가)","04372 서울시 용산구 청파로 74","06028 서울특별시 강남구 압구정로12길 24 (신사동)","서울특별시 양천구 목동로25길","06021 서울 강남구 도산대로45길 18 (신사동)","04048 서울 마포구 독막로7길 54 (서교동)","04797 서울 성동구 아차산로11길 7 (성수동2가, (주)아세아이엔티)","04576 서울 중구 퇴계로85길 36 (황학동)","04337 서울 용산구 신흥로 95-9 (용산동2가) 해방촌 신흥시장","04010 서울 마포구 포은로8길 14 (망원동, 목화맨션) 망원시장","03146 서울 종로구 인사동길 44 (관훈동, 쌈지길)","04023 서울 마포구 월드컵로 49 (합정동) 2층 알맹상점","07335 서울 영등포구 여의대로 108 (여의도동, 파크원)","04768 서울 성동구 왕십리로 115 (성수동1가) 헤이그라운드 서울숲점 9층","03715 서울 서대문구 수색로 43 (남가좌동, 가좌행복주택 복합커뮤니티센터) 104호","03061 서울 종로구 율곡로 39 (안국동) 안국빌딩 신관 1층/B1 층","06029 서울 강남구 압구정로14길 39 (신사동) 루미에르","04536 서울 중구 명동8길 37-8 (충무로2가) 스타일난다 핑크호텔","06693 서울특별시 서초구 방배천로 4길 사당역 공영주차장","04532 서울 중구 소공로 지하 102 (남대문로2가, 소공지하쇼핑센터)","06546 서울 서초구 신반포로 176 (반포동, 센트럴시티빌딩)","04536 서울 중구 명동8길 35-1","06009 서울 강남구 압구정로 407 (압구정동, 갤러리아백화점)","06693 서울특별시 서초구 방배천로 4길 사당역 공영주차장","04532 서울 중구 소공로 지하 102 (남대문로2가, 소공지하쇼핑센터)","06546 서울 서초구 신반포로 176 (반포동, 센트럴시티빌딩)","06016 청담WEST점 : 서울 강남구 도산대로63길 15 (청담동, 아베다빌딩) 청담EAST점 : 서울 강남구 도산대로81길 57","03145 서울 종로구 인사동길 39-1 (관훈동) 일대","04529 서울 중구 남대문시장4길 21 (남창동)","03195 서울 종로구 창경궁로 88","06028 서울 강남구 압구정로 120 일대","06164 서울 강남구 영동대로 513 (코엑스)","04533 서울 중구 남대문로 81 (소공동, 롯데백화점 본점)","서울시 용산구 이태원로 27나길 (이태원동) 일대","04564 서울 중구 장충단로 253 (을지로6가, 헬로우APM)","03766 서울 서대문구 이화여대1길 10 (대현동, 예스에이피엠)","07305 서울 영등포구 영중로 15 (영등포동4가, 타임스퀘어)","03036 서울 종로구 자하문로15길 18","06620 서울 서초구 서초대로74길 11 (삼성전자빌딩)","04532 서울특별시 중구 남대문로 67 (남대문로2가)","140-780 서울특별시 용산구 한강대로23길 55 (한강로3가)","04036 서울특별시 마포구 양화로 45 (서교동, 메세나폴리스)","135-724 서울특별시 강남구 압구정로 165 (압구정동)","08511 서울 금천구 디지털로9길 23 (가산동, 마리오2 패션타워)","서울특별시 서초구 신반포로 176 (반포동)","04567 서울 중구 마장로1길 21 (신당동, 광희 패션물)","서울시 용산구 보광로 103-2 (이태원동) 일대","03120 서울 종로구 종로52길 36 (창신동)","06008 서울 강남구 압구정로 343 (갤러리아백화점)","서울특별시 중구 남대문로 73 (남대문로2가)","03116 서울 종로구 난계로 243 (숭인동)","06015 서울 강남구 압구정로 416 (청담동)","03139 서울 종로구 돈화문로 23 (종로3가)","서울시 중구 장충단로13길 20 (을지로6가)","01358 서울 도봉구 도당로13다길 30 (방학동)","04563 서울 중구 장충단로 275 (을지로6가, 두산타워빌딩)","110-730 서울특별시 종로구 세종대로 149, 광화문빌딩 지하 1층 (세종로)","04535 서울 중구 소공로 지하 58 (충무로1가, 회현지하쇼핑센터)","02586 서울 동대문구 천호대로4길 21 (신설동, 서울풍물시장)","05116 서울 광진구 광나루로56길 85 (구의동 546-4)","110-707 서울특별시 종로구 삼일대로 428 (낙원동)","100-022 서울특별시 중구 명동8길 27 (명동2가)","138-200 서울특별시 송파구 동남로4길 10 (문정동)","06010 서울특별시 강남구 청담동 패션 거리 일대","04536 서울 중구 명동8길 35-1","06009 서울 강남구 압구정로 407 (압구정동, 갤러리아백화점)","06018 서울 강남구 선릉로155길 24","서울특별시 강남구 압구정로 343 갤러리아백화점명품관 WEST 3F","04536 서울 중구 명동8나길 15 (충무로1가, 명동캣츠빌딩)","04536 서울 중구 명동8나길 15 (충무로1가, 명동캣츠빌딩)","06014 서울 강남구 선릉로158길 12","04538 서울특별시 중구 명동길 53 (명동1가)","04053 서울특별시 마포구 와우산로29다길 23 (서교동)","07305 서울 영등포구 영중로 15 (타임스퀘어) 2층 교보문고 핫트랙스","06028 서울 강남구 강남대로160길 45 1층 SJYP 가로수길점","서울특별시 강남구 압구정동 394","서울특별시 강남구 압구정동 394","04750 서울 성동구 왕십리광장로 17 (행당동)","04400 서울 용산구 이태원로 244 (한남동)","04563 서울 중구 청계천로 274 (을지로6가) 평화시장","04543 서울 중구 수표로 60-1 (을지로3가) 3~4층","03926 서울 마포구 상암산로 66 (상암동, CJ E&M CENTER) 1층","03148 서울 종로구 인사동길 32 (관훈동)","04563 서울 중구 청계천로 274 (을지로6가) 평화시장","04543 서울 중구 수표로 60-1 (을지로3가) 3~4층","03926 서울 마포구 상암산로 66 (상암동, CJ E&M CENTER) 1층","03148 서울 종로구 인사동길 32 (관훈동)","04560 서울 중구 동호로 330 (쌍림동, 씨제이제일제당센터) 지하1층","04530 서울 중구 퇴계로 77 (충무로1가, 신세계백화점)","03149 서울 종로구 인사동5길 14 (관훈동)","06028 서울 강남구 압구정로12길 40 (신사동)","03148 서울 종로구 인사동길 32 (관훈동)","04560 서울 중구 동호로 330 (쌍림동, 씨제이제일제당센터) 지하1층","04530 서울 중구 퇴계로 77 (충무로1가, 신세계백화점)","03149 서울 종로구 인사동5길 14 (관훈동)","06028 서울 강남구 압구정로12길 40 (신사동)","06015 서울특별시 강남구 압구정로80길 24","06028 서울 강남구 압구정로10길 23 (신사동)","06062 서울 강남구 도산대로 404 (청담동, 퍼스트빌딩)","06028 서울 강남구 압구정로10길 23 (신사동)","06062 서울 강남구 도산대로 404 (청담동, 퍼스트빌딩)","06017 서울 강남구 압구정로42길 36 (신사동, 금광아크존1) 1층","06016 서울 강남구 선릉로152길 30 (청담동)","03053 서울 종로구 삼청로 67 리아네이처","06062 서울 강남구 도산대로 442 (청담동, 피엔폴루스)","06017 서울 강남구 언주로168길 7 (신사동)","03037 서울 종로구 옥인길 33 (누상동)","03037 서울 종로구 옥인길 33 (누상동)","03040 서울 종로구 필운대로 26 (누하동)","03059 서울 종로구 계동길 37 (계동)","06232 서울 강남구 강남대로 지하 396 (역삼동, 강남역)","04536 서울 중구 퇴계로 115 (충무로1가, 밀레오레 명동)","05551 서울 송파구 올림픽로 300 (신천동, 롯데월드타워앤드롯데월드몰)"};
		
		Scanner scan = new Scanner(System.in);
		System.out.print("지역 입력:");
		String place=scan.next();
		System.out.println("===== 쇼핑 =====");
		for(int i=0;i<shop_address.length;i++) {
			if(shop_address[i].contains(place)) 
					System.out.println(shop[i]);
		}
		System.out.println("===== 자연 =====");
		for(int i=0;i<nature_address.length;i++) {
			if(nature_address[i].contains(place))
				System.out.println(nature[i]);
		}
		System.out.println();
		
	}

}
