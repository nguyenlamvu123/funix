from flask import Flask, request, jsonify
import os, base64
from coordinate_constant import root, appenvtuple, contractservertuple


app = Flask(__name__)

@app.route('/api/showSerialpaso/', methods=['POST'])
def show_serialpaso():
    if request.headers.get('Content-Type') != 'application/json':
        return jsonify({"success": False, "message": "Invalid Content-Type"}), 400

    data = request.json

    # Extract and validate required parameters
    file = data.get('file')
    app_env = data.get('app_env')
    contract_server = data.get('contract_server')

    if file is None or not isinstance(file, str) or len(file) > 128:
        return jsonify({"success": False, "message": "Invalid 'file' parameter"}), 400

    if app_env is None or not isinstance(app_env, int):
        return jsonify({"success": False, "message": "Invalid 'app_env' parameter"}), 400

    if contract_server is None or not isinstance(contract_server, int):
        return jsonify({"success": False, "message": "Invalid 'contract_server' parameter"}), 400


    # Execution logic here (dummy data for demonstration)
    filename = f"{file}.html"
    filepath = f'{root}{os.sep}{appenvtuple[app_env]}{os.sep}{contractservertuple[contract_server]}{os.sep}{filename}'
    if not os.path.exists(filepath):
        return jsonify({"success": False, "filename": "", 'message': "Seal Info response false"}), 400

    with open(filepath, 'rb') as f:
        file_bytes = f.read()
        content = base64.b64encode(file_bytes).decode('utf-8')
    return jsonify({
        "success": True,
        "filename": filename,
        "content": content,
        "message": "Seal Info response successfully"
    }), 200

if __name__ == '__main__':
    app.run(debug=True)
