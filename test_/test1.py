from flask import request, jsonify
from coordinate_constant import app, logger, db
from models_test1 import Account


@app.route('/accounts', methods=['POST'])
def create_account():
    try:
        data = request.get_json()
        login = data.get('login')
        password = data.get('password')
        phone = data.get('phone')

        if any([
            not login,
            not password,
        ]):
            return jsonify({'error': 'Information is uncomplete'}), 400

        new_account = Account(login=login, password=password, phone=phone)
        db.session.add(new_account)
        db.session.commit()

        return jsonify({'message': 'succes when creating account'}), 201
    except Exception as e:
        logger.error(f"error when creating account: {e}")
        return jsonify({'error': 'Internal Server Error'}), 500


@app.route('/account/<int:id>', methods=['PUT'])
def update_account(id):
    try:
        data = request.get_json()
        account = Account.query.get(id)

        if not account:
            return jsonify({'error': 'account is not exists'}), 404

        account.login = data.get('login', account.login)
        account.password = data.get('password', account.password)
        account.phone = data.get('phone', account.phone)

        db.session.commit()

        return jsonify({'message': 'succes when updating account'}), 200
    except Exception as e:
        logger.error(f"error when updating account: {e}")
        return jsonify({'error': 'Internal Server Error'}), 500


@app.route('/account/<int:id>', methods=['DELETE'])
def delete_account(id):
    try:
        account = Account.query.get(id)

        if not account:
            return jsonify({'error': 'account is not exists'}), 404

        db.session.delete(account)
        db.session.commit()

        return jsonify({'message': 'succes when deleting account'}), 200
    except Exception as e:
        logger.error(f"error when deleting account: {e}")
        return jsonify({'error': 'Internal Server Error'}), 500


@app.route('/accounts', methods=['GET'])
def get_accounts():
    try:
        page = request.args.get('page', 1, type=int)
        per_page = request.args.get('per_page', 10, type=int)

        accounts = Account.query.paginate(page=page, per_page=per_page)

        return jsonify({
            'accounts': [account.to_dict() for account in accounts.items],
            'total': accounts.total,
            'pages': accounts.pages,
            'current_page': accounts.page
        }), 200
    except Exception as e:
        logger.error(f"error when getting accounts: {e}")
        return jsonify({'error': 'Internal Server Error'}), 500


@app.route('/account/<int:id>', methods=['GET'])
def get_account(id):
    try:
        account = Account.query.get(id)

        if not account:
            return jsonify({'error': 'account is not exists'}), 404

        return jsonify(account.to_dict()), 200
    except Exception as e:
        logger.error(f"error when getting account: {e}")
        return jsonify({'error': 'Internal Server Error'}), 500


if __name__ == '__main__':
    app.run(debug=True)
