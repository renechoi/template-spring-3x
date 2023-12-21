package kr.rene.template.sampledomain1;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import java.time.Duration;
import java.util.function.Function;

import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */

public class UserGenerationByDifferentMappers extends Simulation {

	Function<Session, String> randomKoreanUsername = session -> {
		String[] lastNames = {
			"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임",
			"안", "배", "백", "바", "박", "방", "변", "차", "채", "창",
			"천", "최", "추", "춘", "충", "태", "탁", "판", "표", "피",
			"한", "함", "허", "현", "홍", "황", "효", "후", "훈", "휴",
			"전", "황", "송", "류", "안", "한", "양", "백", "홍", "고",
			"문", "양", "손", "배", "조", "유", "남", "신", "설", "마",
			"가", "나", "다", "라", "마", "바", "사", "아", "자", "카",
			"태", "훈", "령", "욱", "준", "효", "규", "진", "범", "승",
			"영", "울", "휘", "민", "석", "혁", "원", "현", "란", "온",
			"을", "비", "솜", "등", "녕", "락", "림", "묵", "범", "별",
			"빈", "샘", "애", "언", "연", "영", "온", "옹", "우", "욱",
			"웅", "윤", "은", "의", "이", "익", "인", "일", "임", "재",
			"전", "정", "제", "조", "종", "주", "준", "중", "지", "진",
			"찬", "창", "채", "철", "초", "춘", "치", "탄", "태", "판",
			"하", "한", "해", "헌", "혁", "현", "형", "호", "화", "환",
			"후", "훈", "휘", "역", "먀", "묘", "캬", "쎵", "쫑", "킁"
		};
		String[] firstNames = {
			"민준", "서연", "예은", "지우", "도윤", "시우", "주원", "하윤", "아인", "서준",
			"현우", "지아", "수아", "도하", "지후", "하린", "태희", "민서", "유진", "지현",
			"은지", "재훈", "하늘", "다은", "지안", "선우", "준호", "하연", "윤서", "민재",
			"서준", "예진", "우진", "민아", "지훈", "서현", "예지", "지윤", "나윤", "수현",
			"은우", "준영", "서윤", "지민", "현준", "하준", "도연", "선영", "유나", "지환",
			"준호", "수현", "은지", "재훈", "하늘", "다은", "지안", "선우", "하연", "윤서",
			"민재", "서준", "예진", "우진", "민아", "지훈", "서현", "예지", "지윤", "나윤",
			"진우", "소율", "지안", "윤재", "영민", "세아", "유리", "가은", "준희", "성민",
			"태양", "하람", "윤호", "승민", "정우", "지훈", "혜린", "지혜", "주혁", "성현",
			"경민", "서진", "재욱", "은영", "윤정", "다혜", "지훈", "하람", "민호", "수진",
			"예림", "준혁", "성민", "하은", "재현", "유리", "지은", "태양", "혜수", "동현",
			"윤호", "서아", "준영", "은주", "하나", "성훈", "태민", "다인", "유진", "지혜",
			"윤찬", "진경", "태하", "하랑", "민찬", "선유", "주안", "지란", "현비", "소명",
			"은찬", "영란", "민국", "설아", "다경", "주비", "진아", "현란", "가연", "서경",
			"예랑", "지국", "수란", "하연", "영찬", "준연", "선찬", "유란", "민란", "하경",
			"하민", "유비", "진영", "소연", "태윤", "민솔", "준희", "세린", "윤아", "지후",
			"하진", "설아", "영민", "은별", "주하", "다운", "서율", "지안", "유나", "하영"
		};

		String lastName = lastNames[(int)(Math.random() * lastNames.length)];
		String firstName = firstNames[(int)(Math.random() * firstNames.length)];

		return lastName + firstName;
	};

	{
		ScenarioBuilder scenarioBuilder = scenario(getClass().getSimpleName());
		setUp(createScenario(scenarioBuilder)
			.injectOpen(getOpenInjectionSteps()))
			.protocols(httpProtocolBuilder());
	}

	private HttpProtocolBuilder httpProtocolBuilder() {
		return http
			.baseUrl("http://localhost:25000/rene-template")
			.acceptHeader("application/json")
			.header("Content-Type", "application/json")
			.header("test", "test")
			.userAgentHeader("Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36");
	}

	private ScenarioBuilder createScenario(ScenarioBuilder scenarioBuilder) {
		return scenarioBuilder
			// .exec(session -> session.setAll(createQueryParam()))

			.exec(session -> {
				String username = randomKoreanUsername.apply(session);
				return session.set("username", username);
			})
			.exec(http("object-mapper")
				.put("/user/object-mapper")
				.body(StringBody(session -> createRequestBody(session.getString("username")))).asJson())

			.exec(session -> {
				String username = randomKoreanUsername.apply(session);
				return session.set("username", username);
			})
			.exec(
				http("model-mapper")
					.put("/user/model-mapper")
					.body(StringBody(session -> createRequestBody(session.getString("username")))).asJson())

			.exec(session -> {
				String username = randomKoreanUsername.apply(session);
				return session.set("username", username);
			})
			.exec(
				http("map-struct")
					.put("/user/map-struct")
					.body(StringBody(session -> createRequestBody(session.getString("username")))).asJson())

			.exec(session -> {
				String username = randomKoreanUsername.apply(session);
				return session.set("username", username);
			})
			.exec(
				http("builder")
					.put("/user/builder")
					.body(StringBody(session -> createRequestBody(session.getString("username")))).asJson())

			.pause(Duration.ofSeconds(1));
	}

	private String createRequestBody(String username) {
		return """
			{
			    "username": "%s",
			    "createdBy": "userId1",
			    "email": "cheolsoo@example.com",
			    "password": "mypassword321",
			    "isActive": true,
			    "profile": {
			        "firstName": "%s",
			        "lastName": "%s",
			        "dateOfBirth": "1985-05-15"
			    },
			    "settings": {
			        "language": "ko",
			        "timezone": "Asia/Seoul"
			    },
			    "contactInfo": {
			        "phoneNumber": "+821012345678",
			        "address": "서울특별시 강남구 테헤란로 123"
			    }
			}""".formatted(username, username.substring(0, 1), username.substring(1, 3));
	}

	private OpenInjectionStep[] getOpenInjectionSteps() {
		return new OpenInjectionStep[] {
			rampUsersPerSec(1).to(5).during(36*5),
			constantUsersPerSec(5).during(72*5),
			rampUsersPerSec(5).to(1).during(36*5)
		};
	}
}
