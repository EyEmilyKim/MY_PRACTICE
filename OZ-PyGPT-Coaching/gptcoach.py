from dotenv import load_dotenv
# (# 23.11.06 이후 변경)
from openai import OpenAI # OpenAI 클라이언트를 사용하기 위한 임포트

load_dotenv() # .env 파일 로드

client = OpenAI() # API 클라이언트 인스턴스 생성. API_KEY는 .env 읽어옴
model = "gpt-3.5-turbo" # chatGPT 모델 설정

# 질의에 필요한 정보 입력 받기
my_mbti = input("\n> 나의 MBTI : ").upper()
your_mbti = input("> 상대방 MBTI : ").upper()
my_gender_age = input("> 나의 성별/나이 : ")
your_gender_age = input("> 상대방 성별/나이 : ")
relation = input("> 관계 : ")
situation = input("> 상황 : ")
question = input("> 질문 : ")

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

print("\n답변을 준비중입니다...")
          
# 질의 요청, 응답 받아오기
response = client.chat.completions.create(
    model=model,        # 필수 
    messages=messages,  # 필수
    temperature=0.6     # 옵션 : 답변의 무작위성
)
answer = response.choices[0].message.content

print("\n=============================\n")
print(answer) # 응답 출력해보기
# print("답변 왔다~~~~~♡♡♡\n\n")
print("\n=============================\n")

# 챗봇의 응답을 메세지 배열에 추가
messages.append({"role": "assistant", "content" : answer})
# # 실행... ->
# # messages = [
# #     {"role": "system", "content" : "연애코치" },
# #     {"role": "user", "content" : query },
# #     {"role": "assistant", "content" : answer}
# # ]

while True:
    # 사용자로부터 질문 받기
    q = input("> 질문 : ")
    query2 = f"Q: {q}"

    messages.append({"role": "user", "content" : query2})
    # # 실행... ->
    # # messages = [
    # #     {"role": "system", "content" : "연애코치" },
    # #     {"role": "user", "content" : query },
    # #     {"role": "assistant", "content" : answer},
    # #     {"role": "user", "content" : query2}
    # # ]
    
    print("\n답변을 준비중입니다...")
    
    # 에러 핸들링
    try: 
        response = client.chat.completions.create(
            model=model, messages=messages, temperature=0.6
        )
        answer = response.choices[0].message.content
        print("\n=============================\n")
        print(answer)
        # print("답변 왔다~~~~~♡♡♡\n\n")
        print("\n=============================\n")
        messages.append({"role": "assistant", "content" : answer})
        print("\n=============================\n")  
    except client.APIConnectionError as e : 
        print("서버에 연결할 수 없습니다.")
        print(e)
    except client.RateLimitError as e : 
        print("API 요청 한도를 초과했습니다. 잠시 후 다시 시도하세요.")
        print(e)
    except client.APIStatusError as e : 
        print("API 오류 발생: ", e.status_code)
        print(e.response)

    # 추가 질문 확인
    while True:
        print("\n=============================\n")
        q = input("> 더 하실 질문이 있나요? (y/n) : ").lower()
        if q in ["y", "n", "ㅛ", "ㅜ"]:
            break
        else:
            print("\n유효한 입력이 아닙니다. 다시 입력해주세요.")
    if q in ["n", "ㅜ"]:
        print("\n즐거운 연애하시길 바랍니다♡ 세션을 종료합니다.\n")
        break
