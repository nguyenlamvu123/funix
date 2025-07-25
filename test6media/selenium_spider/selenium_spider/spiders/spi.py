import scrapy
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from shutil import which
import time

class MASpider(scrapy.Spider):
    name = "spi"

    def __init__(self):
        chrome_options = Options()
        # chrome_options.add_argument("--headless")
        # chrome_path = which("chromedriver")  # đảm bảo chromedriver đã cài
        self.driver = webdriver.Chrome(options=chrome_options)
        print()

    def start_requests(self):
        yield scrapy.Request(url='https://vnexpress.net/', callback=self.parse)

    def parse(self, response):
        self.driver.get(response.url)
        time.sleep(3)  # đợi JS tải

        titles = self.driver.find_elements("css selector", "h3.title-news a")
        for title in titles:
            yield {
                'title': title.text,
                'link': title.get_attribute('href')
            }

    def closed(self, reason):
        self.driver.quit()
