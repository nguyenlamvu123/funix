from flask_sqlalchemy import SQLAlchemy


db = SQLAlchemy()

class Account(db.Model):
    __tablename__ = 'accounts'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    login = db.Column(db.String(20), nullable=False, unique=True)
    password = db.Column(db.String(40), nullable=False)
    phone = db.Column(db.String(20))

    def to_dict(self):
        return {
            'id': self.id,
            'login': self.login,
            'password': self.password,
            'phone': self.phone
        }
