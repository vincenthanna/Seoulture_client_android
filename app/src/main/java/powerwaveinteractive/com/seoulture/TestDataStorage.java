package powerwaveinteractive.com.seoulture;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.security.Key;
import java.util.ArrayList;
import java.util.Dictionary;

import powerwaveinteractive.com.seoulture.CultureItem;
import powerwaveinteractive.com.seoulture.ReviewItem;

/**
 * Created by vincenthanna on 8/27/14.
 */
public class TestDataStorage {
    public ArrayList<CultureItem> _cultures;
    public ArrayList<ReviewItem> _reviews;
    public MainActivity activity;

    public TestDataStorage(MainActivity activity) {
        _cultures = new ArrayList<CultureItem>();
        _reviews = new ArrayList<ReviewItem>();
        this.activity = activity;
        buildTestData();
    }

    public CultureItem getCultureItemById(int id) {
        for(int i = 0; i < _cultures.size(); i++) {
            if (_cultures.get(i).id == id) {
                return _cultures.get(i);
            }
        }
        return null;
    }

    public ArrayList<ReviewItem> getReviews(int cultureId) {
        ArrayList<ReviewItem> reviewItems = new ArrayList<ReviewItem>();
        for(int i = 0; i < _reviews.size(); i++) {
            if (_reviews.get(i).cultureItemId == cultureId) {
                reviewItems.add(_reviews.get(i));
            }
        }
        return reviewItems;
    }

    public void buildTestData()
    {
        {
            CultureItem item;
            Bitmap bImg;
            int id = 0;
            item = new CultureItem(id++, "남산골한옥마을 세시맞이<오(五)대감 한가위 잔치>","남산골 한옥마을에서 더욱 풍성하고 즐거운 명절 추석을 즐겨보자!\n" +
                    "\n" +
                    "남산골 한옥마을에서 특별한 추석을 맞이할 수 있는 \"오대감 한가위잔치\"를 준비했다.\n" +
                    "세시풍속, 세시놀이, 민속놀이 체험 등 다채로운 추석맞이 프로그램을 즐길 수 있는 오대감 한가위잔치에 오면 판소리 '눈대목열창', '강강술래', '각설이 놀음'등 신명나는 특별공연도 준비되어 있다.\n" +
                    "또한 9월 9일~10일 <평롱[平弄]: 그 평안한 떨림> 공연 50% 특별할인 등 다양한 볼거리들이 가득하다.");
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img1_0);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img1_1);item.bitmaps.add(bImg);
            _cultures.add(item);

            item = new CultureItem(id++, "한일축제마당 in 2014", "한일교류 축제의 장 '한일축제한마당'\n" +
                    " \n" +
                    "올해 ‘한일축제한마당’은 ‘축제 10년, 꿈을 싣고’를 테마로 9월 14일(일) COEX 전시장 C홀에서 개최된다. 한국과 일본의 무대공연을 비롯해서, 다양한 관광・체험 부스와 기업 부스 등을 적극 유치하여 보다 풍성한 축제를 마련했다. \n" +
                    "\n" +
                    "공식사회자는 한국에서도 많은 인기를 얻고 있는 후지이 미나(藤井美菜)와 오카와 노부코(大川信子) 그리고 김재홍, 한상헌, 강승화 KBS 아나운서가 1,2,3부로 나누어 진행할 예정이다. \n" +
                    "\n" +
                    "스페셜 게스트는 <노다메 칸타빌레>의 주인공 ‘노다 메구미’를 연기하며 한국에서도 많은 팬을 확보하고 있는 ‘우에노 주리(上野樹里)’와 영화 <냉정과 열정 사이>의 사운드트랙으로 한국에서도 널리 알려진 작곡가 요시마타 료(吉俣良)의 공연이 진행될 예정이다.\n" +
                    "\n" +
                    "● 테 마: 축제 10년, 꿈을 싣고\n" +
                    "● 슬로건: 즐거운 축제, 즐거운 만남, 즐기는 우리");
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img2_0);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img2_1);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img2_2);item.bitmaps.add(bImg);
            _cultures.add(item);


            item = new CultureItem(id++, "서울드럼페스티벌", "2014년 서울드럼페스티벌 행사 내용\n" +
                    "\n" +
                    "소통하는 어울림, 타악으로 하나되는 우리 (Beat it, Enjoy it, Feel it) \n" +
                    " \n" +
                    "1. 행사개요\n" +
                    " ○ 행 사 명 : 제 16회 서울드럼페스티벌 2014\n" +
                    " ○ 행사기간 : 2014. 9. 12(금) ~ 9. 13(토)\n" +
                    " ○ 장 소 : 추후공지, 신촌 연세로\n" +
                    " ○ 주 제 : 소통하는 어울림, 타악으로 하나되는 우리 (Beat it, Enjoy it, Feel it)\n" +
                    " ○ 행사내용 : 무대공연, 부대행사, 전시/체험\n" +
                    " \n" +
                    "2. 프로그램\n" +
                    " ○ 무대공연\n" +
                    "  - 해외 공연팀 : Thomas Lang, Luke Holland, Hands Percussion, Now vs Now\n" +
                    "  - 국내 공연팀 : 드럼캣, 행드럼 아티스트, 난타, 두드락 \n" +
                    "   『공연일자: 9월12일(금) ~ 13일(토) 19:30~21:30 / 공연장소: 추후공지』\n" +
                    "○ 부대행사\n" +
                    "  - 뮤직스쿨\n" +
                    "  ● 미래 소리의 주인공, 세계적인 드러머로 성장할 청소년들의 꿈의 축제, 꿈의 무대\n" +
                    "   『공연일자: 9월13일(토) 15:00~16:00 / 공연장소: 추후공지』\n" +
                    "  - 인디밴드 공연\n" +
                    "  ● 남녀노소 모두가 즐겁고 편하게 관람할 수 있는 인디 밴드 공연\n" +
                    "   『행사일시: 9월13일(토) 14:00 ~ 15:00 / 공연장소: 신촌연세로』\n" +
                    "  - 타악기 체험관\n" +
                    "  ●Zone 5.전자악기 체험관\n" +
                    "   전기의 증폭이나 완화와 같은 일반적인 수단을 통하여 소리를 내는 가장 현대적인 악기들로서 일렉기타, 베이스기타, 전자드럼, 신디사이저로   즉흥 연주까지도 체험 할 수 있다.\n" +
                    "  ●Zone 6.걸리버 피아노 체험관\n" +
                    "   동화에서만 볼 수 있을 것 같은 어마어마한 크기의 피아노가 내 발앞에 펼쳐진다. 건반 위를 걸으며 연주도 체험하고 신비의 세계로 빠져보자.\n" +
                    "  ●Zone 7.드럼세트 체험관\n" +
                    "   전시체험관에서 가장 인기 있는 악기로서 멜로디 악기처럼 소리를 내기가 어렵지 않고 초보자도 쉽게 연주할 수 있는 타악기의 왕자 드럼세트!\n" +
                    "  - 타악기 전시관 Percussion Exhibition\n" +
                    "  ●평소에 볼 수 없는 전 세계 신기한 타악기를 직접 볼 수 있으며, 세계 타악기를 각각의 주제에 맞게 전시하였다. (오케스트라 /효과 타악기 관,   국악/민속 타악기 관, 라틴 타악기 관, 전자/교육 타악기 관 등)\n" +
                    "   『행사일시: 9월12일(금)~13일(토) 11:00 ~ 18:00 / 공연장소: 추후공지");
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img3_0);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img3_1);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img3_2);item.bitmaps.add(bImg);
            _cultures.add(item);

            item = new CultureItem(id++, "2014 서울 문화의 밤", "서울의 이색 명소체험과 음악, 캠핑 등 다양한 문화 프로그램이 함께 어우러진 서울의 대표적인 여름축제, ‘2014 서울 문화의 밤’이 8월 29일(금)에서 20일(토)까지 2일간, 서울광장 및 청계광장, 시민청 등에서 펼쳐진다.\n" +
                    " \n" +
                    "서울의 중심 지역에서 서울의 역사와 문화, 예술을 향유할 수 있는 축제인 ‘2014년 서울 문화의 밤’은, 시민과 국내외 관광객들이 주체가 되고 함께 어우러져, 서울의 숨은 공간에서 다양한 프로그램을 즐기고 서울의 이야기를 나누는 축제이다.\n" +
                    " \n" +
                    "올해 축제에서는 서울을 대표하는 다양한 건축 및 시설을 탐방하는 ‘오픈 하우스 서울’, 서울광장 등 서울의 중심에서 개최되는 다양한 장르의 시민 참여형 음악 공연인 ‘서울 뮤직 페스티벌’, 서울광장에서 캠핑을 즐기고 명사와 문화 데이트를 즐기는 이색적인 문화예술 체험 프로그램인 ‘문화상상 프로젝트’ 등 다양한 프로그램이 진행된다.\n" +
                    " \n" +
                    "◦ 행사명 : 2014 서울문화의 밤\n" +
                    "◦ 일 시 : 2014. 8. 29(금) ~ 30(토), 2일간\n" +
                    "◦ 장 소 : 서울광장, 청계광장, 시민청 및 해당 프로그램 진행 지역\n" +
                    "◦ 주 최 : 서울특별시\n" +
                    "◦ 행사구성(세부 프로그램은 행사 홈페이지 참조)\n" +
                    "- 오픈 하우스 서울 : 서울을 대표하는 다양한 건축 및 시설 탐방\n" +
                    "- 서울 뮤직 페스티벌 : 서울 중심부(서울광장 등)에서 개최되는 다양한 장르의 시민 참여형 음악 공연\n" +
                    "- 문화상상 프로젝트, 상상 플러스 : 서울광장 캠핑, 명사초청 문화데이트 등 이색적인 문화예술 체험 프로그램\n" +
                    "◦ 홈페이지 : www.seoulopenweek.com\n" +
                    "◦ 문 의 : 02.6939.7890~3");
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_00);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_01);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_02);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_03);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_04);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_05);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_06);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_07);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_08);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_09);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_10);item.bitmaps.add(bImg);
            _cultures.add(item);


            item = new CultureItem(id++, "2014 인천 문화의 밤", "서울의 이색 명소체험과 음악, 캠핑 등 다양한 문화 프로그램이 함께 어우러진 서울의 대표적인 여름축제, ‘2014 서울 문화의 밤’이 8월 29일(금)에서 20일(토)까지 2일간, 서울광장 및 청계광장, 시민청 등에서 펼쳐진다.\n" +
                    " \n" +
                    "서울의 중심 지역에서 서울의 역사와 문화, 예술을 향유할 수 있는 축제인 ‘2014년 서울 문화의 밤’은, 시민과 국내외 관광객들이 주체가 되고 함께 어우러져, 서울의 숨은 공간에서 다양한 프로그램을 즐기고 서울의 이야기를 나누는 축제이다.\n" +
                    " \n" +
                    "올해 축제에서는 서울을 대표하는 다양한 건축 및 시설을 탐방하는 ‘오픈 하우스 서울’, 서울광장 등 서울의 중심에서 개최되는 다양한 장르의 시민 참여형 음악 공연인 ‘서울 뮤직 페스티벌’, 서울광장에서 캠핑을 즐기고 명사와 문화 데이트를 즐기는 이색적인 문화예술 체험 프로그램인 ‘문화상상 프로젝트’ 등 다양한 프로그램이 진행된다.\n" +
                    " \n" +
                    "◦ 행사명 : 2014 서울문화의 밤\n" +
                    "◦ 일 시 : 2014. 8. 29(금) ~ 30(토), 2일간\n" +
                    "◦ 장 소 : 서울광장, 청계광장, 시민청 및 해당 프로그램 진행 지역\n" +
                    "◦ 주 최 : 서울특별시\n" +
                    "◦ 행사구성(세부 프로그램은 행사 홈페이지 참조)\n" +
                    "- 오픈 하우스 서울 : 서울을 대표하는 다양한 건축 및 시설 탐방\n" +
                    "- 서울 뮤직 페스티벌 : 서울 중심부(서울광장 등)에서 개최되는 다양한 장르의 시민 참여형 음악 공연\n" +
                    "- 문화상상 프로젝트, 상상 플러스 : 서울광장 캠핑, 명사초청 문화데이트 등 이색적인 문화예술 체험 프로그램\n" +
                    "◦ 홈페이지 : www.seoulopenweek.com\n" +
                    "◦ 문 의 : 02.6939.7890~3");
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_00);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_01);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_02);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_03);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_04);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_05);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_06);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_07);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_08);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_09);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_10);item.bitmaps.add(bImg);
            _cultures.add(item);

            item = new CultureItem(id++, "2014 부산 문화의 밤", "서울의 이색 명소체험과 음악, 캠핑 등 다양한 문화 프로그램이 함께 어우러진 서울의 대표적인 여름축제, ‘2014 서울 문화의 밤’이 8월 29일(금)에서 20일(토)까지 2일간, 서울광장 및 청계광장, 시민청 등에서 펼쳐진다.\n" +
                    " \n" +
                    "서울의 중심 지역에서 서울의 역사와 문화, 예술을 향유할 수 있는 축제인 ‘2014년 서울 문화의 밤’은, 시민과 국내외 관광객들이 주체가 되고 함께 어우러져, 서울의 숨은 공간에서 다양한 프로그램을 즐기고 서울의 이야기를 나누는 축제이다.\n" +
                    " \n" +
                    "올해 축제에서는 서울을 대표하는 다양한 건축 및 시설을 탐방하는 ‘오픈 하우스 서울’, 서울광장 등 서울의 중심에서 개최되는 다양한 장르의 시민 참여형 음악 공연인 ‘서울 뮤직 페스티벌’, 서울광장에서 캠핑을 즐기고 명사와 문화 데이트를 즐기는 이색적인 문화예술 체험 프로그램인 ‘문화상상 프로젝트’ 등 다양한 프로그램이 진행된다.\n" +
                    " \n" +
                    "◦ 행사명 : 2014 서울문화의 밤\n" +
                    "◦ 일 시 : 2014. 8. 29(금) ~ 30(토), 2일간\n" +
                    "◦ 장 소 : 서울광장, 청계광장, 시민청 및 해당 프로그램 진행 지역\n" +
                    "◦ 주 최 : 서울특별시\n" +
                    "◦ 행사구성(세부 프로그램은 행사 홈페이지 참조)\n" +
                    "- 오픈 하우스 서울 : 서울을 대표하는 다양한 건축 및 시설 탐방\n" +
                    "- 서울 뮤직 페스티벌 : 서울 중심부(서울광장 등)에서 개최되는 다양한 장르의 시민 참여형 음악 공연\n" +
                    "- 문화상상 프로젝트, 상상 플러스 : 서울광장 캠핑, 명사초청 문화데이트 등 이색적인 문화예술 체험 프로그램\n" +
                    "◦ 홈페이지 : www.seoulopenweek.com\n" +
                    "◦ 문 의 : 02.6939.7890~3");
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_00);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_01);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_02);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_03);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_04);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_05);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_06);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_07);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_08);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_09);item.bitmaps.add(bImg);
            bImg = BitmapFactory.decodeResource(activity.getResources(),R.drawable.img4_10);item.bitmaps.add(bImg);
            _cultures.add(item);
        }

        {
            ReviewItem item;
            int id = 0;
            item = new ReviewItem(id++, 0,"김보성","의리 때문에...", "의리 때문에 봤다 \n 의리 때문에... \n아......", 1.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"정우성","홍보대사라서...", "의리 때문에 봤다 \n 의리 때문에... \n아......", 1.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"이효리","허 참...", "이게 뭐시여.", 1.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 1.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 5.0);_reviews.add(item);
            item = new ReviewItem(id++, 0,"장동건","준비가 부족했음.", "많은 아쉬움이 남는 행사였네요\n다음에는 좀 더 잘 준비하길\n바랍니다.", 1.0);_reviews.add(item);

            item = new ReviewItem(id++, 1,"정우성","good!", "완전 끝내줍니다.\n잘봤어요!", 5.0);_reviews.add(item);
            item = new ReviewItem(id++, 1,"이민기","괜찮네요.", "Fantastic!", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 1,"이효리","주차가...", "놀랍구먼!\n두번 봣음.\n근데 주차장이 좀 부족 했습니다.\n다음에는 신경써 주세요.", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 1,"장동건","이번행사 홍보대사 입니다.", "반갑습니다!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 1,"장동건","이번행사 홍보대사 입니다.", "반갑습니다!", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 1,"장동건","이번행사 홍보대사 입니다.", "반갑습니다!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 1,"장동건","이번행사 홍보대사 입니다.", "반갑습니다!", 3.0);_reviews.add(item);

            item = new ReviewItem(id++, 3,"정우성","주차하느라 시간이 오래 걸렸네요.", "완전 끝내줍니다.\n잘봤어요!\n다음에는 주차공간도 신경써주세요.", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이민기","홍보대사 이민기입니다.", "Fantastic!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 5.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 3,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);

            item = new ReviewItem(id++, 4,"정우성","주차하느라 시간이 오래 걸렸네요.", "완전 끝내줍니다.\n잘봤어요!\n다음에는 주차공간도 신경써주세요.", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이민기","홍보대사 이민기입니다.", "Fantastic!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이민기","홍보대사 이민기입니다.", "Fantastic!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이민기","홍보대사 이민기입니다.", "Fantastic!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이민기","홍보대사 이민기입니다.", "Fantastic!", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 4,"이효리","허 참...", "이게 뭐시여.", 1.0);_reviews.add(item);


            item = new ReviewItem(id++, 5,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 4.0);_reviews.add(item);
            item = new ReviewItem(id++, 5,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 5.0);_reviews.add(item);
            item = new ReviewItem(id++, 5,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 2.0);_reviews.add(item);
            item = new ReviewItem(id++, 5,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 1.0);_reviews.add(item);
            item = new ReviewItem(id++, 5,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 3.0);_reviews.add(item);
            item = new ReviewItem(id++, 5,"이효리","홍보대사 이효리입니다.", "제주도에서 오느라 늦었네요.\n좋은구경 하고 가세요~", 3.0);_reviews.add(item);
        }
    }
}
