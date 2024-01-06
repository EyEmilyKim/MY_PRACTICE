from dotenv import load_dotenv
# (# 23.11.06 이후 변경)
from openai import OpenAI # OpenAI 클라이언트를 사용하기 위한 임포트

load_dotenv() # .env 파일 로드

client = OpenAI() # API 클라이언트 인스턴스 생성. API_KEY는 .env 읽어옴
model = "gpt-3.5-turbo" # chatGPT 모델 설정

# 질의 내용
# query = """
# 나의 MBTI : INFP
# 상대방 MBTI : ISFP
# 나의 성별/나이 : 여자/34
# 상대방 성별/나이 : 남자/26
# 관계 : 연인
# 상황 : 만난지 1년된 상황
# 질문 : 1주년 선물로 뭐가 좋을지 추천해줄래? 보통 이 나이대 여자는 남자친구에게 어떤 걸 선물해?
# """

# 질의에 필요한 정보 입력 받기
my_mbti = input("나의 MBTI : ").upper()
your_mbti = input("상대방 MBTI : ").upper()
my_gender_age = input("나의 성별/나이 : ")
your_gender_age = input("상대방 성별/나이 : ")
relation = input("관계 : ")
situation = input("상황 : ")
question = input("질문 : ")

# 질의문 만들기
query = f"""나의 MBTI : {my_mbti}
        상대방 MBTI : {your_mbti}
        나의 성별/나이 : {my_gender_age}
        상대방 성별/나이 : {your_gender_age}
        관계 : {relation}
        상황 :  {situation}
        질문 :  {question}
        앞으로 내가 또 할 질문에 항상 이 정보와 상황을 참고해줘
        """

# 질의 요청 준비
messages = [
    {"role": "system", "content" : "연애코치" },
    {"role": "user", "content" : query }
]

# 질의 요청, 응답 받아오기
response = client.chat.completions.create(
    model=model,        # 필수 
    messages=messages,  # 필수
    temperature=0.6     # 옵션 : 답변의 무작위성
)
answer = response.choices[0].message.content

print(answer) # 응답 출력해보기
