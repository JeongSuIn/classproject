from flask import Flask

# 웹 서버 생성
app = Flask(__name__) #main

# url 매핑
@app.route('/') # 사용자가 url / 요청이 오면 아래 함수가 실행되어 응답한다.
def index():
    return 'Hello! Python'

@app.route('/hello')
def hello():
    return '<h1>/hello 요청의 응답입니다.</h1>'

if __name__ == '__name__':
    app.run(debug=True, port=8000)



