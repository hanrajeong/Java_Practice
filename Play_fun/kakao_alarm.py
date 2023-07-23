'''
pip install request beautifulsoup4 lxml
'''

import requests 
from bs4 import BeautifulSoup
import time
import json

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

from os import rename, listdir

from datetime import datetime 
import time

import csv
import re

KAKAO_TOKEN = "카카오토큰 입력"
send_lists = []

def send_to_kakao(text):
    header = {"Authorization": 'Bearer ' + KAKAO_TOKEN}
    url = "https://kapi.kakao.com/v2/api/talk/memo/default/send"
    post = {
        "object_type": "text",
        "text": text,
        "link": {
            "web_url": "https://developers.kakao.com",
            "mobile_web_url": "https://developers.kakao.com"
        },
    }
    data = {"template_object": json.dumps(post)}
    return requests.post(url, headers=header, data=data)

def crawling_band():
    #chrome_driver = './chromedriver_103_0_5060.exe'
    chrome_driver = '/Users/hanra/Desktop/chromedriver'
    options = Options()
    options.headless = False

    # driver = webdriver.Chrome(executable_path=chrome_driver, options=options)
    driver = webdriver.Chrome(service= Service(ChromeDriverManager().install()))
    driver.implicitly_wait(3)


    driver.get("https://auth.band.us/login_page")

    time.sleep(1)

    #band_home = "https://band.us/band/"
    #band_id = "48320017"  

    driver.get("https://band.us/band/68845833")
    time.sleep(1)
        
    #CSV로 저장
    f = open("write{0}.csv".format(datetime.now().strftime('%Y-%m-%d_%H%M%S')),'w', newline='')
    wr = csv.writer(f)


    while True : 
        try :
            #게시글 작성 시간 추출
            timetag = driver.find_element("xpath", '//*[@id="wrap"]/div[2]/div/div/section/div[2]/div/section/div/div[2]/div/div/a')
            timeT = timetag.text
            
            #일 제거
            idx = timeT.index("일")
            timeT = timeT[0:idx + 1]

            #공백 삭제 및 일자 규칙 변경
            timeT = timeT.replace(" ", "")
            timeT = timeT.replace("년", "-")
            timeT = timeT.replace("월", "-")
            timeT = timeT.replace("일", "")

            #게시글 영역 추출 후 텍스트뷰 정보 추출
            data = driver.find_element("xpath", '//*[@id="wrap"]/div[2]/div/div/section/div[2]/div/section/div/div[3]')
            textLine = data.find_elements(By.CLASS_NAME, "dPostTextView")
                
            # 텍스트 취합
            strData = ""
            for e in textLine :
                strData = strData + e.text + "\n"
                
            print(strData)

            #특수문자 제거
            strData = re.sub(r'[^ ㄱ-ㅣ가-힣A-Za-z]', '', strData)

            # csv 입력
            wr.writerow([timeT, strData])

            # 버튼을 찾아서 없으면 로직 종료(모든 밴드 데이터 수집 완료)
            NextBtn1 = driver.find_element("xpath", '//*[@id="wrap"]/div[2]/div/div/section/button[3]')
            if NextBtn1 : #다음버튼 클릭
                NextBtn1.click()    
            else :  #다음 버튼이 없는경우 반복문 종료
                break
                
            time.sleep(1)

        except Exception as e :
            print(e)
        
    f.close()

def search_slickdeals(condition):
    keyword = condition["keyword"]
    min_price = condition["min_price"]
    max_price = condition["max_price"]

    url = "https://slickdeals.net/newsearch.php?src=SearchBarV2&q={}&searcharea=deals&searchin=first".format(keyword)
    r = requests.get(url)
    bs = BeautifulSoup(r.content, "lxml")
    divs = bs.select("div.resultRow") # select 의 결과는 리스트이다.

    for d in divs:
        images = d.select("img.lazyimg")[0] # select 의 결과는 리스트이다.
        image = images.get("data-original")
        alink = d.select("a.dealTitle")[0]
        href = "https://slickdeals.net" + alink.get("href")
        title = alink.text
        price = float(d.select("span.price")[0].text.replace("$", "").replace("Free", "0"))
        fire = len(d.select("span.icon-fire"))
        
        if min_price < price <= max_price:
            send = True
            for s in send_lists:
                if s["title"] == title:
                    print("보낸적 있음")
                    send = False

            if send:        
                text = "{} {} {} {}".format(title, price, fire, href)
                r = send_to_kakao(text)
                print(r.text)
                send_lists.append({
                    "title": title,
                    "price": price,
                    "fire": fire,
                    "href": href,
                })

if __name__ == "__main__":
    condition = {
        "keyword": "apple ipad",
        "min_price": 100,
        "max_price": 250,
    }
    crawling_band()
    # while True:
    #     search_slickdeals(condition)
    #     time.sleep(60 * 5)