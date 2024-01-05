import openai
import os 
from dotenv import load_dotenv


load_dotenv() # .env 파일 로드
api_key = os.getenv("OPENAI_API_KEY") # API 키 가져오기
# API 키가 있는지 확인
if api_key:
    print("API 키:", api_key) # API를 사용하는 코드 작성
else:
    print("API 키를 찾을 수 없습니다. .env 파일을 확인해주세요.")

openai.api_key = api_key
model = "gpt-3.5-turbo"
