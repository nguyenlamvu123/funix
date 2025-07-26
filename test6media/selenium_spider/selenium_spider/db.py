from pymongo import MongoClient
from coordinate import mongouri, mongodb, nameofpro

# Kết nối đến MongoDB
client = MongoClient(mongouri)
db = client[mongodb]
collection = db[nameofpro]

all_data = collection.find()
# results = collection.find({"text": {"$regex": "An intelligent college", "$options": "i"}})

# In ra kết quả
for item in all_data:
    print(item)
