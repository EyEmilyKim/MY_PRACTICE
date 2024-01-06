# 결과값 예시
# 23.11.06 변경 이후 response 해오는 형식도 조금 달라졌다
{
    "id" : "chatcmpl-8UsFXoqbo5YAMgKNbWMTxFbTHz8pJ",
    "object" : "chat.completion",
    "created" : 1702369067,
    "model" : "gpt-3.5-turbo-0613",
    "usage" : {
        "prompt_tokens" : 116, 
        "completion_tokens" : 543, 
        "total_tokens" : 659
    },
    "choices" : [
        {
            "message": {
                "role": "assistant",
                "content": "\uc6b0\uc120, \uc18c\uac1c\ud305\...",
# 이하는 강의 영상에서 안보였지만 위에는 대충 이런 식...
                # ... ,         
            }
        }    
    ],
}

# 그래서 우리의 타겟은
# answer = response.choices[0].message.content
