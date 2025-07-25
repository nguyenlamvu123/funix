# scrapy crawl spi
from coordinate import *

class MASpider(scrapy.Spider):
    name = nameofpro

    def __init__(self):
        self.driver = chrooome(
            incog=True
        )
        if debug:
            print()

    def sele2jso(self):
        elem = findelem(self.driver, xpath_title)
        title = elem.text
        try:
            elem = findelem(self.driver, xpath_doldbtn)
            download_button = get_in4from_elem(elem, 'href')
        except NoSuchElementException:
            download_button = "No download button"

        elem = findelem(self.driver, xpath_info)
        info = elem.text
        try:
            elem = findelem(self.driver, xpath_mglk)
            magnet_link = get_in4from_elem(elem, 'href')
        except NoSuchElementException:
            magnet_link = "No magnet link"
        eles = findelem(self.driver, xpath_more, getall=True)
        more = list()
        for elem in eles:
            more.append({
                'name': elem.text,
                'href': get_in4from_elem(elem, 'href'),
            })
        return {
                'title': title,
                'download_button': download_button,
                'info': info,
                'magnet_link': magnet_link,
                'more': more,
            }

    def start_requests(self):
        headers = {
            'User-Agent': 'Mozilla/5.0',
        }
        yield scrapy.Request(url=url, callback=self.parse, headers=headers)

    def parse(self, response):
        self.driver.get(response.url)
        time.sleep(5)  # đợi JS tải

        try:
            clickkk(self.driver, xpath_loadmore);print('*')
            clickkk(self.driver, xpath_loadmore);print('**')
        except:
            pass
        eles = findelem(self.driver, xpath_vids, getall=True)
        print(len(eles))
        lis_jso = list()
        for elem in eles[:6]:
            href = get_in4from_elem(elem, 'href')
            self.driver.execute_script("window.open('');")
            self.driver.switch_to.window(self.driver.window_handles[-1])
            self.driver.get(href)
            jso = self.sele2jso()
            lis_jso.append(json.dumps(jso, sort_keys=True, indent=4))
            self.driver.close()
            self.driver.switch_to.window(self.driver.window_handles[0])
        lis2file(lis_jso)
        # for title in titles:
        #     yield {
        #         'title': title.text,
        #         'link': title.get_attribute('href')
        #     }

    def closed(self):
        self.driver.quit()
