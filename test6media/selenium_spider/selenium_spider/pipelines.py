import pymongo

class SeleniumSpiderPipeline:
    def process_item(self, item, spider):
        return item

class MongoDBPipeline:

    def __init__(
            self,
            mongo_uri,
            mongo_db,
            # mongo_collection
    ):
        self.mongo_uri = mongo_uri
        self.mongo_db = mongo_db
        # self.mongo_collection = mongo_collection

    @classmethod
    def from_crawler(cls, crawler):
        return cls(
            mongo_uri=crawler.settings.get('MONGO_URI'),
            mongo_db=crawler.settings.get('MONGO_DATABASE', 'items'),
            # mongo_collection="quotes"
        )

    def open_spider(self, spider):
        self.client = pymongo.MongoClient(self.mongo_uri)
        self.db = self.client[self.mongo_db]
        # self.collection = self.db[self.mongo_collection]

    def close_spider(self, spider):
        self.client.close()

    def process_item(self, item, spider):
        self.db[spider.name].insert_one(dict(item))  # self.collection.insert_one(dict(item))
        return item
