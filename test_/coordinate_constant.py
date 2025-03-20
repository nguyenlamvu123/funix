from flask import Flask
import os, logging
from logging.handlers import RotatingFileHandler
from logging import Formatter

from models_test1 import db


def create_app():
    app = Flask(__name__)
    app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test1database.db'
    app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

    db.init_app(app)  # Kết nối Flask app với SQLAlchemy
    return app
app = create_app()
with app.app_context():
    db.create_all()

loglevel = logging.WARNING
logger = logging.getLogger('RotatingFileHandler')
logger.setLevel(loglevel)  # DEBUG --> INFO --> WARNING --> ERROR --> CRITICAL
handler = RotatingFileHandler('log_filename.log', maxBytes=5000, backupCount=10)
formatter = Formatter('%(asctime)s - %(levelname)s - %(message)s')
handler.setFormatter(formatter)

logger.addHandler(handler)


root = f"{os.getcwd()}"
appenvtuple = ('AWS', 'K5', 'T2')
contractservertuple = ('app1', 'app2')


dansothanhpho = 500
trenhat = 15
gianhat = 70
