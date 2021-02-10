import requests

url = ('http://newsapi.org/v2/top-headlines?'
       'country=us&'
       'apiKey=6a93b2658e5a4d27ba2d21472056c284')
response = requests.get(url)
print(response.json())  # news API 출력

# 1번 최신뉴스 건수인 totalResults 를 출력하시오.
data = response.json()
print("<최신 뉴스 건수>")
print(data["totalResults"])

# 2번 최신뉴스별 author 를 모두 출력하시오.
print("<author 목록>")
for articles in data['articles']:
    print(articles['author'])