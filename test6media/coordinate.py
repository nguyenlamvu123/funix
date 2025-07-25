from dotenv import load_dotenv

import os, time, datetime, json  # , pyautogui, webbrowser, threading, json, requests,
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException, ElementClickInterceptedException
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

import scrapy

load_dotenv()

xpath_loadmore = os.getenv("xpath_loadmore")
xpath_vids = os.getenv("xpath_vids")
nameofpro = os.getenv("nameofpro")
xpath_title = os.getenv("xpath_title")
xpath_doldbtn = os.getenv("xpath_doldbtn")
xpath_mglk = os.getenv("xpath_mglk")
xpath_info = os.getenv("xpath_info")
xpath_more = os.getenv("xpath_more")
url = os.getenv("url")
debug = bool(os.getenv("debug"))


def lis2file(jso):
    now = datetime.datetime.now()
    jsofile = f'{now.strftime("%Y%m%d_%H%M%S")}.jso'
    with open(jsofile, "w", encoding="utf-8") as f:  # lưu dữ liệu đã trích xuất vào file trong local
        json.dump(jso, f, ensure_ascii=False, indent=4)


def findelem(driver, xpath, scroll: bool = False, getall: bool = False):
    element = []
    lan = 0
    if scroll:
        # https://stackoverflow.com/questions/20986631/how-can-i-scroll-a-web-page-using-selenium-webdriver-in-python
        # driver.execute_script("window.scrollTo(0, 30)")
        # html = driver.find_element(By.TAG_NAME, 'html')
        # html.send_keys(Keys.END)
        for _ in range(5):
            driver.execute_script("window.scrollTo(0, window.scrollY + 1500)")
            time.sleep(3)
    while len(element) == 0:
        element = driver.find_elements(By.XPATH, xpath)
        lan += 1
        if lan > 3:
            raise NoSuchElementException
        time.sleep(1)
    if not getall: return element[0]
    return element


def get_in4from_elem(
        elem,
        fie: str = 'outerHTML',
        # fie: str = 'innerhtml'
):
    return elem.get_attribute(fie)


def clickkk(driver, xpath):
    element = findelem(driver, xpath)
    try:
        element.click()  # TODO: check elem clicked or not
    except ElementClickInterceptedException:  # https://stackoverflow.com/questions/57741875/selenium-common-exceptions-elementclickinterceptedexception-message-element-cl:
        pass
        # print_on_gui("ElementClickInterceptedException", text_widget=text_widget)
    try:
        driver.execute_script("arguments[0].click();", element)
    except Exception as e:
        pass


def sendkkkeys(driver, xpath, cont, enter=True):
    element = findelem(driver, xpath)
    element.send_keys(cont)
    if not enter:
        return
    time.sleep(3)  # Thời gian chờ trước khi gửi nội dung
    element.send_keys(Keys.RETURN)
    time.sleep(3)  # Thời gian chờ trước khi gửi nội dung


def perform_actions(driver, keys):
    actions = ActionChains(driver)
    actions.send_keys(keys)
    time.sleep(2)
    print('Performing Actions!')
    actions.perform()


def delete_cache(driver):
    driver.execute_script("window.open('')")  # Create a separate tab than the main one
    driver.switch_to.window(driver.window_handles[-1])  # Switch window to the second tab
    driver.get('chrome://settings/clearBrowserData')  # Open your chrome settings.
    perform_actions(driver, Keys.TAB * 2 + Keys.DOWN * 4 + Keys.TAB * 5 + Keys.ENTER)  # Tab to the time select and key down to say "All Time" then go to the Confirm button and press Enter
    driver.close()  # Close that window
    driver.switch_to.window(driver.window_handles[0])  # Switch Selenium controls to the original tab to continue normal functionality.


def chrooome(PROXY: str or None = None, incog: bool = False):
    options = webdriver.ChromeOptions()
    if PROXY is not None:
        options.add_argument('--proxy-server=%s' % PROXY)
    options.add_argument("--start-maximized")

##    options.add_argument("--window-size=1000,1080")
##    options.add_argument("--window-position=1000,0")
    options.add_argument("--disable-notifications")
    options.add_argument("--disable-infobars")
##    disable the banner "Chrome is being controlled by automated test software"
    options.add_argument("--disable-extensions")
    options.add_argument("--disable-popup-blocking")
    # Pass the argument 1 to allow and 2 to block
    options.add_experimental_option("prefs", {
        "profile.default_content_setting_values.notifications": 2
        })
    if incog:
        options.add_argument("--incognito")
    else:
        options.add_argument('--headless')
    return webdriver.Chrome(
        options=options,
        )
