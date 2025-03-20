import os


# # test1
# os.system("""curl -X POST http://127.0.0.1:5000/accounts -H "Content-Type: application/json" -d '{"login": "user_1", "password": "1234", "phone": "0987654321"}'""")
# os.system("""curl -X PUT http://127.0.0.1:5000/account/1 -H "Content-Type: application/json" -d '{"phone": "0981654321"}'""")
# os.system("""curl -X DELETE http://127.0.0.1:5000/account/3 -H 'Content-Type: application/json'""")
# os.system("""curl -X GET http://127.0.0.1:5000/accounts -H 'Content-Type: application/json'""")
# os.system("""curl -X GET http://127.0.0.1:5000/account/2 -H 'Content-Type: application/json'""")

# test 2
os.system("""curl -X POST http://127.0.0.1:5000/api/showSerialpaso/ -H "Content-Type: application/json" -d '{"file": "test2", "app_env": 1, "contract_server": 1}'""")
os.system("""curl -X POST http://127.0.0.1:5000/api/showSerialpaso/ -H "Content-Type: application/json" -d '{"file": "test2", "app_env": 0, "contract_server": 1}'""")
